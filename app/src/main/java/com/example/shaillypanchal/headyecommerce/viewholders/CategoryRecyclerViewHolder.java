package com.example.shaillypanchal.headyecommerce.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shaillypanchal.headyecommerce.R;

/**
 * Created by shaillypanchal on 05/03/18.
 */

public class CategoryRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView _categoryname;
    public ImageView _categoryImage;
    public CategoryRecyclerViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);
        _categoryname = (TextView)itemView.findViewById(R.id.category_name);
        _categoryImage = (ImageView)itemView.findViewById(R.id.category_photo);

    }


    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Category  = " + _categoryname.getText(), Toast.LENGTH_SHORT).show();


    }
}
