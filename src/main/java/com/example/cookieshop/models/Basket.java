package com.example.cookieshop.models;

import java.util.List;

public class Basket {
    private List<Cookie> cookieList;

    public Basket(List<Cookie> cookieList) {
        this.cookieList = cookieList;
    }

    public List<Cookie> getCookieList() {
        return cookieList;
    }

    public void setCookieList(List<Cookie> cookieList) {
        this.cookieList = cookieList;
    }

    public int totalPrice(){
        int price = 0;
        for (Cookie cookie: cookieList) {
            price += cookie.getPrice();
        }
        return price;
    }
}
