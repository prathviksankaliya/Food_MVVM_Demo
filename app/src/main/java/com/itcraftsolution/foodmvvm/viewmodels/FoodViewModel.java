package com.itcraftsolution.foodmvvm.viewmodels;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.itcraftsolution.foodmvvm.apis.ApiInterface;
import com.itcraftsolution.foodmvvm.apis.RetrofitInstance;
import com.itcraftsolution.foodmvvm.models.FoodCatModel;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodViewModel extends ViewModel {

    private MutableLiveData<List<FoodCatModel>> foodList;

    public FoodViewModel() {
        foodList = new MutableLiveData<>();
    }

    public MutableLiveData<List<FoodCatModel>> getFoodList(){
        return foodList;
    }

    public void getApiData()
    {
        RetrofitInstance.getRetrofitClient().getCategories().enqueue(new Callback<List<FoodCatModel>>() {
            @Override
            public void onResponse(Call<List<FoodCatModel>> call, Response<List<FoodCatModel>> response) {
                if(response.isSuccessful())
                {
                    foodList.postValue(response.body());
                    Log.d("ReadyChhe", "Ha Data Aave chhe!!");
                }else{
                    Log.d("ReadyChhe", "Not Found!!!");
                }
            }

            @Override
            public void onFailure(Call<List<FoodCatModel>> call, Throwable t) {
                foodList.postValue(null);
                Log.d("ReadyChhe", t.getMessage());
            }
        });
    }
}
