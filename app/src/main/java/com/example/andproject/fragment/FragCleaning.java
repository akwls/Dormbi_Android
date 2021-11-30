package com.example.andproject.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.andproject.R;
import com.example.andproject.ReserveActivity;
import com.example.andproject.clean.CleanRoom;
import com.example.andproject.clean.StartRoom;
import com.example.andproject.network.RetrofitClient;
import com.example.andproject.network.ServiceApi;
import com.example.andproject.wash.WashReserve;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragCleaning extends Fragment {
    TextView txt4, txt5;
    TextView[] week = new TextView[5];
    Integer[] dayID = {R.id.txtw1, R.id.txtw2, R.id.txtw3, R.id.txtw4, R.id.txtw5 };
    int startRoom;
    int currentWeek;
    private ServiceApi service;
    int floor = 4;
    TextView txtMonth;
    TextView[] txtRoom = new TextView[7];
    Integer[] txtRoomId = {R.id.room1, R.id.room2, R.id.room3, R.id.room4, R.id.room5, R.id.room6, R.id.room7};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.frag_cleaning, container, false);
        txt4 = view.findViewById(R.id.txt4);
        txt5 = view.findViewById(R.id.txt5);
        txtMonth = view.findViewById(R.id.txtMonth);

        TimeZone tz;
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat monthFormat = new SimpleDateFormat("M", Locale.KOREAN);
        tz = TimeZone.getTimeZone("Asia/Seoul");
        monthFormat.setTimeZone(tz);
        int month = Integer.parseInt(monthFormat.format(currentTime));
        getStart(month);

        txtMonth.setText(month+"월");


        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt4.getCurrentTextColor() == Color.parseColor("#808080")) {
                    txt4.setTextColor(Color.parseColor("#FFFFFF"));
                    txt4.setBackgroundResource(R.drawable.floor_textview);
                    txt5.setTextColor(Color.parseColor("#808080"));
                    txt5.setBackgroundResource(0);
                    floor = 4;
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
                }
            }
        });

        for(int i=0; i<week.length; i++) {
            week[i] = view.findViewById(dayID[i]);
        }

        for(int i=0; i<txtRoom.length; i++) {
            txtRoom[i] = view.findViewById(txtRoomId[i]);
        }

        week[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(week[0].getCurrentTextColor() == Color.parseColor("#808080")) {
                    week[0].setTextColor(Color.parseColor("#FFFFFF"));
                    week[0].setBackgroundResource(R.drawable.floor_textview);
                    for(int i=0; i<week.length; i++) {
                        if(i != 0) {
                            week[i].setBackgroundResource(0);
                            week[i].setTextColor(Color.parseColor("#808080"));
                        }
                    }
                }
                getData((startRoom )%19);
            }
        });

        week[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(week[1].getCurrentTextColor() == Color.parseColor("#808080")) {
                    week[1].setTextColor(Color.parseColor("#FFFFFF"));
                    week[1].setBackgroundResource(R.drawable.floor_textview);
                    for(int i=0; i<week.length; i++) {
                        if(i != 1) {
                            week[i].setBackgroundResource(0);
                            week[i].setTextColor(Color.parseColor("#808080"));
                        }
                    }
                    getData((startRoom + 1 * 7)%19);
                }

            }
        });

        week[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(week[2].getCurrentTextColor() == Color.parseColor("#808080")) {
                    week[2].setTextColor(Color.parseColor("#FFFFFF"));
                    week[2].setBackgroundResource(R.drawable.floor_textview);
                    for(int i=0; i<week.length; i++) {
                        if(i != 2) {
                            week[i].setBackgroundResource(0);
                            week[i].setTextColor(Color.parseColor("#808080"));
                        }
                    }
                }
                getData((startRoom + 2 * 7)%19);
            }
        });

        week[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(week[3].getCurrentTextColor() == Color.parseColor("#808080")) {
                    week[3].setTextColor(Color.parseColor("#FFFFFF"));
                    week[3].setBackgroundResource(R.drawable.floor_textview);
                    for(int i=0; i<week.length; i++) {
                        if(i != 3) {
                            week[i].setBackgroundResource(0);
                            week[i].setTextColor(Color.parseColor("#808080"));
                        }
                    }
                }
                getData((startRoom + 3 * 7)%19);
            }
        });

        week[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(week[4].getCurrentTextColor() == Color.parseColor("#808080")) {
                    week[4].setTextColor(Color.parseColor("#FFFFFF"));
                    week[4].setBackgroundResource(R.drawable.floor_textview);
                    for(int i=0; i<week.length; i++) {
                        if(i != 4) {
                            week[i].setBackgroundResource(0);
                            week[i].setTextColor(Color.parseColor("#808080"));
                        }
                    }
                }
                getData((startRoom + 4 * 7)%19);
            }
        });

        return view;
    }
    void getStart(final int month) {
        service = RetrofitClient.getClient().create(ServiceApi.class);
        service.StartRoom(floor, month).enqueue(new Callback<StartRoom>() {
            @Override
            public void onResponse(Call<StartRoom> call, Response<StartRoom> response) {
                startRoom = response.body().getStart();
                Log.d("startRoom", Integer.toString(startRoom)+" " +Integer.toString(floor));
            }

            @Override
            public void onFailure(Call<StartRoom> call, Throwable t) {
                Log.d("startRoom", "fail");
            }
        });
    }

    void getData(final int start) {
        service = RetrofitClient.getClient().create(ServiceApi.class);
        service.CleanList(start, floor).enqueue(new Callback<List<CleanRoom>>() {
            @Override
            public void onResponse(Call<List<CleanRoom>> call, Response<List<CleanRoom>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("Clean getData", "성공" + start);
                    List<CleanRoom> result = response.body();
                    for (int i=0; i<7; i++) {
                        txtRoom[i].setText(result.get(i).getRoomNO() + "호");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<CleanRoom>> call, Throwable t) {
                Toast.makeText(getContext(), "오류 발생", Toast.LENGTH_SHORT).show();
                Log.d("오류 발생", t.getMessage());
            }
        });

    }
}
