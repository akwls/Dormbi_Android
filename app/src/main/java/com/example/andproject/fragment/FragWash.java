package com.example.andproject.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.andproject.R;
import com.example.andproject.ReserveActivity;
import com.example.andproject.network.RetrofitClient;
import com.example.andproject.network.ServiceApi;
import com.example.andproject.wash.Wash;
import com.example.andproject.wash.WashReserve;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragWash extends Fragment {
    ImageView[] machine = new ImageView[3];
    Button machine_reserve;
    TextView txt4, txt5;
    String[] dayKorean = {"월", "화", "수", "목", "금", "토", "일"};
    private ServiceApi service;
    boolean[] isUsed = new boolean[3];
    String[] usingRoom = new String[3];
    TextView[] txtMachine = new TextView[3];
    Integer[] txtMachineId = {R.id.txtMachine1, R.id.txtMachine2, R.id.txtMachine3};
    int floor = 4;
    int dayNum, timeNum;
    String todayDate;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.frag_wash, container, false);
        machine[0] = view.findViewById(R.id.washing_machine_1);
        machine[1] = view.findViewById(R.id.washing_machine_2);
        machine[2] = view.findViewById(R.id.washing_machine_3);

        TimeZone tz;
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat dayFormat = new SimpleDateFormat("EE", Locale.KOREAN);
        SimpleDateFormat timeFormat = new SimpleDateFormat("k", Locale.KOREAN);
        SimpleDateFormat minuteFormat = new SimpleDateFormat("mm", Locale.KOREAN);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d", Locale.KOREAN);
        tz = TimeZone.getTimeZone("Asia/Seoul");  // TimeZone에 표준시 설정
        dayFormat.setTimeZone(tz);
        timeFormat.setTimeZone(tz);
        minuteFormat.setTimeZone(tz);
        dateFormat.setTimeZone(tz);
        todayDate = dateFormat.format(currentTime);
        int nowHour = Integer.parseInt(timeFormat.format(currentTime));
        int nowMinute = Integer.parseInt(minuteFormat.format(currentTime));

        String weekday = dayFormat.format(currentTime);
        String time = timeFormat.format(currentTime);

        String timeString  = timeFormat.format(currentTime)+minuteFormat.format(currentTime);
        int timeInt = Integer.parseInt(timeString);

        dayNum = 0;
        timeNum = 0;

        for(int i=0; i<7; i++) {
            if(weekday.equals(dayKorean[i])) {
                dayNum = i+1;
            }
        }

        if(timeInt >= 1900 && timeInt <= 2010 ) {
            timeNum = 1;
        }
        else if(timeInt > 2010 && timeInt <= 2120) {
            timeNum = 2;
        }
        else if(timeInt > 2120 && timeInt <= 2230) {
            timeNum = 3;
        }
        for(int i=0; i<3; i++) {
            usingRoom[i] = "";
            isUsed[i] = false;
            txtMachine[i] = view.findViewById(txtMachineId[i]);
        }

        Log.d("today", dayNum + " " + nowHour + " " + nowMinute + " " + timeNum);
        getData(dayNum, timeNum, todayDate);





        machine_reserve = view.findViewById(R.id.washing_machine_reserve);

        txt4 = view.findViewById(R.id.txt4);
        txt5 = view.findViewById(R.id.txt5);

        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt4.getCurrentTextColor() == Color.parseColor("#808080")) {
                    txt4.setTextColor(Color.parseColor("#FFFFFF"));
                    txt4.setBackgroundResource(R.drawable.floor_textview);
                    txt5.setTextColor(Color.parseColor("#808080"));
                    txt5.setBackgroundResource(0);
                    floor = 4;
                    getData(dayNum, timeNum, todayDate);
                }


            }
        });

        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt5.getCurrentTextColor() == Color.parseColor("#808080")) {
                    txt5.setTextColor(Color.parseColor("#FFFFFF"));
                    txt5.setBackgroundResource(R.drawable.floor_textview);
                    txt4.setTextColor(Color.parseColor("#808080"));
                    txt4.setBackgroundResource(0);
                    floor = 5;
                    getData(dayNum, timeNum, todayDate);
                }
            }
        });

        machine_reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getContext(), ReserveActivity.class);
                in.putExtra("floor", floor);
                startActivity(in);
            }
        });

        return view;
    }
    void getData(final int day, final int time, final String date) {
        if(day < 6) {
            service = RetrofitClient.getClient().create(ServiceApi.class);
            Call<List<WashReserve>> call = service.WashTimeList(day, time, date, floor);
            call.enqueue(new Callback<List<WashReserve>>() {
                @Override
                public void onResponse(Call<List<WashReserve>> call, Response<List<WashReserve>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        Log.d("washlist", "성공");
                        List<WashReserve> result = response.body();
                        for (WashReserve wash : result) {
                            int time = wash.getWashTime();
                            int num = wash.getWashNum();
                            String roomNo = wash.getRoomNO();
                            isUsed[num-1] = true;
                            usingRoom[num-1] = roomNo;
                            Log.d("washlist", "성공: " + num + " " + time + " " + roomNo);

                        }
                    }
                    for(int i=0; i<3; i++) {
                        if(isUsed[i]) {
                            Log.d("using", "true");
                            machine[i].setImageResource(R.drawable.washing_machine_closed);
                            txtMachine[i].setText(usingRoom[i]+"호");
                        }
                        else {
                            Log.d("using", "false");
                            machine[i].setImageResource(R.drawable.washing_machine_opened);
                            txtMachine[i].setText("");
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<WashReserve>> call, Throwable t) {
                    Log.d("myapp", "question - Failure error");
                    Log.e("myapp", "에러 : " + t.getMessage());
                    Toast.makeText(getContext(), "인터넷 연결이 필요합니다.", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
