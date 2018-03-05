package com.example.shaillypanchal.headyecommerce.network.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by shaillypanchal on 03/03/18.
 */

public class ProductModel {

    @JsonProperty("id")
    private int productID;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("date_added")
    private String dateAdded;

    @JsonProperty("variants")
    private ArrayList<VariantModel> variantsList;

    @JsonProperty("tax")
    private TaxModel taxModel;


    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public ArrayList<VariantModel> getVariantsList() {
        return variantsList;
    }

    public void setVariantsList(ArrayList<VariantModel> variantsList) {
        this.variantsList = variantsList;
    }

    public TaxModel getTaxModel() {
        return taxModel;
    }

    public void setTaxModel(TaxModel taxModel) {
        this.taxModel = taxModel;
    }
}
