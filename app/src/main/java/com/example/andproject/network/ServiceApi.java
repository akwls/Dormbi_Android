package com.example.andproject.network;

import com.example.andproject.user.JoinData;
import com.example.andproject.user.JoinResponse;
import com.example.andproject.user.LoginData;
import com.example.andproject.user.LoginResponse;
import com.example.andproject.user.Score;
import com.example.andproject.user.ScoreResponse;
import com.example.andproject.wash.Wash;
import com.example.andproject.wash.WashResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceApi {
    @POST("/user/login")
    Call<LoginResponse> userLogin(@Body LoginData data);

    @POST("/user/join")
    Call<JoinResponse> userJoin(@Body JoinData data);

    @POST("/user/score")
    Call<ScoreResponse> userScore(@Body Score score);

    @GET("/wash/washlist/{day}")
    Call<List<Wash>> WashList(@Path("day") int day);

}
