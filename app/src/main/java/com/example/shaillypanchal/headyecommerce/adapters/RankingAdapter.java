package com.example.shaillypanchal.headyecommerce.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shaillypanchal.headyecommerce.R;
import com.example.shaillypanchal.headyecommerce.activities.DashboardActivity;
import com.example.shaillypanchal.headyecommerce.database.tables.CategoryTable;
import com.example.shaillypanchal.headyecommerce.database.tables.RankingsTable;
import com.example.shaillypanchal.headyecommerce.viewholders.CategoryRecyclerViewHolder;
import com.example.shaillypanchal.headyecommerce.viewholders.RankingRecyclerViewHolder;

import java.util.List;

/**
 * Created by shaillypanchal on 05/03/18.
 */

public class RankingAdapter extends RecyclerView.Adapter<RankingRecyclerViewHolder> {

    private List<RankingsTable> _rankingList;
    private Context _context;
    IClikedItemListener _iClickedItemListener;
    public RankingAdapter(Context context, List<RankingsTable> rankingsList, IClikedItemListener iClickedItemListener) {
        _rankingList = rankingsList;
        _context = context;
        _iClickedItemListener=iClickedItemListener;
    }

    @Override
    public RankingRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ranking_list_item, null);
        RankingRecyclerViewHolder _rankingHolder = new RankingRecyclerViewHolder(layoutView);
        return _rankingHolder;
    }

    @Override
    public void onBindViewHolder(final RankingRecyclerViewHolder holder, final int position) {
        holder._rankingname.setText(_rankingList.get(position).rankingname);

        holder._rankingImage.setImageResource(R.drawable.placeholder3);

        holder._rankingImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _iClickedItemListener.itemClicked(_rankingList.get(position).rankingname);


            }
        });

    }

    @Override
    public int getItemCount() {
        return _rankingList.size();
    }


    public interface IClikedItemListener
    {
        public void itemClicked(String rankingname);

    }
}
