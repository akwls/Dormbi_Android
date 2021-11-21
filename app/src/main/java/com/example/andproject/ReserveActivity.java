package com.example.andproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andproject.network.RetrofitClient;
import com.example.andproject.network.ServiceApi;
import com.example.andproject.wash.Wash;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReserveActivity extends AppCompatActivity {
    TextView[] day = new TextView[7];
    Integer[] dayID = {R.id.txt1, R.id.txt2, R.id.txt3, R.id.txt4, R.id.txt5, R.id.txt6, R.id.txt7 };
    androidx.appcompat.widget.Toolbar tb;
    private ServiceApi service;
    String[][] wash_room = new String[3][3];
    TextView[][] txtWash = new TextView[3][3];
    Integer[][] washID = {{R.id.wash1_1, R.id.wash1_2, R.id.wash1_3}, {R.id.wash2_1, R.id.wash2_2, R.id.wash2_3}, {R.id.wash3_1, R.id.wash3_2, R.id.wash3_3}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        tb = findViewById(R.id.toolbar) ;
        this.setSupportActionBar(tb);

        TextView action_bar_title = findViewById(R.id.action_bar_title);

        action_bar_title.setText("세탁기 예약");

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                txtWash[i][j] = findViewById(washID[i][j]);
            }
        }

        for(int i=0; i<day.length; i++) {
            day[i] = findViewById(dayID[i]);
        }

        day[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(day[0].getCurrentTextColor() == Color.parseColor("#808080")) {
                    day[0].setTextColor(Color.parseColor("#FFFFFF"));
                    day[0].setBackgroundResource(R.drawable.floor_textview);
                    for(int i=0; i<day.length; i++) {
                        if(i != 0) {
                            day[i].setBackgroundResource(0);
                            day[i].setTextColor(Color.parseColor("#808080"));
                        }
                    }
                    getData(1);
                }
            }
        });

        day[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(day[1].getCurrentTextColor() == Color.parseColor("#808080")) {
                    day[1].setTextColor(Color.parseColor("#FFFFFF"));
                    day[1].setBackgroundResource(R.drawable.floor_textview);
                    for(int i=0; i<day.length; i++) {
                        if(i != 1) {
                            day[i].setBackgroundResource(0);
                            day[i].setTextColor(Color.parseColor("#808080"));
                        }
                    }
                    getData(2);
                }
            }
        });

        day[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(day[2].getCurrentTextColor() == Color.parseColor("#808080")) {
                    day[2].setTextColor(Color.parseColor("#FFFFFF"));
                    day[2].setBackgroundResource(R.drawable.floor_textview);
                    for(int i=0; i<day.length; i++) {
                        if(i != 2) {
                            day[i].setBackgroundResource(0);
                            day[i].setTextColor(Color.parseColor("#808080"));
                        }
                    }
                    getData(3);
                }
            }
        });

        day[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(day[3].getCurrentTextColor() == Color.parseColor("#808080")) {
                    day[3].setTextColor(Color.parseColor("#FFFFFF"));
                    day[3].setBackgroundResource(R.drawable.floor_textview);
                    for(int i=0; i<day.length; i++) {
                        if(i != 3) {
                            day[i].setBackgroundResource(0);
                            day[i].setTextColor(Color.parseColor("#808080"));
                        }
                    }
                    getData(4);
                }
            }
        });

        day[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(day[4].getCurrentTextColor() == Color.parseColor("#808080")) {
                    day[4].setTextColor(Color.parseColor("#FFFFFF"));
                    day[4].setBackgroundResource(R.drawable.floor_textview);
                    for(int i=0; i<day.length; i++) {
                        if(i != 4) {
                            day[i].setBackgroundResource(0);
                            day[i].setTextColor(Color.parseColor("#808080"));
                        }
                    }
                    getData(5);
                }
            }
        });
        day[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(day[5].getCurrentTextColor() == Color.parseColor("#808080")) {
                    day[5].setTextColor(Color.parseColor("#FFFFFF"));
                    day[5].setBackgroundResource(R.drawable.floor_textview);
                    for(int i=0; i<day.length; i++) {
                        if(i != 5) {
                            day[i].setBackgroundResource(0);
                            day[i].setTextColor(Color.parseColor("#808080"));
                        }
                    }
                    getData(6);
                }
            }
        });
        day[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(day[6].getCurrentTextColor() == Color.parseColor("#808080")) {
                    day[6].setTextColor(Color.parseColor("#FFFFFF"));
                    day[6].setBackgroundResource(R.drawable.floor_textview);
                    for(int i=0; i<day.length; i++) {
                        if(i != 6) {
                            day[i].setBackgroundResource(0);
                            day[i].setTextColor(Color.parseColor("#808080"));
                        }
                    }
                    getData(7);
                }
            }
        });
        getData(1);
    }
    void getData(int day) {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                txtWash[i][j].setText("");
                txtWash[i][j].setTextColor(Color.parseColor("#000000"));
                txtWash[i][j].setBackgroundResource(R.drawable.table_border_thinner);
                txtWash[i][j].setTypeface(null, Typeface.NORMAL);
            }
        }
        if(day < 6) {
            service = RetrofitClient.getClient().create(ServiceApi.class);
            Call<List<Wash>> call = service.WashList(day);
            call.enqueue(new Callback<List<Wash>>() {
                @Override
                public void onResponse(Call<List<Wash>> call, Response<List<Wash>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        Log.d("washlist", "성공");
                        List<Wash> result = response.body();
                        for (Wash wash : result) {
                            int time = wash.getWashTime();
                            int num = wash.getWashNum();
                            String roomNo = wash.getRoomNO();
                            Log.d("washlist", "성공: " + num + " " + time + " " + roomNo);
                            txtWash[time - 1][num - 1].setText(roomNo + "호");
                            txtWash[time - 1][num - 1].setTextColor(Color.parseColor("#ffffff"));
                            txtWash[time - 1][num - 1].setBackgroundResource(R.drawable.table_border_color);
                            txtWash[time - 1][num - 1].setTypeface(null, Typeface.BOLD);
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<Wash>> call, Throwable t) {
                    Log.d("myapp", "question - Failure error");
                    Log.e("myapp", "에러 : " + t.getMessage());
                    Toast.makeText(getApplicationContext(), "인터넷 연결이 필요합니다.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
