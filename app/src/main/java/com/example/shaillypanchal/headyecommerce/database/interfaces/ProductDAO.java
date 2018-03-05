package com.example.shaillypanchal.headyecommerce.database.interfaces;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.shaillypanchal.headyecommerce.database.tables.CategoryTable;
import com.example.shaillypanchal.headyecommerce.database.tables.ProductTable;
import com.example.shaillypanchal.headyecommerce.network.models.ProductModel;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by shaillypanchal on 03/03/18.
 */
@Dao
public interface ProductDAO {


    @Query("select * from ProductTable")
    List<ProductTable> loadAllProducts();


    @Query("DELETE FROM producttable")
    void deleteAll();

    @Insert(onConflict = IGNORE)
    void insertProduct(ProductTable producttable);

    @Query("select * from producttable where productname == :name")
    List<ProductTable> findProductsByName(String name);



    @Query("select * from ProductTable where catid ==:catid")
    List<ProductTable> findProductsByCatID(int catid);


    @Query("select * from ProductTable where catname ==:catname")
    List<ProductTable> findProductsByCatName(String catname);

    @Query("select * from ProductTable where ordercount > 0")
    List<ProductTable> loadProductsByOrdercount();

    @Query("select * from ProductTable where sharecount > 0")
    List<ProductTable> loadProductsByShareCount();

    @Query("select * from ProductTable where viewcount > 0")
    List<ProductTable> loadProductsViewCount();

    @Query("select * from ProductTable where productid = :productid")
    ProductTable fetchProductFromID(int productid);

    @Update()
    void updateProduct(ProductTable producttable);

}
