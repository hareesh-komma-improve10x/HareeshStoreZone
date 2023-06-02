package com.improve10x.hareeshstorezone.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.improve10x.hareeshstorezone.BaseActivity;
import com.improve10x.hareeshstorezone.databinding.ActivityProductsBinding;
import com.improve10x.hareeshstorezone.model.Product;
import com.improve10x.hareeshstorezone.network.FakeApi;
import com.improve10x.hareeshstorezone.network.FakeApiService;
import com.improve10x.hareeshstorezone.productdetails.ProductDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends BaseActivity {

    private ActivityProductsBinding binding;
    private List<Product> products = new ArrayList<>();
    private ProductsAdapter productsAdapter;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Todo use constants
        if (getIntent().hasExtra("category")) {
            category = getIntent().getStringExtra("category");
        }
        getSupportActionBar().setTitle(category);
        fetchData();
        setupAdapter();
        setupProductRv();
    }

    private void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }

    private void showProgressBar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void fetchData() {
        showProgressBar();
        Call<List<Product>> call = fakeApiService.fetchProducts(category);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                hideProgressBar();
                List<Product> productList = response.body();
                productsAdapter.setProducts(productList);
            }
            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                hideProgressBar();
                showToast("Failed To Loaded Data");
            }
        });
    }
    private void setupProductRv() {
        binding.productRv.setLayoutManager(new GridLayoutManager(this, 2));
        binding.productRv.setAdapter(productsAdapter);
    }
    private void setupAdapter() {
        productsAdapter = new ProductsAdapter();
        productsAdapter.setProducts(products);
        productsAdapter.setOnItemActionListener(productId -> {
            Intent intent = new Intent(ProductsActivity.this, ProductDetailsActivity.class);
            // Todo use constants
            intent.putExtra("productId", productId);
            startActivity(intent);
        });
    }
}