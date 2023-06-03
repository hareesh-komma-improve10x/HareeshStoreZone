package com.improve10x.hareeshstorezone.network;

import com.improve10x.hareeshstorezone.Constants;
import com.improve10x.hareeshstorezone.cart.CartProduct;
import com.improve10x.hareeshstorezone.categories.Category;
import com.improve10x.hareeshstorezone.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeApiService {
    @GET("api/v1/categories")
    Call<List<Category>> fetchCategories();

    @GET("products/category/{categoryName}")
    Call<List<Product>> fetchProducts(@Path("categoryName") String categoryName);

    @GET("products/{categoryId}")
    Call<Product> fetchProductDetails(@Path("categoryId") int productId);

    @GET("carts/1?userId=1")
    Call<CartProduct> fetchCartProducts();
}
