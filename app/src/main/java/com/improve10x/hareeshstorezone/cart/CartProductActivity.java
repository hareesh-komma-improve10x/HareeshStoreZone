package com.improve10x.hareeshstorezone.cart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.improve10x.hareeshstorezone.R;
import com.improve10x.hareeshstorezone.databinding.ActivityCartProductBinding;

import java.util.ArrayList;

public class CartProductActivity extends AppCompatActivity {

    ActivityCartProductBinding binding;

    private ArrayList<CartProduct> cartProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Cart");
        showProgressBar();
        hideProgressBar();
    }

    private void hideProgressBar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void showProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }
}