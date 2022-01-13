package com.example.assignmentapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentapp.databinding.AllCategoryListBinding;
import com.example.assignmentapp.model.Datum;

import java.util.List;

public class AllCategoryAdapter extends RecyclerView.Adapter<AllCategoryAdapter.AllCategoryViewHolder> {

    Context context;
    List<Datum> allCategoryData;

    public AllCategoryAdapter(Context context, List<Datum> allCategoryData) {
        this.context = context;
        this.allCategoryData = allCategoryData;
    }

    @NonNull
    @Override
    public AllCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        AllCategoryListBinding allCategoryListBinding = AllCategoryListBinding.inflate(LayoutInflater.from(context), parent, false);
        return new AllCategoryViewHolder(allCategoryListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoryViewHolder holder, int position) {
        holder.setAllCateData(allCategoryData.get(position));

    }

    @Override
    public int getItemCount() {
        return allCategoryData.size();
    }

    public class AllCategoryViewHolder extends RecyclerView.ViewHolder {

        AllCategoryListBinding allCategoryListBinding;

        public AllCategoryViewHolder(@NonNull AllCategoryListBinding allCategoryListBinding) {
            super(allCategoryListBinding.getRoot());

            this.allCategoryListBinding = allCategoryListBinding;
        }

        public void setAllCateData(Datum datum) {
            allCategoryListBinding.allCategoryNameId.setText(datum.getName());
        }
    }
}
