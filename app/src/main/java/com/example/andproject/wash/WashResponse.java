package com.example.andproject.wash;

import com.google.gson.annotations.SerializedName;

public class WashResponse {
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
