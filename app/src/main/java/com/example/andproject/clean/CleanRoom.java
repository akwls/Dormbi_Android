package com.example.andproject.clean;

import com.google.gson.annotations.SerializedName;

public class CleanRoom {
    @SerializedName("RoomNO")
    String RoomNO;

    @SerializedName("RoomNum")
    int RoomNum;

    @SerializedName("RoomFloor")
    int RoomFloor;

    public CleanRoom(String roomNO, int roomNum, int roomFloor, int code) {
        RoomNO = roomNO;
        RoomNum = roomNum;
        RoomFloor = roomFloor;
    }

    public String getRoomNO() {
        return RoomNO;
    }

    public void setRoomNO(String roomNO) {
        RoomNO = roomNO;
    }

    public int getRoomNum() {
        return RoomNum;
    }

    public void setRoomNum(int roomNum) {
        RoomNum = roomNum;
    }

    public int getRoomFloor() {
        return RoomFloor;
    }

    public void setRoomFloor(int roomFloor) {
        RoomFloor = roomFloor;
    }
}
