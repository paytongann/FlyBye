package com.example.flybye.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flybye.Model.Results;
import com.example.flybye.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Results dataSet;
    private Context context;

    public void setDataSet(Results dataSet){
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    public CustomAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tvQuoteId.setText(dataSet.quotes.get(position).quoteId);
        holder.tvDateTime.setText(dataSet.quotes.get(position).outboundLeg.departureDate);
        holder.tvPrice.setText(dataSet.quotes.get(position).minPrice.toString());

    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.quotes.size() : 0;
    }
}
