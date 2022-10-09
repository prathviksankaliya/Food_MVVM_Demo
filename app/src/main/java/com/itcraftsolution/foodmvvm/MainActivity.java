package com.itcraftsolution.foodmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.itcraftsolution.foodmvvm.adapter.RvFoodRecyclerAdapter;
import com.itcraftsolution.foodmvvm.databinding.ActivityMainBinding;
import com.itcraftsolution.foodmvvm.models.FoodCatModel;
import com.itcraftsolution.foodmvvm.viewmodels.FoodViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RvFoodRecyclerAdapter adapter;
    private List<FoodCatModel> list;
    private FoodViewModel foodViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        list = new ArrayList<>();

        adapter = new RvFoodRecyclerAdapter(this, list);
        binding.rvFoodCategory.setLayoutManager(new LinearLayoutManager(this));
        binding.rvFoodCategory.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        binding.rvFoodCategory.setAdapter(adapter);

        foodViewModel = new ViewModelProvider(this).get(FoodViewModel.class);
        foodViewModel.getFoodList().observe(this, new Observer<List<FoodCatModel>>() {
            @Override
            public void onChanged(List<FoodCatModel> foodCatModels) {
                if(foodCatModels.isEmpty())
                {
                    binding.txNotFound.setVisibility(View.VISIBLE);
                    binding.rvFoodCategory.setVisibility(View.GONE);
                }else
                {
                    list = foodCatModels;
                    adapter.updateFoodList(foodCatModels);
                    binding.txNotFound.setVisibility(View.GONE);
                }
            }
        });
        foodViewModel.getApiData();
    }
}