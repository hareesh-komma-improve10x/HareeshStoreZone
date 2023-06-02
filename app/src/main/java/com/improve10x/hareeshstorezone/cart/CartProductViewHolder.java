package com.improve10x.hareeshstorezone.cart;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.hareeshstorezone.databinding.CartProductItemBinding;

public class CartProductViewHolder extends RecyclerView.ViewHolder {

    CartProductItemBinding cartProductItemBinding;
    public CartProductViewHolder(CartProductItemBinding cartProductItemBinding) {
        super(cartProductItemBinding.getRoot());
        this.cartProductItemBinding = cartProductItemBinding;
    }
}
