package com.example.shaillypanchal.headyecommerce.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shaillypanchal.headyecommerce.R;
import com.example.shaillypanchal.headyecommerce.activities.DashboardActivity;
import com.example.shaillypanchal.headyecommerce.adapters.CategoryAdapter;
import com.example.shaillypanchal.headyecommerce.adapters.RankingAdapter;
import com.example.shaillypanchal.headyecommerce.utils.DataProvider;

public class TrendingFragment extends Fragment implements RankingAdapter.IClikedItemListener {

    private RecyclerView _trendingRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_categories, container, false);
        initializeRecyclerView(rootView);

        return rootView;
    }
    public void initializeRecyclerView(View rootView) {
        _trendingRecyclerView = (RecyclerView) rootView.findViewById(R.id.categoryRecyclerView);
        _trendingRecyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false);
        _trendingRecyclerView.setLayoutManager(layoutManager);

        RankingAdapter _rankingAdapter = new RankingAdapter(getActivity(), DataProvider.getInstance().get_rankingsList(),this);
        _trendingRecyclerView.setAdapter(_rankingAdapter);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


    @Override
    public void itemClicked(String rankingname) {


        ((DashboardActivity)getActivity()).setRankingName(rankingname);
       ((DashboardActivity)getActivity()).setCurrentItem(2);




      /*  ProductFragment nextFrag = new ProductFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .detach(nextFrag).attach(nextFrag)


                .addToBackStack(null)
                .commit();*/


    }
}
