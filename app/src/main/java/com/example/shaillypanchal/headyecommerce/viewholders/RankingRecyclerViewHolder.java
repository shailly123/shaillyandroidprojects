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

public class RankingRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView _rankingname;
    public ImageView _rankingImage;
    public RankingRecyclerViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);
        _rankingname = (TextView)itemView.findViewById(R.id.category_name);
        _rankingImage = (ImageView)itemView.findViewById(R.id.category_photo);

    }


    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Ranking  = " + _rankingname.getText(), Toast.LENGTH_SHORT).show();


    }
}
