package com.improve10x.hareeshstorezone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.hareeshstorezone.network.FakeApi;
import com.improve10x.hareeshstorezone.network.FakeApiService;

public class BaseActivity extends AppCompatActivity {

    protected FakeApiService fakeApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        getSupportActionBar().hide();
        setupApi();
    }
    private void setupApi() {
        FakeApi fakeApi = new FakeApi();
        fakeApiService = fakeApi.createFakeApiService();
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}