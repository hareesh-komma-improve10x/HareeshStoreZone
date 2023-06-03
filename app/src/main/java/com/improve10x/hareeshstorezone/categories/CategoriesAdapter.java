package com.improve10x.hareeshstorezone.categories;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.hareeshstorezone.databinding.CategoriesItemBinding;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private List<Category> categories;
    OnItemActionListener onItemActionListener;
    void setData(List<Category> categoryList) {
        categories = categoryList;
        notifyDataSetChanged();
    }

    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoriesItemBinding categoriesItemBinding = CategoriesItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(categoriesItemBinding);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category product = categories.get(position);
        holder.categoriesItemBinding.titleTxt.setText(product.getName());
        holder.categoriesItemBinding.getRoot().setOnClickListener(v -> {
            onItemActionListener.onItemClicked(String.valueOf(product));
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
