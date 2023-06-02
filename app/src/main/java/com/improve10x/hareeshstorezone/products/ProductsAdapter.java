package com.improve10x.hareeshstorezone.products;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.hareeshstorezone.productdetails.OnItemActionListener;
import com.improve10x.hareeshstorezone.databinding.ProductsItemBinding;
import com.improve10x.hareeshstorezone.model.Product;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    public List<Product> products;

    private OnItemActionListener onItemActionListener;
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
        ProductsItemBinding binding = ProductsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ProductViewHolder productViewHolder = new ProductViewHolder(binding);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);
        holder.binding.setProduct(product);
        holder.binding.ratingBar.setRating(product.rating.getRate());
        holder.binding.getRoot().setOnClickListener(v -> {
            onItemActionListener.onClicked(product.getId());
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
