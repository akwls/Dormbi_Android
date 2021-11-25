package com.example.andproject;

import com.google.gson.annotations.SerializedName;

public class Goout {
    @SerializedName("StuNO")
    String StuNO;

    @SerializedName("StuName")
    String StuName;

    @SerializedName("StuRoom")
    String StuRoom;

    @SerializedName("startDay")
    String startDay;

    @SerializedName("endDay")
    String endDay;

    @SerializedName("pTel")
    String pTel;

    public Goout(String stuNO, String stuName, String stuRoom, String startDay, String endDay, String pTel) {
        StuNO = stuNO;
        StuName = stuName;
        StuRoom = stuRoom;
        this.startDay = startDay;
        this.endDay = endDay;
        this.pTel = pTel;
    }
}
