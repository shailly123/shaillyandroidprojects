package com.example.shaillypanchal.headyecommerce.database.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by shaillypanchal on 03/03/18.
 */
@Entity
public class CategoryTable {

    @PrimaryKey
    @NonNull
    public int catid;
    public String catname;
    public String child_categories;


}
