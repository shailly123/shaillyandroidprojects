package com.example.shaillypanchal.headyecommerce.network;

import android.util.Log;

import com.example.shaillypanchal.headyecommerce.application.HeadyApplication;
import com.example.shaillypanchal.headyecommerce.network.response.ProductListResponse;
import com.example.shaillypanchal.headyecommerce.utils.CommonUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by shaillypanchal on 03/03/18.
 */

public class ApiManager {




    public static APIInterface getAPIManager() {
        OkHttpClient.Builder builder = getNormalHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiClient.BASE_URL)
                .client(builder.build())
                .addConverterFactory(JacksonConverterFactory.create(CommonUtils.getDeserializationFeature()))
                .build();

        return retrofit.create(APIInterface.class);
    }


    private static OkHttpClient.Builder getNormalHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        List<Protocol> proto_list = new ArrayList<Protocol>();
        proto_list.add(Protocol.HTTP_2);
        proto_list.add(Protocol.HTTP_1_1);
        builder.protocols(proto_list);

        int timeout =30000;
        builder.connectTimeout(timeout, TimeUnit.SECONDS);
        builder.readTimeout(timeout, TimeUnit.SECONDS);
        builder.writeTimeout(timeout, TimeUnit.SECONDS);


        File file = HeadyApplication.getInstance().getCacheDir();
        long cacheSize = 25 * 1024 * 1024; // 25 MB
        if (file.getFreeSpace() < cacheSize) {
            cacheSize = file.getFreeSpace() - 1000;
            cacheSize = cacheSize < 0 ? 0 : cacheSize;
        }
        Cache cache = new Cache(file, cacheSize);
        builder.cache(cache);

        return builder;
    }

}
