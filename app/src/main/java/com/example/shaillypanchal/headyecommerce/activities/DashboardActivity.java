package com.example.shaillypanchal.headyecommerce.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TableLayout;

import com.example.shaillypanchal.headyecommerce.R;
import com.example.shaillypanchal.headyecommerce.adapters.RankingAdapter;
import com.example.shaillypanchal.headyecommerce.adapters.ViewPagerAdapter;
import com.example.shaillypanchal.headyecommerce.database.AppDatabase;
import com.example.shaillypanchal.headyecommerce.database.DatabaseInitializer;

import com.example.shaillypanchal.headyecommerce.fragments.ProductFragment;
import com.example.shaillypanchal.headyecommerce.network.ApiManager;

import com.example.shaillypanchal.headyecommerce.network.response.ProductListResponse;
import com.example.shaillypanchal.headyecommerce.utils.DataProvider;


import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity implements DatabaseInitializer.IdatabaseLoader {

    private AppDatabase mDb;
    private ViewPager _viewPager;
    private TabLayout _tabLayout;
    ViewPagerAdapter _viewPagerAdapter;
    ProgressBar _progressBar;
    private String _rankingName = "",screenName="",_categoryName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        _viewPager = (ViewPager) findViewById(R.id.viewpager);
        _tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        _progressBar = (ProgressBar) findViewById(R.id.progressbar);


        mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());

        ApiManager.getAPIManager().getCompleteProductList().enqueue(new Callback<ProductListResponse>() {
            @Override
            public void onResponse(retrofit2.Call<ProductListResponse> call, Response<ProductListResponse> response) {
                Log.e("retrofit", "response  success" + response.body());
                if (DataProvider.getInstance().get_categoryList().size() == 0) {
                    DatabaseInitializer.populateDb(mDb, response, DashboardActivity.this);
                }

            }

            @Override
            public void onFailure(retrofit2.Call<ProductListResponse> call, Throwable t) {
                Log.e("retrofit", "response  success" + t.getMessage());

            }
        });

        _viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //   _viewPager.getAdapter().notifyDataSetChanged();

            }

            @Override
            public void onPageSelected(int position) {
                _viewPager.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    public AppDatabase getDatabaseInstance() {
        return mDb;
    }

    @Override
    public void dataLoadedSuccess() {
        if (_progressBar.getVisibility() == View.VISIBLE) {
            _progressBar.setVisibility(View.GONE);
        }
        _viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        _viewPager.setAdapter(_viewPagerAdapter);
        _tabLayout.setupWithViewPager(_viewPager);
    }

    @Override
    public void dataLoading() {

        _progressBar.setVisibility(View.VISIBLE);


    }

    @Override
    public void dataLoadingFailed() {

    }

    public String getRankingName() {

        return _rankingName;

    }

    public void setRankingName(String rankingname) {
        _rankingName = rankingname;
        screenName="Ranking";

    }
    public void setCategoryName(String categoryName) {
        _categoryName = categoryName;
        screenName="Category";

    }

    public String get_categoryName() {
        return _categoryName;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setCurrentItem(int fragment) {
        _viewPager.setOffscreenPageLimit(0);
        _viewPagerAdapter.notifyDataSetChanged();
        _viewPager.setCurrentItem(fragment);

        //_viewPager.getAdapter().notifyDataSetChanged();
    }


   /* @Override
    public void itemClicked(String rankingname) {

    Log.e("ranking ","callback"+rankingname);
        _rankingName=rankingname;
        _viewPager.setCurrentItem(2);

       *//* ((ProductFragment)_viewPager.getCurrentItem()).setRankingName(rankingname);
        ProductFragment nextFrag = new ProductFragment();
        getSupportFragmentManager().beginTransaction()


                .addToBackStack(null)
                .commit();*//*

    }*/


}
