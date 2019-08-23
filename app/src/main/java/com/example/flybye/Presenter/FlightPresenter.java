package com.example.flybye.Presenter;

import android.content.Context;
import android.util.Log;

import com.example.flybye.Model.ApiInterface;
import com.example.flybye.Model.Results;
import com.example.flybye.View.MainActivity;
import com.example.flybye.View.ResultsActivity;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FlightPresenter implements FlightContract {

    private Context context;
    private Retrofit retrofit;
    private ApiInterface apiInterface;

    public FlightPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/")
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
        apiInterface.getFlightData("2019-09-04").enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                if(response.isSuccessful()){
//                    Log.d(TAG, "Log Quote id " + response.body().quotes.get(0).quoteId);
//                    Log.d(TAG, "Log Minimum Price " + response.body().quotes.get(0).minPrice);
//                    Log.d(TAG, "Log Direct Flight " + response.body().quotes.get(0).direct);
//                    Log.d(TAG, "Log Day/Time " + response.body().quotes.get(0).quoteDateTime);
//                    Log.d(TAG, "Log Carrier Id " + response.body().quotes.get(0).outboundLeg.carrierIds);
//                    Log.d(TAG, "Log Quote id " + response.body().quotes.get(1).quoteId);
//                    Log.d(TAG, "Log Minimum Price " + response.body().quotes.get(1).minPrice);
//                    Log.d(TAG, "Log Direct Flight " + response.body().quotes.get(1).direct);
//                    Log.d(TAG, "Log Day/Time " + response.body().quotes.get(1).quoteDateTime);
//                    Log.d(TAG, "Log Carrier Id " + response.body().quotes.get(1).outboundLeg.carrierIds);
//                    Log.d(TAG, "Log Quote id " + response.body().quotes.get(2).quoteId);
//                    Log.d(TAG, "Log Minimum Price " + response.body().quotes.get(2).minPrice);
//                    Log.d(TAG, "Log Direct Flight " + response.body().quotes.get(2).direct);
//                    Log.d(TAG, "Log Day/Time " + response.body().quotes.get(2).quoteDateTime);
//                    Log.d(TAG, "Log Carrier Id " + response.body().quotes.get(2).outboundLeg.carrierIds);
//                    Log.d(TAG, "Log Carrier Id " + response.body().carriers.get(0).name + " " +response.body().carriers.get(0).carrierId);
//                    Log.d(TAG, "Log Carrier Id " + response.body().carriers.get(1).name + " "+ response.body().carriers.get(1).carrierId);
//                    Log.d(TAG, "Log Carrier Id " + response.body().carriers.get(2).name + " " + response.body().carriers.get(2).carrierId);
                    String departingCity = response.body().places.get(1).cityName;
                    String arrivingCity = response.body().places.get(0).cityName;
                    ((ResultsActivity) context).editTitle(departingCity, arrivingCity);
                    String carrierIdOne = response.body().quotes.get(0).outboundLeg.carrierIds.toString();
                    String dateTimeOne = response.body().quotes.get(0).quoteDateTime;
                    dateTimeOne = dateTimeOne.split("2019-")[1];
                    String dateOne = response.body().quotes.get(0).outboundLeg.departureDate.split("T")[0];
                    dateTimeOne = dateOne + "   " + dateTimeOne.split("T")[1];
                    Boolean directFlightOneBool = response.body().quotes.get(0).direct;
                    String directFlightOne;
                    if (directFlightOneBool.equals(false)) {
                        directFlightOne = "No";
                    } else {
                        directFlightOne = "Yes";
                    }

                    String companyOne = response.body().carriers.get(0).name + "-[" +response.body().carriers.get(0).carrierId+"]";
                    String companyTwo = response.body().carriers.get(1).name + "-[" +response.body().carriers.get(1).carrierId+"]";
//                    String companyThree = response.body().carriers.get(2).name + "-[" +response.body().carriers.get(2).carrierId+"]";
                    String companyThree = "";
                    ((ResultsActivity) context).getCompanyNames(companyOne, companyTwo, companyThree);
                    String priceOne = response.body().quotes.get(0).minPrice.toString() + "0";
                    ((ResultsActivity) context).editQuoteOne(carrierIdOne,dateTimeOne,directFlightOne, priceOne);
                }
                //Log.d(TAG, "bad code" + response.message());
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }
}
