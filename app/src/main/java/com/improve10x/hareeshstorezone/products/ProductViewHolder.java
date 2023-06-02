package com.improve10x.hareeshstorezone.products;

import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.hareeshstorezone.databinding.ProductsItemBinding;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    ProductsItemBinding productsItemBinding;

    public ProductViewHolder(ProductsItemBinding productsItemBinding) {
        super(productsItemBinding.getRoot());
        this.productsItemBinding = productsItemBinding;
    }
}
