package com.example.andproject.user;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("num")
    private String num;

    @SerializedName("name")
    private String name;

    @SerializedName("room")
    private String room;

    @SerializedName("loc")
    private String loc;

    @SerializedName("washday")
    private int washday;

    @SerializedName("washtime")
    private int washtime;

    @SerializedName("washnum")
    private int washnum;

    @SerializedName("good")
    private int good;

    @SerializedName("bad")
    private int bad;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public int getWashday() {
        return washday;
    }

    public void setWashday(int washday) {
        this.washday = washday;
    }

    public int getWashtime() {
        return washtime;
    }

    public void setWashtime(int washtime) {
        this.washtime = washtime;
    }



    public int getWashnum() {
        return washnum;
    }

    public void setWashnum(int washnum) {
        this.washnum = washnum;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public int getBad() {
        return bad;
    }

    public void setBad(int bad) {
        this.bad = bad;
    }

    public LoginResponse(int code, String message, String num, String name, String room, String loc, int washday, int washtime,  int washnum, int good, int bad) {
        this.code = code;
        this.message = message;
        this.num = num;
        this.name = name;
        this.room = room;
        this.loc = loc;
        this.washday = washday;
        this.washtime = washtime;
        this.washnum = washnum;
        this.good = good;
        this.bad = bad;
    }
}
