package com.example.flybye.Presenter;

import android.content.Context;
import android.util.Log;

import com.example.flybye.Model.ApiInterface;
import com.example.flybye.Model.Results;
import com.example.flybye.View.CustomAdapter;
import com.example.flybye.View.MainActivity;
import com.example.flybye.View.ResultsActivity;
import com.example.flybye.View.ResultsViewContract;
import com.example.flybye.View.SearchFlightsActivity;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FlightPresenter implements FlightContract {

    private ResultsViewContract resultsView;
    private Context context;
    private Retrofit retrofit;
    private ApiInterface apiInterface;

    public FlightPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void initRetrofit(String departureDate, String departureAirport, String arrivalAirport) {
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/")
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
        apiInterface.getFlightData(departureAirport, arrivalAirport, departureDate).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Response<Results>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response<Results> resultsResponse) {
                if (resultsResponse.body().quotes.size() == 0){
                    ((ResultsActivity) context).noQuotesAvaible();
                } else {
                    String orgin = resultsResponse.body().quotes.get(0).outboundLeg.originId.toString();
                    String destination = resultsResponse.body().quotes.get(0).outboundLeg.destinationId.toString();
                    if (orgin.equals(resultsResponse.body().places.get(0).placeId)) {
                        orgin = resultsResponse.body().places.get(0).cityName;
                        destination = resultsResponse.body().places.get(1).cityName;
                    } else {
                        orgin = resultsResponse.body().places.get(1).cityName;
                        destination = resultsResponse.body().places.get(0).cityName;
                    }
                    ((ResultsActivity) context).editTitle(orgin, destination);
                    resultsView.onDataPopulated(resultsResponse.body());
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
            }
        });
    }

    @Override
    public void onBindView(ResultsViewContract view) {
        this.resultsView = view;
    }
}
