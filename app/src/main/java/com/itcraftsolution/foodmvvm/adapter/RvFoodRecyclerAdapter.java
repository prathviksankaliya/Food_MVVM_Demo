package com.itcraftsolution.foodmvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.itcraftsolution.foodmvvm.R;
import com.itcraftsolution.foodmvvm.apis.RetrofitInstance;
import com.itcraftsolution.foodmvvm.databinding.SampleRowBinding;
import com.itcraftsolution.foodmvvm.models.FoodCatModel;
import java.util.List;

public class RvFoodRecyclerAdapter extends RecyclerView.Adapter<RvFoodRecyclerAdapter.viewHolder> {
    Context context;
    List<FoodCatModel> list;

    public RvFoodRecyclerAdapter(Context context, List<FoodCatModel> list) {
        this.context = context;
        this.list = list;
    }

    public void updateFoodList(List<FoodCatModel> foodList)
    {
            list = foodList;
            notifyDataSetChanged();
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_row, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        FoodCatModel model = list.get(position);
        Glide.with(context).load(RetrofitInstance.catImage + model.getImg()).into(holder.binding.igImage);
        holder.binding.txDate.setText(model.getDate());
        holder.binding.txName.setText(model.getName());

    }

    @Override
    public int getItemCount() {
        if(list.isEmpty())
        {
            return 0;
        }else{
            return list.size();
        }
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        SampleRowBinding binding;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = SampleRowBinding.bind(itemView);
        }
    }
}
