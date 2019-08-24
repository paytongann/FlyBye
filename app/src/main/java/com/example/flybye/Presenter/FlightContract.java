package com.example.flybye.Presenter;

import com.example.flybye.Model.Results;
import com.example.flybye.View.ResultsViewContract;

public interface FlightContract {
    void initRetrofit();
    void onBindView(ResultsViewContract view);
}
