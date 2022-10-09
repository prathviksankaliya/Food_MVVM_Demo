package com.itcraftsolution.foodmvvm.apis;

import com.itcraftsolution.foodmvvm.models.FoodCatModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiInterface {

    //Read Categories
    @POST("read_category.php")
    Call<List<FoodCatModel>> getCategories();
}
