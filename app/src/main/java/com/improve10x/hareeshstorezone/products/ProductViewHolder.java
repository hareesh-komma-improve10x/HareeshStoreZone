package com.improve10x.hareeshstorezone.products;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.hareeshstorezone.databinding.ProductsItemBinding;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    ProductsItemBinding binding;

    public ProductViewHolder(ProductsItemBinding productsItemBinding) {
        super(productsItemBinding.getRoot());
        binding = productsItemBinding;
    }
}
