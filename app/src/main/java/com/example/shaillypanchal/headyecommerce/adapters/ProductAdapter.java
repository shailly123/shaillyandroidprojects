package com.example.shaillypanchal.headyecommerce.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shaillypanchal.headyecommerce.R;
import com.example.shaillypanchal.headyecommerce.activities.DashboardActivity;
import com.example.shaillypanchal.headyecommerce.database.AppDatabase;
import com.example.shaillypanchal.headyecommerce.database.tables.CategoryTable;
import com.example.shaillypanchal.headyecommerce.database.tables.ProductTable;
import com.example.shaillypanchal.headyecommerce.database.tables.VariantsTable;
import com.example.shaillypanchal.headyecommerce.utils.DataProvider;
import com.example.shaillypanchal.headyecommerce.viewholders.CategoryRecyclerViewHolder;
import com.example.shaillypanchal.headyecommerce.viewholders.ProductRecyclerViewHolder;

import java.util.List;

/**
 * Created by shaillypanchal on 05/03/18.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductRecyclerViewHolder> {

    private List<ProductTable> _productList;
    private Context _context;
    AppDatabase mdb;


    public ProductAdapter(Context context, List<ProductTable> categoryList) {
        _productList = categoryList;
        _context = context;
        mdb=AppDatabase.getInMemoryDatabase(_context);


    }

    @Override
    public ProductRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_item, null);
        ProductRecyclerViewHolder _productHolder = new ProductRecyclerViewHolder(layoutView);
        return _productHolder;
    }

    @Override
    public void onBindViewHolder(ProductRecyclerViewHolder holder, int position) {
        holder._productname.setText(_productList.get(position).productname);

        holder._productImage.setImageResource(R.drawable.placeholder3);
       List<VariantsTable> variantsTableList= mdb.variantsDAO().findVariantsByProductID(_productList.get(position).productid);

        for(int i =0;i<variantsTableList.size();i++){
            holder._variantsname.setText(holder._variantsname.getText()+" "+variantsTableList.get(i).variant_color);
        }



    }

    @Override
    public int getItemCount() {
        return _productList.size();
    }




}
