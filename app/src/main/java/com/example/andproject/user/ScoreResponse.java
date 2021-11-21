package com.example.andproject.user;

import com.google.gson.annotations.SerializedName;

public class ScoreResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
