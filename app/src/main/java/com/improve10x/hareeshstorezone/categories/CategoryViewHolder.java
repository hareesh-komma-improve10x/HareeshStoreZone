package com.improve10x.hareeshstorezone.categories;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.hareeshstorezone.databinding.ActivityCategoriesBinding;
import com.improve10x.hareeshstorezone.databinding.CategoriesItemBinding;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    CategoriesItemBinding binding;

    public CategoryViewHolder(CategoriesItemBinding categoriesItemBinding) {
        super(categoriesItemBinding.getRoot());
        binding = categoriesItemBinding;
    }
}
