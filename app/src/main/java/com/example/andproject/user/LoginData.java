package com.example.andproject.user;

import com.google.gson.annotations.SerializedName;

public class LoginData {
    @SerializedName("UserID")
    String userId;

    @SerializedName("UserPW")
    String userPwd;

    public LoginData(String userId, String userPwd) {
        this.userId = userId;
        this.userPwd = userPwd;
    }
}
