package com.example.shaillypanchal.headyecommerce.network.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by shaillypanchal on 03/03/18.
 */

public class TaxModel {
    @JsonProperty("name")
    private String taxName;

    @JsonProperty("value")
    private float taxValue;


    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public float getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(float taxValue) {
        this.taxValue = taxValue;
    }
}
