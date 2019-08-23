package com.example.flybye.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quote {

    @SerializedName("QuoteId")
    @Expose
    public Integer quoteId;
    @SerializedName("MinPrice")
    @Expose
    public Double minPrice;
    @SerializedName("Direct")
    @Expose
    public Boolean direct;
    @SerializedName("OutboundLeg")
    @Expose
    public OutboundLeg outboundLeg;
    @SerializedName("QuoteDateTime")
    @Expose
    public String quoteDateTime;

}