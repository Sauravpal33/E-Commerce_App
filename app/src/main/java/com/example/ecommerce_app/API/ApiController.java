package com.example.ecommerce_app.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {

    private static final String url = "https://dummyjson.com/";
    private static ApiController clientObject;
    private static Retrofit retrofit;

    ApiController(){
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();
    }
    public static synchronized ApiController getInstance(){
        if (clientObject==null)
            clientObject = new ApiController();
        return clientObject;
    }
    public ApiSet getApi(){
        return retrofit.create(ApiSet.class);
    }

}
