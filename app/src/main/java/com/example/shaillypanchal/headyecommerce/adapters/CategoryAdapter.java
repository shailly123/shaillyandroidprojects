package com.example.shaillypanchal.headyecommerce.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shaillypanchal.headyecommerce.R;
import com.example.shaillypanchal.headyecommerce.database.tables.CategoryTable;
import com.example.shaillypanchal.headyecommerce.viewholders.CategoryRecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaillypanchal on 05/03/18.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryRecyclerViewHolder> {

    private List<CategoryTable> _categoryList;
    private Context _context;
    private IClikedCategoryListener _iClikedCategoryListener;

    public CategoryAdapter(Context context, List<CategoryTable> categoryList,IClikedCategoryListener iClikedCategoryListener) {
        _categoryList = categoryList;
        _context = context;
        _iClikedCategoryListener=iClikedCategoryListener;
    }

    @Override
    public CategoryRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_item, null);
       CategoryRecyclerViewHolder _categoryHolder = new CategoryRecyclerViewHolder(layoutView);
        return _categoryHolder;
    }

    @Override
    public void onBindViewHolder(CategoryRecyclerViewHolder holder, final int position) {
        holder._categoryname.setText(_categoryList.get(position).catname);

        holder._categoryImage.setImageResource(R.drawable.placeholder1);

        holder._categoryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _iClikedCategoryListener.categoryClicked(_categoryList.get(position).catname);
            }
        });

    }

    @Override
    public int getItemCount() {
        return _categoryList.size();
    }


    public interface IClikedCategoryListener
    {
        public void categoryClicked(String catname);

    }
}
