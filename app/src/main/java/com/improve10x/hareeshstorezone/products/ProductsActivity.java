package com.improve10x.hareeshstorezone.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.hareeshstorezone.R;
import com.improve10x.hareeshstorezone.databinding.ActivityProductsBinding;
import com.improve10x.hareeshstorezone.databinding.ProductsItemBinding;
import com.improve10x.hareeshstorezone.model.Product;
import com.improve10x.hareeshstorezone.network.FakeApi;
import com.improve10x.hareeshstorezone.network.FakeApiService;
import com.improve10x.hareeshstorezone.productdetails.OnItemActionListener;
import com.improve10x.hareeshstorezone.productdetails.ProductDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity {

    private ActivityProductsBinding binding;
    private List<Product> products = new ArrayList<>();
    private ProductsAdapter productsAdapter;
    private FakeApiService fakeApiService;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (getIntent().hasExtra("category")) {
            category = getIntent().getStringExtra("category");
        }
        getSupportActionBar().setTitle("Products");
        fetchData();
        setupAdapter();
        setupProductRv();
        //setupProductApiService();
    }

    private void fetchData() {
        FakeApi fakeApi = new FakeApi();
        FakeApiService fakeApiService = fakeApi.createFakeApiService();
        Call<List<Product>> call = fakeApiService.fetchProducts(category);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> productList = response.body();
                productsAdapter.setProducts(productList);
                Toast.makeText(ProductsActivity.this, "Added Data", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(ProductsActivity.this, "Failed To Loaded Data", Toast.LENGTH_SHORT).show();

            }
        });
    }

    /*private void setupProductApiService() {
        FakeApi fakeApi = new FakeApi();
        fakeApiService = fakeApi.createFakeApiService();
    }*/

    private void setupProductRv() {
        binding.productRv.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void setupAdapter() {
        productsAdapter = new ProductsAdapter();
        productsAdapter.setProducts(products);
        binding.productRv.setAdapter(productsAdapter);
        productsAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onClicked(int productId) {
                Intent intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                intent.putExtra("productId", productId);
                startActivity(intent);
            }
        });
    }
}