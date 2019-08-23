package com.example.flybye.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Carrier {

    @SerializedName("CarrierId")
    @Expose
    public Integer carrierId;
    @SerializedName("Name")
    @Expose
    public String name;

}