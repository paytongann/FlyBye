package com.example.flybye.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
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

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ResultsActivity extends AppCompatActivity implements ResultsViewContract{

    private FlightContract presenter;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private TextView tvToFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        presenter = new FlightPresenter(ResultsActivity.this);
        tvToFrom = findViewById(R.id.tv_flight_from_to);
        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter(this);
        recyclerView.setAdapter(adapter);
        String departureDate = getIntent().getStringExtra("departureDate");
        String departureAirport = getIntent().getStringExtra("departureAirport");
        String arrivalAirport = getIntent().getStringExtra("arrivalAirport");
        presenter.initRetrofit(departureDate, departureAirport, arrivalAirport);
        presenter.onBindView(this);
    }

    @Override
    public void onDataPopulated(Results results) {
        adapter.setDataSet(results);
        Log.d(TAG,"RES: "+results.quotes.size());
    }

    public void noQuotesAvaible(){
        Intent intent = new Intent(ResultsActivity.this, NoResults.class);
        setResult(RESULT_OK,intent);
        startActivity(intent);
    }

    public void editTitle(String from, String to){
        tvToFrom.setText("Leaving from " + from + " to " + to);
    }
}
