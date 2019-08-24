package com.example.flybye.Model;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    //https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/US/USD/en-US/DFW-sky/ATL-sky/2019-09-01?inboundpartialdate=2019-09-04

    @Headers("x-rapidapi-key: 7afc17c527mshe16c80e24abb5fcp12ba64jsn7e8ac0a27b1f")
    @GET("apiservices/browsequotes/v1.0/US/USD/en-US/{originplace}/{destinationplace}/{outboundpartialdate}")
    Observable<Results> getFlightData(
            @Path("originplace") String orginPlace,
            @Path("destinationplace") String destinationPlace,
            @Path("outboundpartialdate") String outbound);
    //      @Query("inboundpartialdate") String date);
}
