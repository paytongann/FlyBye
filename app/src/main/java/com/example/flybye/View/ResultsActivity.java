package com.example.flybye.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.flybye.Model.ApiInterface;
import com.example.flybye.Model.Results;
import com.example.flybye.Presenter.FlightContract;
import com.example.flybye.Presenter.FlightPresenter;
import com.example.flybye.R;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ResultsActivity extends AppCompatActivity implements ResultsViewContract{

    private ResultsViewContract resultsView;
    private FlightContract presenter;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter(this);
        recyclerView.setAdapter(adapter);
        presenter = new FlightPresenter(ResultsActivity.this);
        presenter.onBindView(this);
        presenter.initRetrofit();

    }

    @Override
    public void onDataPopulated(Results results) {
        adapter.setDataSet(results);
    }


//
//    public void editTitle(String from, String to){
//        tvFromTo.setText("Leaving from " + from + " to " + to);
//    }
//
//    public void editQuoteOne(String companyName, String dateTime, String directFlight, String price){
//        Log.d(TAG, "companyId" + companyOne.split("-")[1]);
//        Log.d(TAG, "companyname" + companyName);
//        if (companyName.equals(companyOne.split("-")[1])){
//            companyName = companyOne.split("-")[0];
////        } else if (companyName.equals(companyTwo.split("-")[1])){
////            companyName = companyTwo.split("-")[0];
////        } else if (companyName.equals(companyThree.split("-")[1])){
////            companyName = companyThree.split("-")[0];
//        }
//        tvCompanyNameOne.setText(companyName);
//        tvDateTimeOne.setText(dateTime);
//        tvPriceOne.setText("$"+ price + " USD");
//        tvDirectFlightOne.setText("Direct Flight: " + directFlight);
//        setImage(companyName);
//    }
//
//    public void getCompanyNames(String nameOne){
//        companyOne = nameOne;
//    }
//
//    public void setImage(String companyName){
//        if (companyName.equals("Frontier Airlines")){
//            ivCompanyLogo.setImageResource(R.drawable.frontierairlines);
//        } else if (companyName.equals("Spirit Airlines")){
//            ivCompanyLogo.setImageResource(R.drawable.spiritairlines);
//        }
//    }
}
