package com.example.andproject.wash;

import com.google.gson.annotations.SerializedName;

public class WashReserve {
    @SerializedName("RoomNO")
    String RoomNO;

    @SerializedName("WashNum")
    int WashNum;

    @SerializedName("WashTime")
    int WashTime;

    @SerializedName("floor")
    int floor;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public WashReserve(String roomNO, int washNum, int washTime, int floor) {
        RoomNO = roomNO;
        WashNum = washNum;
        WashTime = washTime;
        this.floor = floor;
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
