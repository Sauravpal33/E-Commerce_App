package com.example.ecommerce_app.API;

import com.example.ecommerce_app.Model.Response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiSet {

    @GET("products")
    Call<Response> getProducts();
}
