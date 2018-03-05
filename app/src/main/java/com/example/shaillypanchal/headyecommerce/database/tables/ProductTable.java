package com.example.shaillypanchal.headyecommerce.database.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by shaillypanchal on 03/03/18.
 */

@Entity
public class ProductTable{
    @PrimaryKey
    @NonNull
    public int productid;
    public String productname;
    public int catid;
    public String catname;
    public String date_added;
    public int variant_id;
    public String variant_color;
    public String variant_size;
    public int variant_price;
    public boolean isChildCategory;
    public String taxname;
    public float taxvalue;
    public String rankingname;
    public  int ordercount;
    public int viewcount;
    public int sharecount;





}
