package com.improve10x.hareeshstorezone;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.improve10x.hareeshstorezone.cart.CartProduct;
import com.improve10x.hareeshstorezone.model.Product;
import com.improve10x.hareeshstorezone.network.FakeApi;
import com.improve10x.hareeshstorezone.network.FakeApiService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void getCategory() throws IOException {
        FakeApiService service = new FakeApi().createFakeApiService();
        Call<List<String>> call = service.fetchCategories();
        List<String> categories = call.execute().body();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        System.out.println(new Gson().toJson(categories));
    }

    @Test
    public void getCategoryProduct() throws IOException {
        FakeApiService service = new FakeApi().createFakeApiService();
        Call<List<Product>> call = service.fetchProducts("jewelery");
        List<Product> products = call.execute().body();
        assertNotNull(products);
        assertFalse(products.isEmpty());
        System.out.println(new Gson().toJson(products));
    }
    @Test
    public void getCategoryProductDetails() throws IOException {
        FakeApiService service = new FakeApi().createFakeApiService();
        Call<Product> call = service.fetchProductDetails(1);
        Product productList = call.execute().body();
        assertNotNull(productList);
        System.out.println(new Gson().toJson(productList));
    }

    @Test
    public void getCart() throws IOException {
        FakeApiService fakeApiService = new FakeApi().createFakeApiService();
        Call<CartProduct> call = fakeApiService.fetchCartProducts(1);
        CartProduct categories = call.execute().body();
        assertNotNull(categories);
        System.out.println(new Gson().toJson(categories));
    }
}