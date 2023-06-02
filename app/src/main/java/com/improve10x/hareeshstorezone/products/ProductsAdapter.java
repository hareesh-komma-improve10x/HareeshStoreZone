package com.improve10x.hareeshstorezone.products;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.hareeshstorezone.databinding.ProductsItemBinding;
import com.improve10x.hareeshstorezone.model.Product;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private List<Product> products;
    OnItemActionListener onItemActionListener;
    void setProducts(List<Product> productList) {
        products = productList;
        notifyDataSetChanged();
    }
    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductsItemBinding productsItemBinding = ProductsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ProductViewHolder productViewHolder = new ProductViewHolder(productsItemBinding);
        return productViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);
        holder.productsItemBinding.setProduct(product);
        holder.productsItemBinding.ratingBar.setRating(product.rating.getRate());
        holder.productsItemBinding.getRoot().setOnClickListener(v -> {
            onItemActionListener.onClicked(product.getId());
        });
    }
    @Override
    public int getItemCount() {
        return products.size();
    }
}
