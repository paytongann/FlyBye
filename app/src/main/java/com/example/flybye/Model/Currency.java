package com.example.flybye.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currency {

    @SerializedName("Code")
    @Expose
    public String code;
    @SerializedName("Symbol")
    @Expose
    public String symbol;
    @SerializedName("ThousandsSeparator")
    @Expose
    public String thousandsSeparator;
    @SerializedName("DecimalSeparator")
    @Expose
    public String decimalSeparator;
    @SerializedName("SymbolOnLeft")
    @Expose
    public Boolean symbolOnLeft;
    @SerializedName("SpaceBetweenAmountAndSymbol")
    @Expose
    public Boolean spaceBetweenAmountAndSymbol;
    @SerializedName("RoundingCoefficient")
    @Expose
    public Integer roundingCoefficient;
    @SerializedName("DecimalDigits")
    @Expose
    public Integer decimalDigits;

}