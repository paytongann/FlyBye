package com.example.flybye.Model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Results {

    @SerializedName("Quotes")
    @Expose
    public List<Quote> quotes = null;
    @SerializedName("Places")
    @Expose
    public List<Place> places = null;
    @SerializedName("Carriers")
    @Expose
    public List<Carrier> carriers = null;
    @SerializedName("Currencies")
    @Expose
    public List<Currency> currencies = null;
}