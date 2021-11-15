package com.example.andproject.user;

import com.google.gson.annotations.SerializedName;

public class JoinData {
    @SerializedName("UserID")
    private String UserID;

    @SerializedName("UserPW")
    private String UserPW;

    @SerializedName("UserNAME")
    private String UserName;

    @SerializedName("UserNO")
    private double UserNO;

    @SerializedName("UserTEL")
    private String UserTEL;

    @SerializedName("UserP_TEL")
    private String UserP_TEL;

    @SerializedName("UserLOC")
    private String UserLOC;

    public JoinData(String userID, String userPW, String userName, double userNO, String userTEL, String userP_TEL, String userLOC) {
        UserID = userID;
        UserPW = userPW;
        UserName = userName;
        UserNO = userNO;
        UserTEL = userTEL;
        UserP_TEL = userP_TEL;
        UserLOC = userLOC;
    }
}
