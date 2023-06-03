package com.improve10x.hareeshstorezone.categories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.improve10x.hareeshstorezone.BaseActivity;
import com.improve10x.hareeshstorezone.Constants;
import com.improve10x.hareeshstorezone.R;
import com.improve10x.hareeshstorezone.cart.CartProductActivity;
import com.improve10x.hareeshstorezone.network.FakeApi;
import com.improve10x.hareeshstorezone.network.FakeApiService;
import com.improve10x.hareeshstorezone.databinding.ActivityCategoriesBinding;
import com.improve10x.hareeshstorezone.products.ProductsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends BaseActivity {

    private ActivityCategoriesBinding binding;
    private List<String> categories = new ArrayList<>();
    private CategoriesAdapter categoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().show();
        getSupportActionBar().setTitle("Categories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupAdapter();
        setupCategoriesRv();
        fetchData();

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

    private void fetchData() {
        showProgressBar();
        showLoadingText();
        Call<List<String>> call = fakeApiService.fetchCategories();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                hideProgressBar();
                hideLoadingText();
                List<String> categoriesList = response.body();
                categoriesAdapter.setData(categoriesList);
            }
            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                hideProgressBar();
                hideLoadingText();
                showToast("Failed to Load Data");
            }
        });
    }

    private void setupCategoriesRv() {
        binding.categoriesRv.setLayoutManager(new LinearLayoutManager(this));
        binding.categoriesRv.setAdapter(categoriesAdapter);
    }

    private void setupAdapter() {
        categoriesAdapter = new CategoriesAdapter();
        categoriesAdapter.setData(categories);
        categoriesAdapter.setOnItemActionListener(categoryName -> {
            Intent intent = new Intent(CategoriesActivity.this, ProductsActivity.class);
            intent.putExtra(Constants.KEY_CATEGORY_VALUE, categoryName);
            startActivity(intent);
        });
    }
}