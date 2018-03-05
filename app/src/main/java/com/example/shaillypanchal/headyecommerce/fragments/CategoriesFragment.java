package com.example.shaillypanchal.headyecommerce.fragments;

import android.app.ProgressDialog;
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
import com.example.shaillypanchal.headyecommerce.database.DatabaseInitializer;
import com.example.shaillypanchal.headyecommerce.utils.DataProvider;

import retrofit2.http.PUT;


public class CategoriesFragment extends Fragment implements CategoryAdapter.IClikedCategoryListener{

    private RecyclerView _categoryRecyclerView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    private OnFragmentInteractionListener mListener;

    public CategoriesFragment() {
        // Required empty public constructor
    }


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
        _categoryRecyclerView = (RecyclerView) rootView.findViewById(R.id.categoryRecyclerView);
        _categoryRecyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false);
        _categoryRecyclerView.setLayoutManager(layoutManager);

        CategoryAdapter _categoryAdapter = new CategoryAdapter(getActivity(), DataProvider.getInstance().get_categoryList(),this);
        _categoryRecyclerView.setAdapter(_categoryAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void categoryClicked(String catname) {


        ((DashboardActivity)getActivity()).setCategoryName(catname);
        ((DashboardActivity)getActivity()).setCurrentItem(2);
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
