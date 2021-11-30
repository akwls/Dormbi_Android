package com.example.andproject.user;

public class UserInfo {
    public static String num, name, location, room;
    public static int washtime, washday, washnum, floor;
    public static int good, bad;

    public static String getNum() {
        return num;
    }

    public static void setNum(String num) {
        UserInfo.num = num;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        UserInfo.name = name;
    }

    public static String getLocation() {
        return location;
    }

    public static void setLocation(String location) {
        UserInfo.location = location;
    }

    public static String getRoom() {
        return room;
    }

    public static void setRoom(String room) {
        UserInfo.room = room;
    }

    public static int getWashtime() {
        return washtime;
    }

    public static void setWashtime(int washtime) {
        UserInfo.washtime = washtime;
    }

    public static int getWashday() {
        return washday;
    }

    public static void setWashday(int washday) {
        UserInfo.washday = washday;
    }

    public static int getWashnum() {
        return washnum;
    }

    public static void setWashnum(int washnum) {
        UserInfo.washnum = washnum;
    }

    public static int getGood() {
        return good;
    }

    public static void setGood(int good) {
        UserInfo.good = good;
    }

    public static int getBad() {
        return bad;
    }

    public static void setBad(int bad) {
        UserInfo.bad = bad;
    }

    public static int getFloor() {
        return floor;
    }

    public static void setFloor(int floor) {
        UserInfo.floor = floor;
    }

    public UserInfo(String num, String name, String location, String room, int washtime, int washday, int washnum, int good, int bad, int floor) {
        this.num = num;
        this.name = name;
        this.location = location;
        this.room = room;
        this.washtime = washtime;
        this.washday = washday;
        this.washnum = washnum;
        this.good = good;
        this.bad = bad;
        this.floor = floor;
    }
}
