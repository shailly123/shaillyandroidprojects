package com.example.shaillypanchal.headyecommerce.database.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.shaillypanchal.headyecommerce.database.tables.ProductTable;
import com.example.shaillypanchal.headyecommerce.database.tables.VariantsTable;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

/**
 * Created by shaillypanchal on 04/03/18.
 */

@Dao
public interface VariantsDAO {

    @Query("select * from variantstable")
    List<VariantsTable> loadAllVariants();


    @Query("DELETE FROM variantstable")
    void deleteAll();

    @Insert(onConflict = IGNORE)
    void insertVariant(VariantsTable variantsTable);

    @Query("select * from variantstable where product_id == :productid")
    List<VariantsTable> findVariantsByProductID(int productid);



    @Query("SELECT * FROM ProductTable " + "INNER JOIN CategoryTable ON ProductTable.catid == CategoryTable.catid")
    List<ProductTable> findProductsByCatID();
}
