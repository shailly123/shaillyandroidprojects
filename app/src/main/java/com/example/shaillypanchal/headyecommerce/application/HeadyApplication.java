package com.example.shaillypanchal.headyecommerce.application;

import android.app.Application;

/**
 * Created by shaillypanchal on 03/03/18.
 */

public class HeadyApplication extends Application {
    private static HeadyApplication sInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance=this;
    }


    public static HeadyApplication getInstance(){
        return sInstance;
    }
}
