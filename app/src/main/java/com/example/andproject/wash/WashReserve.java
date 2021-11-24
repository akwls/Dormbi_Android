package com.example.andproject.wash;

import com.google.gson.annotations.SerializedName;

public class WashReserve {
    @SerializedName("RoomNO")
    String RoomNO;

    @SerializedName("WashNum")
    int WashNum;

    @SerializedName("WashTime")
    int WashTime;

    public WashReserve(String roomNO, int washNum,  int washTime) {
        RoomNO = roomNO;
        WashNum = washNum;
        WashTime = washTime;
    }

    public String getRoomNO() {
        return RoomNO;
    }

    public void setRoomNO(String roomNO) {
        RoomNO = roomNO;
    }

    public int getWashNum() {
        return WashNum;
    }

    public void setWashNum(int washNum) {
        WashNum = washNum;
    }

    public int getWashTime() {
        return WashTime;
    }

    public void setWashTime(int washTime) {
        WashTime = washTime;
    }
}
