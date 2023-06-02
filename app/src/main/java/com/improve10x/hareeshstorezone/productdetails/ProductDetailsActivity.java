package com.improve10x.hareeshstorezone.productdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.improve10x.hareeshstorezone.BaseActivity;
import com.improve10x.hareeshstorezone.Constants;
import com.improve10x.hareeshstorezone.R;
import com.improve10x.hareeshstorezone.databinding.ActivityProductDetailsBinding;
import com.improve10x.hareeshstorezone.model.Product;
import com.improve10x.hareeshstorezone.network.FakeApi;
import com.improve10x.hareeshstorezone.network.FakeApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends BaseActivity {
    private ActivityProductDetailsBinding binding;
    private int productId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Product Details");
        if (getIntent().hasExtra(Constants.KEY_PRODUCTS_VALUE)) {
            productId = getIntent().getIntExtra(Constants.KEY_PRODUCTS_VALUE, productId);
        }
        fetchProductDetails();
    }

    private void hideLoadingText() {
        binding.pleaseWaitTxt.setVisibility(View.GONE);
    }

    private void showLoadingText() {
        binding.pleaseWaitTxt.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }

    private void showProgressBar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void fetchProductDetails() {
        showProgressBar();
        showLoadingText();
        Call<Product> call = fakeApiService.fetchProductDetails(productId);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                hideProgressBar();
                hideLoadingText();
                Product product = response.body();
                binding.setProduct(product);
                binding.ratingBar.setRating(product.rating.getRate());
            }
            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                hideProgressBar();
                hideLoadingText();
                showToast("Failed To Loaded Data");
            }
        });
    }
}