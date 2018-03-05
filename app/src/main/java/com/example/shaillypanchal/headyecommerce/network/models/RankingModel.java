package com.example.shaillypanchal.headyecommerce.network.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by shaillypanchal on 03/03/18.
 */

public class RankingModel {
    @JsonProperty("ranking")
    private String rankingName;

    @JsonProperty("products")
    private ArrayList<RankingCountBaseModel> rankingProductstList;


    public String getRankingName() {
        return rankingName;
    }

    public void setRankingName(String rankingName) {
        this.rankingName = rankingName;
    }

    public ArrayList<RankingCountBaseModel> getRankingProductstList() {
        return rankingProductstList;
    }

    public void setRankingProductstList(ArrayList<RankingCountBaseModel> rankingProductstList) {
        this.rankingProductstList = rankingProductstList;
    }
}
