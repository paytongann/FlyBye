package com.example.flybye.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Place {

    @SerializedName("PlaceId")
    @Expose
    public Integer placeId;
    @SerializedName("IataCode")
    @Expose
    public String iataCode;
    @SerializedName("Name")
    @Expose
    public String name;
    @SerializedName("Type")
    @Expose
    public String type;
    @SerializedName("SkyscannerCode")
    @Expose
    public String skyscannerCode;
    @SerializedName("CityName")
    @Expose
    public String cityName;
    @SerializedName("CityId")
    @Expose
    public String cityId;
    @SerializedName("CountryName")
    @Expose
    public String countryName;

}