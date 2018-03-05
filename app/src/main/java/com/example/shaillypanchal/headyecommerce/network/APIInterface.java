package com.example.shaillypanchal.headyecommerce.network;

import com.example.shaillypanchal.headyecommerce.network.response.ProductListResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shaillypanchal on 03/03/18.
 */


public interface APIInterface {
    @GET("json")
    Call<ProductListResponse> getCompleteProductList();


}
