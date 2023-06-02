package com.improve10x.hareeshstorezone.productdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.hareeshstorezone.R;
import com.improve10x.hareeshstorezone.databinding.ActivityProductDetailsBinding;
import com.improve10x.hareeshstorezone.model.Product;
import com.improve10x.hareeshstorezone.network.FakeApi;
import com.improve10x.hareeshstorezone.network.FakeApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends AppCompatActivity {

    public ActivityProductDetailsBinding binding;
    private int productId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Product Details");
        if (getIntent().hasExtra("productId")) {
            productId = getIntent().getIntExtra("productId", 0);
        }
        fetchProductDetails();
    }

    private void fetchProductDetails() {
        FakeApi fakeApi = new FakeApi();
        FakeApiService fakeApiService = fakeApi.createFakeApiService();
        Call<Product> call = fakeApiService.fetchProductDetails(productId);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                Toast.makeText(ProductDetailsActivity.this, "Successfully Data Added", Toast.LENGTH_SHORT).show();
                Product product = response.body();
                binding.setProduct(product);
                binding.ratingBar.setRating(product.rating.getRate());
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(ProductDetailsActivity.this, "Failed to Add Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}