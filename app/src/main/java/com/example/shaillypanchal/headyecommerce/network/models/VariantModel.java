package com.example.shaillypanchal.headyecommerce.network.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by shaillypanchal on 03/03/18.
 */

public class VariantModel {

    @JsonProperty("id")
    private int variantID;

    @JsonProperty("color")
    private String variantColor;

    @JsonProperty("size")
    private String variantSize;

    @JsonProperty("price")
    private int variantPrice;


    public int getVariantID() {
        return variantID;
    }

    public void setVariantID(int variantID) {
        this.variantID = variantID;
    }

    public String getVariantColor() {
        return variantColor;
    }

    public void setVariantColor(String variantColor) {
        this.variantColor = variantColor;
    }

    public String getVariantSize() {
        return variantSize;
    }

    public void setVariantSize(String variantSize) {
        this.variantSize = variantSize;
    }

    public int getVariantPrice() {
        return variantPrice;
    }

    public void setVariantPrice(int variantPrice) {
        this.variantPrice = variantPrice;
    }
}
