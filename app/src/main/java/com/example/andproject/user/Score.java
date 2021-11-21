package com.example.andproject.user;

import com.google.gson.annotations.SerializedName;

public class Score {
    @SerializedName("good")
    String good;

    @SerializedName("bad")
    String bad;

    @SerializedName("StuNO")
    String StuNO;

    @SerializedName("StuName")
    String StuName;

    public Score(String good, String bad, String stuNO, String stuName) {
        this.good = good;
        this.bad = bad;
        this.StuNO = stuNO;
        this.StuName = stuName;
    }
}
