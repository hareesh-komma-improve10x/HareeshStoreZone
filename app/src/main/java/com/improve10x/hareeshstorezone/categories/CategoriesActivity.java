package com.improve10x.hareeshstorezone.categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.hareeshstorezone.network.FakeApi;
import com.improve10x.hareeshstorezone.network.FakeApiService;
import com.improve10x.hareeshstorezone.databinding.ActivityCategoriesBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends AppCompatActivity {

    private ActivityCategoriesBinding binding;
    private List<String> categories = new ArrayList<>();
    private CategoriesAdapter categoriesAdapter;
    private FakeApiService fakeApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Categories");
        setupDummyData();
        setupAdapter();
        setupCategoriesRv();
        setupApiService();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchData();
    }

    private void fetchData() {
        Call<List<String>> call = fakeApiService.fetchCategories();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                List<String> categoriesList = response.body();
                categoriesAdapter.setData(categoriesList);
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(CategoriesActivity.this, "Failed to Load", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupApiService() {
        FakeApi fakeApi = new FakeApi();
        fakeApiService = fakeApi.createFakeApiService();
    }

    private void setupDummyData() {
        categories = new ArrayList<>();
    }

    private void setupCategoriesRv() {
        binding.categoriesRv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupAdapter() {
        categoriesAdapter = new CategoriesAdapter();
        categoriesAdapter.setData(categories);
        binding.categoriesRv.setAdapter(categoriesAdapter);
    }
}