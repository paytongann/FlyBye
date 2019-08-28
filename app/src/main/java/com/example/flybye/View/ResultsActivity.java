package com.example.flybye.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

public class ResultsActivity extends AppCompatActivity implements ResultsViewContract {

    private FlightContract presenter;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private TextView tvToFrom;
    String departureDate;
    String departureAirport;
    String arrivalAirport;
    String arrivalDate;
    String way;

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
        departureDate = getIntent().getStringExtra("departureDate");
        departureAirport = getIntent().getStringExtra("departureAirport");
        arrivalAirport = getIntent().getStringExtra("arrivalAirport");
        arrivalDate = getIntent().getStringExtra("arrivalDate");
        way = getIntent().getStringExtra("way");
        tvToFrom.setText("Leaving from " + departureAirport.split("-")[0] + " to " + arrivalAirport.split("-")[0]);
        presenter.initRetrofit(departureDate, departureAirport, arrivalAirport, arrivalDate);
        presenter.onBindView(this);
    }

    @Override
    public void onDataPopulated(Results results) {
        adapter.setDataSet(results);
        Log.d(TAG, "RES: " + results.quotes.size());
    }

    public void noQuotesAvaible() {
        Intent intent = new Intent(ResultsActivity.this, NoResults.class);
        setResult(RESULT_OK, intent);
        startActivity(intent);
    }

    public void onClick(View view) {
        String departureCode = departureAirport.split("-")[0];
        String arrivalCode = arrivalAirport.split("-")[0];

        String year = departureDate.split("20")[1];
        year = year.split("-")[0];
        String month = departureDate.split("-")[1];
        String day = departureDate.split("-")[2];
        String deptDate = year+month+day;

        String yearArrival = arrivalDate.split("20")[1];
        yearArrival = year.split("-")[0];
        String monthArrival = arrivalDate.split("-")[1];
        String dayArrival = arrivalDate.split("-")[2];
        String arrDate = yearArrival+monthArrival+dayArrival;

        String flightRoundTrip = "https://www.skyscanner.com/transport/flights/" + departureCode.toLowerCase() + "/" + arrivalCode.toLowerCase() + "/" +
                deptDate + "/"+ arrDate+ "/?adults=1&children=0&adultsv2=1&childrenv2=&infants=0" +
                "&cabinclass=economy&rtn=1&preferdirects=false&outboundaltsenabled=false&inboundaltsenabled=false&ref=home#results";
        String flightOneway = "https://www.skyscanner.com/transport/flights/" + departureCode.toLowerCase() + "/" + arrivalCode.toLowerCase() + "/" +
                deptDate +"/?adults=1&children=0&adultsv2=1&childrenv2=&infants=0&cabinclass=economy&rtn=0" +
                "&preferdirects=false&outboundaltsenabled=false&inboundaltsenabled=false&ref=home#results";
        String flightUrl;
        if (way.equals("roundtrip"))
            flightUrl = flightRoundTrip;
        else
            flightUrl = flightOneway;

        Uri uriUrl = Uri.parse(flightUrl);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
