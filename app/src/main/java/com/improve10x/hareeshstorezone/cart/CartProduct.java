package com.improve10x.hareeshstorezone.cart;

import java.util.ArrayList;

public class CartProduct {
    private Integer id;
    private Integer userId;
    private String date;

    public ArrayList<CartProductDetails> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
