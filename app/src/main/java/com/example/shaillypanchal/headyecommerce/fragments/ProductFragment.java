package com.example.shaillypanchal.headyecommerce.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shaillypanchal.headyecommerce.R;
import com.example.shaillypanchal.headyecommerce.activities.DashboardActivity;
import com.example.shaillypanchal.headyecommerce.adapters.CategoryAdapter;
import com.example.shaillypanchal.headyecommerce.adapters.ProductAdapter;
import com.example.shaillypanchal.headyecommerce.database.tables.ProductTable;
import com.example.shaillypanchal.headyecommerce.utils.DataProvider;

import java.util.ArrayList;
import java.util.List;


public class ProductFragment extends Fragment {
    private RecyclerView _productRecyclerView;
    private String _rankingName;

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
        _productRecyclerView = (RecyclerView) rootView.findViewById(R.id.categoryRecyclerView);
        _productRecyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false);
        _productRecyclerView.setLayoutManager(layoutManager);


        List<ProductTable> productTableList = new ArrayList<ProductTable>();
        productTableList.clear();


        if (((DashboardActivity) getActivity()).getScreenName().equalsIgnoreCase("Ranking")) {


            if (((DashboardActivity) getActivity()).getRankingName().equalsIgnoreCase("Most Ordered Products")) {

                productTableList = ((DashboardActivity) getActivity()).getDatabaseInstance().productDAO().loadProductsByOrdercount();
            } else if (((DashboardActivity) getActivity()).getRankingName().equalsIgnoreCase("Most Viewed Products")) {

                productTableList = ((DashboardActivity) getActivity()).getDatabaseInstance().productDAO().loadProductsViewCount();

            } else if (((DashboardActivity) getActivity()).getRankingName().equalsIgnoreCase("Most Shared Products")) {


                productTableList = ((DashboardActivity) getActivity()).getDatabaseInstance().productDAO().loadProductsByShareCount();

            } else {

            }
        } else if (((DashboardActivity) getActivity()).getScreenName().equalsIgnoreCase("Category")) {


            productTableList = ((DashboardActivity) getActivity()).getDatabaseInstance().productDAO().findProductsByCatName(((DashboardActivity) getActivity()).get_categoryName());
        } else {

        }

        ProductAdapter _productAdapter = new ProductAdapter(getActivity(), productTableList);
        _productRecyclerView.setAdapter(_productAdapter);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


}
