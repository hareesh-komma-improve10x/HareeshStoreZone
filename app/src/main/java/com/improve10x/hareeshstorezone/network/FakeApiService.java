package com.improve10x.hareeshstorezone.network;

import com.improve10x.hareeshstorezone.Constants;
import com.improve10x.hareeshstorezone.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeApiService {
    @GET("products/categories")
    Call<List<String>> fetchCategories();
    @GET("products/category/{categoryName}")
    Call<List<Product>> fetchProducts(@Path("categoryName") String categoryName);
    @GET("products/{categoryId}")
    Call<Product> fetchProductDetails(@Path("categoryId") int productId);
}
