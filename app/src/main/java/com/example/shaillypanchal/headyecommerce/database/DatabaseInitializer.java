package com.example.shaillypanchal.headyecommerce.database;


import android.util.Log;


import com.example.shaillypanchal.headyecommerce.database.tables.CategoryTable;
import com.example.shaillypanchal.headyecommerce.database.tables.ProductTable;
import com.example.shaillypanchal.headyecommerce.database.tables.RankingsTable;
import com.example.shaillypanchal.headyecommerce.database.tables.VariantsTable;
import com.example.shaillypanchal.headyecommerce.network.models.CategoryModel;
import com.example.shaillypanchal.headyecommerce.network.response.ProductListResponse;
import com.example.shaillypanchal.headyecommerce.utils.DataProvider;


import java.util.List;
import java.util.Locale;

import retrofit2.Response;

/**
 * Created by shaillypanchal on 03/03/18.
 */

public class DatabaseInitializer {

    static IdatabaseLoader _iDatabaseLoader;


    public static void populateDb(AppDatabase mDb, Response<ProductListResponse> response, IdatabaseLoader iDatabaseLoader) {

        try {
            CategoryTable table = new CategoryTable();
            ProductTable productTable = new ProductTable();
            VariantsTable variantsTable = new VariantsTable();
            RankingsTable rankingsTable = new RankingsTable();

            _iDatabaseLoader = iDatabaseLoader;
            _iDatabaseLoader.dataLoading();

            for (CategoryModel categoryModel : response.body().getCategoryModel()) {

                String childCategories = "";
                table.catid = categoryModel.getCategoryID();
                table.catname = categoryModel.getCategoryName();

                for (int i = 0; i < categoryModel.getChildCategoryList().size(); i++) {

                    childCategories = childCategories + categoryModel.getChildCategoryList().get(i) + ",";

                }

                table.child_categories = childCategories;
                mDb.categoryDAO().insertCategory(table);


                for (int i = 0; i < categoryModel.getProductsList().size(); i++) {


                    productTable.productid = categoryModel.getProductsList().get(i).getProductID();
                    productTable.productname = categoryModel.getProductsList().get(i).getProductName();
                    productTable.catid = categoryModel.getCategoryID();
                    productTable.catname = categoryModel.getCategoryName();
                    productTable.taxname = categoryModel.getProductsList().get(i).getTaxModel().getTaxName();
                    productTable.taxvalue = categoryModel.getProductsList().get(i).getTaxModel().getTaxValue();

                    for (int j = 0; j < categoryModel.getProductsList().get(i).getVariantsList().size(); j++) {

                        // VariantsTable variantsTable= new VariantsTable();
                        variantsTable.product_id = categoryModel.getProductsList().get(i).getProductID();
                        variantsTable.product_name = categoryModel.getProductsList().get(i).getProductName();
                        variantsTable.variant_id = categoryModel.getProductsList().get(i).getVariantsList().get(j).getVariantID();
                        variantsTable.variant_price = categoryModel.getProductsList().get(i).getVariantsList().get(j).getVariantPrice();
                        variantsTable.variant_color = categoryModel.getProductsList().get(i).getVariantsList().get(j).getVariantColor();
                        variantsTable.variant_size = categoryModel.getProductsList().get(i).getVariantsList().get(j).getVariantSize();
                        mDb.variantsDAO().insertVariant(variantsTable);
                    }
                    mDb.productDAO().insertProduct(productTable);


                }


            }


            for (int k = 0; k < response.body().getRankingModel().size(); k++) {

                rankingsTable.rankingname = response.body().getRankingModel().get(k).getRankingName();


                for (int l = 0; l < response.body().getRankingModel().get(k).getRankingProductstList().size(); l++) {

                    ProductTable testproducttable = mDb.productDAO().fetchProductFromID(response.body().getRankingModel().get(k).getRankingProductstList().get(l).getProductID());
                    testproducttable.viewcount = response.body().getRankingModel().get(k).getRankingProductstList().get(l).getViewcount();
                    testproducttable.ordercount = response.body().getRankingModel().get(k).getRankingProductstList().get(l).getOrdercount();
                    testproducttable.sharecount = response.body().getRankingModel().get(k).getRankingProductstList().get(l).getShares_count();

                    mDb.productDAO().updateProduct(testproducttable);

                }

                mDb.rankingsDAO().insertRanking(rankingsTable);


            }

            fetchData(mDb);


        } catch (Exception e) {

            _iDatabaseLoader.dataLoadingFailed();
            e.printStackTrace();
        }
    }

    public static void fetchData(AppDatabase mDb) {
        // Note: this kind of logic should not be in an activity.
        StringBuilder sb = new StringBuilder();

        DataProvider.getInstance().set_categoryList(mDb.categoryDAO().loadAllCategories());
        DataProvider.getInstance().set_rankingsList(mDb.rankingsDAO().loadAllRannkings());
        DataProvider.getInstance().set_variantsList(mDb.variantsDAO().loadAllVariants());
        //DataProvider.getInstance().set_pr(mDb.rankingsDAO().loadAllRannkings());
       /* List<ProductTable> youngUsers = mDb.productDAO().loadAllProducts();
        for (ProductTable youngUser : youngUsers) {
            sb.append(String.format(Locale.US,
                    "%s, %s \n", youngUser.productname, youngUser.sharecount));

        }*/

        _iDatabaseLoader.dataLoadedSuccess();
        Log.e("", "db details" + sb);
    }


    public interface IdatabaseLoader {

        public void dataLoadedSuccess();

        public void dataLoading();

        public void dataLoadingFailed();
    }


}
