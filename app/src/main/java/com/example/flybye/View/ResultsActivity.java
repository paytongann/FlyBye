package com.example.flybye.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.flybye.Presenter.FlightContract;
import com.example.flybye.Presenter.FlightPresenter;
import com.example.flybye.R;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ResultsActivity extends AppCompatActivity {

    private FlightContract presenter;
    private TextView tvFromTo, tvCompanyNameOne, tvDirectFlightOne, tvPriceOne, tvDateTimeOne;
    private String companyOne, companyTwo, companyThree;
    private ImageView ivCompanyLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        setupViews();
        presenter = new FlightPresenter(ResultsActivity.this);
        presenter.initRetrofit();
    }

    public void setupViews(){
        tvFromTo = findViewById(R.id.tv_flight_from_to);
        tvCompanyNameOne = findViewById(R.id.tv_company_name_one);
        tvDirectFlightOne = findViewById(R.id.tv_directflight_one);
        tvPriceOne = findViewById(R.id.tv_price_one);
        tvDateTimeOne = findViewById(R.id.tv_date_time_one);
        ivCompanyLogo = findViewById(R.id.iv_logo_one);
    }

    public void editTitle(String from, String to){
        tvFromTo.setText("Leaving from " + from + " to " + to);
    }

    public void editQuoteOne(String companyName, String dateTime, String directFlight, String price){
        Log.d(TAG, "companyId" + companyOne.split("-")[1]);
        Log.d(TAG, "companyname" + companyName);
        if (companyName.equals(companyOne.split("-")[1])){
            companyName = companyOne.split("-")[0];
        } else if (companyName.equals(companyTwo.split("-")[1])){
            companyName = companyTwo.split("-")[0];
        } else if (companyName.equals(companyThree.split("-")[1])){
            companyName = companyThree.split("-")[0];
        }
        tvCompanyNameOne.setText(companyName);
        tvDateTimeOne.setText(dateTime);
        tvPriceOne.setText("$"+ price + " USD");
        tvDirectFlightOne.setText("Direct Flight: " + directFlight);
        setImage(companyName);
    }

    public void getCompanyNames(String nameOne, String nameTwo, String nameThree){
        companyOne = nameOne;
        companyTwo = nameTwo;
        companyThree = nameThree;
    }

    public void setImage(String companyName){
        if (companyName.equals("Frontier Airlines")){
            ivCompanyLogo.setImageResource(R.drawable.frontierairlines);
        } else if (companyName.equals("Spirit Airlines")){
            ivCompanyLogo.setImageResource(R.drawable.spiritairlines);
        }
    }
}
