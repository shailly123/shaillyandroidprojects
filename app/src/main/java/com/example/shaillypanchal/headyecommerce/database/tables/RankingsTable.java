package com.example.shaillypanchal.headyecommerce.database.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by shaillypanchal on 04/03/18.
 */
@Entity
public class RankingsTable  {
    @PrimaryKey
    @NonNull
    public String rankingname;
    public  String rankingcount;
    public String products_arr;

}
