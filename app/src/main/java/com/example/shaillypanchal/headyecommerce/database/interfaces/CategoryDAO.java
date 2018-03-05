package com.example.shaillypanchal.headyecommerce.database.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.shaillypanchal.headyecommerce.database.tables.CategoryTable;
import com.example.shaillypanchal.headyecommerce.database.tables.ProductTable;

import java.util.ArrayList;
import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

/**
 * Created by shaillypanchal on 04/03/18.
 */

@Dao
public interface CategoryDAO {
    @Query("select * from categorytable")
    List<CategoryTable> loadAllCategories();


    @Query("DELETE FROM categorytable")
    void deleteAll();

    @Insert(onConflict = IGNORE)
    void insertCategory(CategoryTable categorttable);
}
