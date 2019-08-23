package com.example.flybye.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OutboundLeg {

    @SerializedName("CarrierIds")
    @Expose
    public List<Integer> carrierIds = null;
    @SerializedName("OriginId")
    @Expose
    public Integer originId;
    @SerializedName("DestinationId")
    @Expose
    public Integer destinationId;
    @SerializedName("DepartureDate")
    @Expose
    public String departureDate;

}