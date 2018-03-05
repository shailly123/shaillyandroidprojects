package com.example.shaillypanchal.headyecommerce.database.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by shaillypanchal on 04/03/18.
 */

@Entity
public class VariantsTable {
    @PrimaryKey
    @NonNull
    public int variant_id;
    public String variant_color;
    public String variant_size;
    public int variant_price;
    public int product_id;
    public String product_name;


}
