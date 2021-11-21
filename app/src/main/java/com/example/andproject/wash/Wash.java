package com.example.andproject.wash;

import com.google.gson.annotations.SerializedName;

public class Wash {
    @SerializedName("RoomNO")
    String RoomNO;

    @SerializedName("RoomFloor")
    int RoomFloor;

    @SerializedName("RoomNum")
    int RoomNum;

    @SerializedName("WashNum")
    int WashNum;

    @SerializedName("WashDay")
    int WashDay;

    @SerializedName("WashTime")
    int WashTime;

    public Wash(String roomNO, int roomFloor, int roomNum, int washNum, int washDay, int washTime) {
        RoomNO = roomNO;
        RoomFloor = roomFloor;
        RoomNum = roomNum;
        WashNum = washNum;
        WashDay = washDay;
        WashTime = washTime;
    }

    public String getRoomNO() {
        return RoomNO;
    }

    public void setRoomNO(String roomNO) {
        RoomNO = roomNO;
    }

    public int getRoomFloor() {
        return RoomFloor;
    }

    public void setRoomFloor(int roomFloor) {
        RoomFloor = roomFloor;
    }

    public int getRoomNum() {
        return RoomNum;
    }

    public void setRoomNum(int roomNum) {
        RoomNum = roomNum;
    }

    public int getWashNum() {
        return WashNum;
    }

    public void setWashNum(int washNum) {
        WashNum = washNum;
    }

    public int getWashDay() {
        return WashDay;
    }

    public void setWashDay(int washDay) {
        WashDay = washDay;
    }

    public int getWashTime() {
        return WashTime;
    }

    public void setWashTime(int washTime) {
        WashTime = washTime;
    }
}
