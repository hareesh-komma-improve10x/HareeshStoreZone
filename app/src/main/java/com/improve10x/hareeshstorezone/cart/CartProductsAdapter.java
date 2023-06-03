package com.improve10x.hareeshstorezone.cart;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.hareeshstorezone.databinding.CartProductItemBinding;

import java.util.List;

public class CartProductsAdapter extends RecyclerView.Adapter<CartProductViewHolder> {

    private List<CartProduct> cartProducts;

    void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
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
        CartProduct cartProduct = cartProducts.get(position);
        holder.cartProductItemBinding.idTxt.setText(String.valueOf(cartProduct.getId()));
        holder.cartProductItemBinding.cartQuantityTxt.setText(cartProduct.getUserId());
    }

    @Override
    public int getItemCount() {
        return cartProducts.size();
    }
}
