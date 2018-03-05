package com.example.shaillypanchal.headyecommerce.utils;

import com.example.shaillypanchal.headyecommerce.database.tables.CategoryTable;
import com.example.shaillypanchal.headyecommerce.database.tables.ProductTable;
import com.example.shaillypanchal.headyecommerce.database.tables.RankingsTable;
import com.example.shaillypanchal.headyecommerce.database.tables.VariantsTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaillypanchal on 05/03/18.
 */

public class DataProvider {
    private static final DataProvider ourInstance = new DataProvider();
    private List<CategoryTable> _categoryList = new ArrayList<>();
    private List<RankingsTable> _rankingsList = new ArrayList<>();
    private List<VariantsTable> _variantsList = new ArrayList<>();
    private List<ProductTable> _productListByRanking = new ArrayList<>();

    public static DataProvider getInstance() {
        return ourInstance;
    }

    private DataProvider() {
    }


    public List<CategoryTable> get_categoryList() {
        return _categoryList;
    }

    public void set_categoryList(List<CategoryTable> _categoryList) {
        this._categoryList = _categoryList;
    }

    public List<RankingsTable> get_rankingsList() {
        return _rankingsList;
    }

    public void set_rankingsList(List<RankingsTable> _rankingsList) {
        this._rankingsList = _rankingsList;
    }

    public List<VariantsTable> get_variantsList() {
        return _variantsList;
    }

    public void set_variantsList(List<VariantsTable> _variantsList) {
        this._variantsList = _variantsList;
    }
}
