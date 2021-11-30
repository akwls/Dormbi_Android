package com.example.andproject.network;

import com.example.andproject.Goout;
import com.example.andproject.GooutResponse;
import com.example.andproject.clean.CleanRoom;
import com.example.andproject.clean.StartRoom;
import com.example.andproject.user.JoinData;
import com.example.andproject.user.JoinResponse;
import com.example.andproject.user.LoginData;
import com.example.andproject.user.LoginResponse;
import com.example.andproject.user.Score;
import com.example.andproject.user.ScoreResponse;
import com.example.andproject.wash.Wash;
import com.example.andproject.wash.WashReserve;
import com.example.andproject.wash.WashResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceApi {
    // 로그인
    @POST("/user/login")
    Call<LoginResponse> userLogin(@Body LoginData data);

    // 회원가입
    @POST("/user/join")
    Call<JoinResponse> userJoin(@Body JoinData data);

    // 상,벌점
    @POST("/user/score")
    Call<ScoreResponse> userScore(@Body Score score);

    // 호실별 지정 세탁기 시간
    @GET("/wash/washlist/{day}/{floor}")
    Call<List<Wash>> WashList(@Path("day") int day, @Path("floor") int floor);

    // 현재 세탁기 사용 여부
    @GET("/wash/washlist/{day}/{time}/{date}/{floor}")
    Call<List<WashReserve>> WashTimeList(@Path("day")  int day, @Path("time") int time, @Path("date") String date, @Path("floor") int floor);

    // 세탁기 시간 예약 POST
    @POST("/wash/reserve")
    Call<WashResponse> ReserveWash(@Body WashReserve wash);

    // 세탁기 시간 예약 GET
    @GET("/wash/reservelist/{date}/{floor}")
    Call<List<WashReserve>> ReserveList(@Path("date") String date, @Path("floor") int floor);

    @GET("/clean/cleanlist/{start}/{floor}")
    Call<List<CleanRoom>> CleanList(@Path("start") int start, @Path("floor") int floor);

    @POST("/goout/list")
    Call<GooutResponse> GooutList(@Body Goout goout);

    @DELETE("/user/{num}/{pw}")
    Call<JoinResponse> DeleteStudent (@Path("num") String num, @Path("pw") String pw);

    @GET("/clean/start/{floor}/{month}")
    Call<StartRoom> StartRoom (@Path("floor") int floor, @Path("month") int month);

}
