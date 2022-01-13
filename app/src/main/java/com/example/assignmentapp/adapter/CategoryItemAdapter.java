package com.example.assignmentapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentapp.databinding.CategoryItemBinding;
import com.example.assignmentapp.model.Class;

import java.util.List;

public class CategoryItemAdapter extends RecyclerView.Adapter<CategoryItemAdapter.CategoryItemViewHolder> {

    private Context context;
    private List<Class> categoryItemData;

    public CategoryItemAdapter(Context context, List<Class> categoryItemData) {
        this.context = context;
        this.categoryItemData = categoryItemData;
    }

    @NonNull
    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        CategoryItemBinding categoryItemBinding = CategoryItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new CategoryItemViewHolder(categoryItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemViewHolder holder, int position) {
        //holder.categoryItemBinding.itemNameId.setText(categoryItemData.get(position).getName());
        holder.setCategoryItemData(categoryItemData.get(position));
    }

    @Override
    public int getItemCount() {
        return categoryItemData.size();
    }

    public class CategoryItemViewHolder extends RecyclerView.ViewHolder {

        CategoryItemBinding categoryItemBinding;

        public CategoryItemViewHolder(@NonNull CategoryItemBinding categoryItemBinding) {
            super(categoryItemBinding.getRoot());

            this.categoryItemBinding = categoryItemBinding;
        }

        public void setCategoryItemData(Class categoryClassData) {

            categoryItemBinding.itemNameId.setText(categoryClassData.getName());

        }
    }
}
