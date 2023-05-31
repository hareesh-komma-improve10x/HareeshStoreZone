package com.improve10x.hareeshstorezone.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.improve10x.hareeshstorezone.R;
import com.improve10x.hareeshstorezone.databinding.ActivityProductsBinding;
import com.improve10x.hareeshstorezone.databinding.ProductsItemBinding;
import com.improve10x.hareeshstorezone.model.Product;
import com.improve10x.hareeshstorezone.network.FakeApi;
import com.improve10x.hareeshstorezone.network.FakeApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class ProductsActivity extends AppCompatActivity {

    private ActivityProductsBinding binding;
    private List<Product> products = new ArrayList<>();
    private ProductsAdapter productsAdapter;
    private FakeApiService fakeApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Products");
        setupAdapter();
        setupProductRv();
        setupProductApiService();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchData();
    }

    private void fetchData() {
        Call<List<Product>> call = fakeApiService.fetchProducts();

    }

    private void setupProductApiService() {
        FakeApi fakeApi = new FakeApi();
        fakeApiService = fakeApi.createFakeApiService();
    }

    private void setupProductRv() {
        binding.productRv.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void setupAdapter() {
        productsAdapter = new ProductsAdapter();
        productsAdapter.setProducts(products);
        binding.productRv.setAdapter(productsAdapter);
    }
}