package com.improve10x.hareeshstorezone.categories;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.hareeshstorezone.databinding.CategoriesItemBinding;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    public List<String> categories;

    public OnItemActionListener onItemActionListener;

    void setData(List<String> categoryList) {
        categories = categoryList;
        notifyDataSetChanged();
    }

    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoriesItemBinding binding = CategoriesItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(binding);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.binding.titleTxt.setText(categories.get(position));
        holder.binding.getRoot().setOnClickListener(v -> {
            onItemActionListener.onItemClicked(categories.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
