package com.example.shaillypanchal.headyecommerce.network.response;

import com.example.shaillypanchal.headyecommerce.network.models.CategoryModel;
import com.example.shaillypanchal.headyecommerce.network.models.RankingModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by shaillypanchal on 03/03/18.
 */

public class ProductListResponse {

    @JsonProperty("categories")
    private ArrayList<CategoryModel>categoryModel;
    @JsonProperty("rankings")
    private ArrayList<RankingModel> rankingModel;


    public ArrayList<CategoryModel> getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(ArrayList<CategoryModel> categoryModel) {
        this.categoryModel = categoryModel;
    }

    public ArrayList<RankingModel> getRankingModel() {
        return rankingModel;
    }

    public void setRankingModel(ArrayList<RankingModel> rankingModel) {
        this.rankingModel = rankingModel;
    }
}
