package com.example.flybye.View;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flybye.Model.Results;
import com.example.flybye.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Results dataSet;
    private Context context;
    private static final String TAG = "CustomAdapter";

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
        //Company name
        String companyId = dataSet.quotes.get(position).outboundLeg.carrierIds.toString();
        holder.tvCompanyName.setText(companyId);
        //Quote number
        holder.tvQuoteId.setText("Quote " + dataSet.quotes.get(position).quoteId.toString());
        Log.d(TAG,"SIZE: "+ dataSet.quotes.get(position));
        //Time
        String time = dataSet.quotes.get(position).quoteDateTime.split("T")[1];
        String hour = time.split(":")[0];
        String minute = time.split(":")[1];
        if (Integer.parseInt(hour) > 12) {
            hour = timeConverter(hour);
            holder.tvTime.setText(hour + ":" + minute + " PM");
        } else {
            holder.tvTime.setText(hour + ":" + minute + " AM");
        }
        //Date
        holder.tvDate.setText(dataSet.quotes.get(position).outboundLeg.departureDate.split("T")[0]);
        //Price
        holder.tvPrice.setText("$"+dataSet.quotes.get(position).minPrice.toString() +"0 USD");
        //Direct flight
        Boolean flightBool = dataSet.quotes.get(position).direct;
        String flightYesNo;
        if (flightBool.equals(true)){
            flightYesNo = "Yes";
        } else {
            flightYesNo = "No";
        }
        holder.tvDirect.setText("Direct Flight: " + flightYesNo);
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.quotes.size() : 0;
    }

    public String timeConverter(String time){
        if (time.equals("13")){
            time = "1";
        } else if (time.equals("14")){
            time = "2";
        } else if (time.equals("15")){
            time = "3";
        } else if (time.equals("16")){
            time = "4";
        } else if (time.equals("17")){
            time = "5";
        } else if (time.equals("18")){
            time = "6";
        } else if (time.equals("19")){
            time = "7";
        } else if (time.equals("20")){
            time = "8";
        } else if (time.equals("21")){
            time = "9";
        } else if (time.equals("22")){
            time = "10";
        } else if (time.equals("23")){
            time = "11";
        } else if (time.equals("00")){
            time = "12";
        } return time;
    }
}
