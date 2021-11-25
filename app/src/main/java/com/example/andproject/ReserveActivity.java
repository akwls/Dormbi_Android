package com.example.andproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andproject.network.RetrofitClient;
import com.example.andproject.network.ServiceApi;
import com.example.andproject.user.UserInfo;
import com.example.andproject.wash.Wash;
import com.example.andproject.wash.WashReserve;
import com.example.andproject.wash.WashResponse;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReserveActivity extends AppCompatActivity {
    TextView[] day = new TextView[7];
    Integer[] dayID = {R.id.txt1, R.id.txt2, R.id.txt3, R.id.txt4, R.id.txt5, R.id.txt6, R.id.txt7 };
    androidx.appcompat.widget.Toolbar tb;
    private ServiceApi service;
    String[][][] wash_room = new String[7][3][3];
    String[] dayKorean = {"월", "화", "수", "목", "금", "토", "일"};
    TextView[][] txtWash = new TextView[3][3];
    Integer[][] washID = {{R.id.wash1_1, R.id.wash1_2, R.id.wash1_3}, {R.id.wash2_1, R.id.wash2_2, R.id.wash2_3}, {R.id.wash3_1, R.id.wash3_2, R.id.wash3_3}};
    int dayNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        tb = findViewById(R.id.toolbar) ;
        this.setSupportActionBar(tb);

        TextView action_bar_title = findViewById(R.id.action_bar_title);

        action_bar_title.setText("세탁기 예약");

        TimeZone tz;
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat dayFormat = new SimpleDateFormat("EE", Locale.KOREAN);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d", Locale.KOREAN);
        tz = TimeZone.getTimeZone("Asia/Seoul");  // TimeZone에 표준시 설정
        dayFormat.setTimeZone(tz);
        dateFormat.setTimeZone(tz);
        String weekday = dayFormat.format(currentTime);
        String todayDate = dateFormat.format(currentTime);
        Log.d("dateFormat",todayDate );

        //월 = 0, 화 = 1 ..
        for(int i=0; i<7; i++) {
            if(weekday.equals(dayKorean[i])) {
                dayNum = i;
            }
        }

        for(int i=0; i<7; i++) {
            for(int j=0; j<3; j++) {
                for(int k=0; k<3; k++) {
                    wash_room[i][j][k] = "     ";
                }
            }
        }

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                txtWash[i][j] = findViewById(washID[i][j]);
            }
        }

        for(int i=0; i<day.length; i++) {
            day[i] = findViewById(dayID[i]);
        }

        for(int i=0; i<5; i++) {
            getData(i+1);
        }

        setReserveList(todayDate, dayNum+1);
        // setData(dayNum);


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
                setData(0);
            }
            if(0 == dayNum) TextViewClick();
            else blockClick();
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
                setData(1);
            }
                if(1 == dayNum) TextViewClick();
                else blockClick();
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
                setData(2);
            }
                if(2 == dayNum) TextViewClick();
                else blockClick();
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
                setData(3);
            }
                if(3 == dayNum) TextViewClick();
                else blockClick();
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
                setData(4);
            }
                if(4 == dayNum) TextViewClick();
                else blockClick();
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
                setData(5);
            }
                if(5 == dayNum) TextViewClick();
                else blockClick();
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
                setData(6);
            }
                if(6 == dayNum) TextViewClick();
                else blockClick();
            }
        });


    }
    void getData(final int day) {
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
                            wash_room[day - 1][time - 1][num - 1] = roomNo;
                            Log.d("washlist", "성공: " + num + " " + time + " " + roomNo);

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


    void setData(int day) {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(wash_room[day][i][j].equals("     ")) {
                    txtWash[i][j].setText("     ");
                    txtWash[i][j].setTextColor(Color.parseColor("#000000"));
                    txtWash[i][j].setBackgroundResource(R.drawable.table_border_thinner);
                    txtWash[i][j].setTypeface(null, Typeface.NORMAL);
                }
                else {
                    txtWash[i][j].setText(wash_room[day][i][j] + "호");
                    txtWash[i][j].setTextColor(Color.parseColor("#ffffff"));
                    txtWash[i][j].setBackgroundResource(R.drawable.table_border_color);
                    txtWash[i][j].setTypeface(null, Typeface.BOLD);
                }
            }
        }
    }

    void setReserve(WashReserve wash) {
        service.ReserveWash(wash).enqueue(new Callback<WashResponse>() {
            @Override
            public void onResponse(Call<WashResponse> call, Response<WashResponse> response) {
                Log.d("setReserve", "세탁기 예약 성공");
                WashResponse result = response.body();
                Toast.makeText(ReserveActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<WashResponse> call, Throwable t) {
                Toast.makeText(ReserveActivity.this, "세탁기 예약 오류 발생", Toast.LENGTH_SHORT).show();
                Log.d("세탁기 오류 발생", t.getMessage());

            }
        });
    }

    void setReserveList(String date, final int day) {
        service.ReserveList(date).enqueue(new Callback<List<WashReserve>>() {
            @Override
            public void onResponse(Call<List<WashReserve>> call, Response<List<WashReserve>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("setReserve", "성공");
                    List<WashReserve> result = response.body();
                    for (WashReserve wash : result) {
                        int time = wash.getWashTime();
                        int num = wash.getWashNum();
                        String roomNo = wash.getRoomNO();
                        wash_room[day - 1][time - 1][num - 1] = roomNo;
                    }
                }
            }

            @Override
            public void onFailure(Call<List<WashReserve>> call, Throwable t) {
                Toast.makeText(ReserveActivity.this, "오류 발생", Toast.LENGTH_SHORT).show();
                Log.d("오류 발생", t.getMessage());
            }
        });
    }

    void TextViewClick() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                final int ii = i, jj = j;
                txtWash[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(txtWash[ii][jj].getText().equals("     ")) {
                            AlertDialog.Builder dlg = new AlertDialog.Builder(ReserveActivity.this);
                            dlg.setTitle("세탁기 시간 예약");
                            dlg.setMessage("해당 시간에 세탁기를 예약하시겠습니까?");
                            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    WashReserve wash = new WashReserve(UserInfo.getRoom(), ii+1, jj+1);
                                    Log.d("serreserve", "성공");
                                    setReserve(wash);
                                    wash_room[dayNum][ii][jj] = UserInfo.getRoom();
                                    txtWash[ii][jj].setText(UserInfo.getRoom() + "호");
                                }
                            });
                            dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                            dlg.show();
                        }
                        else {
                            Toast.makeText(ReserveActivity.this, "예약할 수 없는 시간대입니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        }
    }

    void blockClick() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                final int ii = i, jj = j;
                txtWash[ii][jj].setClickable(false);
            }
        }
    }


}
