package com.itcraftsolution.foodmvvm.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static String baseurl = "http://192.168.87.115/foodadda_api/api/";

    public static String catImage = "http://192.168.87.115/foodadda_api/admin/images/category/";
    private static Retrofit retrofit;

    public static ApiInterface getRetrofitClient()
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }
}
