package com.example.shaillypanchal.headyecommerce.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.shaillypanchal.headyecommerce.fragments.CategoriesFragment;
import com.example.shaillypanchal.headyecommerce.fragments.MyAccountFragment;
import com.example.shaillypanchal.headyecommerce.fragments.ProductFragment;
import com.example.shaillypanchal.headyecommerce.fragments.TrendingFragment;

/**
 * Created by shaillypanchal on 04/03/18.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new CategoriesFragment();

        }
        else if (position == 1)
        {
            fragment = new TrendingFragment();
        }
        else if (position == 2)
        {
            fragment = new ProductFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }



    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Categories";
        }
        else if (position == 1)
        {
            title = "Trending";
        }
        else if (position == 2)
        {
            title = "Products";
        }
        return title;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        // POSITION_NONE makes it possible to reload the PagerAdapter
        return POSITION_NONE;
    }
}
