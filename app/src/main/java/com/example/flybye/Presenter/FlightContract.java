package com.example.flybye.Presenter;

import com.example.flybye.Model.Results;
import com.example.flybye.View.ResultsViewContract;

public interface FlightContract {
    void initRetrofit(String departureDate, String departureAirport, String arrivalAirport, String arrivalDate);
    void onBindView(ResultsViewContract view);
}
