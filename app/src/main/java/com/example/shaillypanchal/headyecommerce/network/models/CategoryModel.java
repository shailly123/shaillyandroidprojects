package com.example.shaillypanchal.headyecommerce.network.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by shaillypanchal on 03/03/18.
 */

public class CategoryModel {
    @JsonProperty("id")
    private int categoryID;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("products")
    private ArrayList<ProductModel> productsList;

    @JsonProperty("child_categories")
    private ArrayList<Integer> childCategoryList;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ArrayList<ProductModel> getProductsList() {
        return productsList;
    }

    public void setProductsList(ArrayList<ProductModel> productsList) {
        this.productsList = productsList;
    }

    public ArrayList<Integer> getChildCategoryList() {
        return childCategoryList;
    }

    public void setChildCategoryList(ArrayList<Integer> childCategoryList) {
        this.childCategoryList = childCategoryList;
    }
}
