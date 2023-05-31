package com.improve10x.hareeshstorezone;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FakeApiService {
    @GET("products/categories")
    Call<List<String>> fetchCategories();
}
