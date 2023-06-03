package com.improve10x.hareeshstorezone.cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.hareeshstorezone.categories.OnItemActionListener;
import com.improve10x.hareeshstorezone.databinding.CartProductItemBinding;

import java.util.List;

public class CartProductsAdapter extends RecyclerView.Adapter<CartProductViewHolder> {

    private List<CartProductDetails> cartProductDetails;

    void setCartProducts(List<CartProductDetails> cartProductDetails) {
        this.cartProductDetails = cartProductDetails;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CartProductItemBinding cartProductItemBinding = CartProductItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CartProductViewHolder cartProductViewHolder = new CartProductViewHolder(cartProductItemBinding);
        return cartProductViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartProductViewHolder holder, int position) {
        CartProductDetails cartProduct = cartProductDetails.get(position);
        holder.cartProductItemBinding.idTxt.setText(String.valueOf(cartProduct.getProductId()));
        holder.cartProductItemBinding.cartQuantityTxt.setText(String.valueOf(cartProduct.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return cartProductDetails.size();
    }
}
