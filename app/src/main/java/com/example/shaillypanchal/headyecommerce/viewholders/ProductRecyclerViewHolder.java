package com.example.shaillypanchal.headyecommerce.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shaillypanchal.headyecommerce.R;

import retrofit2.http.PUT;

/**
 * Created by shaillypanchal on 05/03/18.
 */

public class ProductRecyclerViewHolder extends RecyclerView.ViewHolder  {

    public TextView _productname,_variantsname;
    public ImageView _productImage;

    public ProductRecyclerViewHolder(View itemView) {
        super(itemView);


        _productname = (TextView)itemView.findViewById(R.id.category_name);
        _variantsname = (TextView)itemView.findViewById(R.id.variants_name);
        _productImage = (ImageView)itemView.findViewById(R.id.category_photo);

    }



}
