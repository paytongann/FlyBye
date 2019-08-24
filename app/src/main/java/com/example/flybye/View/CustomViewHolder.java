package com.example.flybye.View;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flybye.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    TextView tvQuoteId, tvCompanyName, tvPrice, tvDirect, tvDateTime;
    ImageView ivLogo;


    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        tvQuoteId = itemView.findViewById(R.id.tv_quote);
        tvCompanyName = itemView.findViewById(R.id.tv_company_name);
        tvPrice = itemView.findViewById(R.id.tv_price);
        tvDirect = itemView.findViewById(R.id.tv_directflight);
        tvDateTime = itemView.findViewById(R.id.tv_date_time);
        ivLogo = itemView.findViewById(R.id.iv_logo);
    }
}
