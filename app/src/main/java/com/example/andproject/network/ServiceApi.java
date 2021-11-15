package com.example.andproject.network;

import com.example.andproject.user.JoinData;
import com.example.andproject.user.JoinResponse;
import com.example.andproject.user.LoginData;
import com.example.andproject.user.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceApi {
    @POST("/login")
    Call<LoginResponse> userLogin(@Body LoginData data);

    @POST("/join")
    Call<JoinResponse> userJoin(@Body JoinData data);

}
