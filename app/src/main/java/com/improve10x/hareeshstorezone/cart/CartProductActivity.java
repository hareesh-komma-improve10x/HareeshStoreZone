package com.improve10x.hareeshstorezone.cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.improve10x.hareeshstorezone.BaseActivity;
import com.improve10x.hareeshstorezone.R;
import com.improve10x.hareeshstorezone.databinding.ActivityCartProductBinding;
import com.improve10x.hareeshstorezone.network.FakeApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartProductActivity extends BaseActivity {

    ActivityCartProductBinding binding;

    private CartProductsAdapter cartProductsAdapter;

    private ArrayList<CartProductDetails> cartProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Cart");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fetchCartProducts();
        setupAdapter();
        setupRv();
      }

    private void setupAdapter() {
        cartProductsAdapter = new CartProductsAdapter();
        cartProductsAdapter.setCartProducts(cartProducts);
    }

    private void setupRv() {
        binding.cartProductRv.setLayoutManager(new LinearLayoutManager(this));
        binding.cartProductRv.setAdapter(cartProductsAdapter);
    }

    private void fetchCartProducts() {
        Call<CartProduct> call = fakeApiService.fetchCartProducts();
        call.enqueue(new Callback<CartProduct>() {
            @Override
            public void onResponse(Call<CartProduct> call, Response<CartProduct> response) {
                CartProduct cartProduct = response.body();
                cartProductsAdapter.setCartProducts(cartProduct.products);
                showToast("Succesfully Load Data");
            }

            @Override
            public void onFailure(Call<CartProduct> call, Throwable t) {
                showToast("Failed to Load");
            }
        });
        
    }
}