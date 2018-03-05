package com.example.shaillypanchal.headyecommerce.database.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.shaillypanchal.headyecommerce.database.tables.CategoryTable;
import com.example.shaillypanchal.headyecommerce.database.tables.RankingsTable;
import com.example.shaillypanchal.headyecommerce.database.tables.VariantsTable;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

/**
 * Created by shaillypanchal on 04/03/18.
 */
@Dao
public interface RankingsDAO  {

    @Query("select * from RANKINGSTABLE")
    List<RankingsTable> loadAllRannkings();


    @Query("DELETE FROM rankingstable")
    void deleteAll();

    @Insert(onConflict = IGNORE)
    void insertRanking(RankingsTable rankingsTable);
}
