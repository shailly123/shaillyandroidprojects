package com.example.shaillypanchal.headyecommerce.network.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by shaillypanchal on 03/03/18.
 */

public class RankingCountBaseModel {


    @JsonProperty("id")
    private int productID;

    @JsonProperty("view_count")
    private int viewcount;

    @JsonProperty("order_count")
    private int ordercount;


    @JsonProperty("shares")
    private int shares_count;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getViewcount() {
        return viewcount;
    }

    public void setViewcount(int viewcount) {
        this.viewcount = viewcount;
    }

    public int getOrdercount() {
        return ordercount;
    }

    public void setOrdercount(int ordercount) {
        this.ordercount = ordercount;
    }

    public int getShares_count() {
        return shares_count;
    }

    public void setShares_count(int shares_count) {
        this.shares_count = shares_count;
    }
}
