package com.example.andproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ReserveActivity extends AppCompatActivity {
    TextView[] day = new TextView[5];
    Integer[] dayID = {R.id.txt1, R.id.txt2, R.id.txt3, R.id.txt4, R.id.txt5 };
    androidx.appcompat.widget.Toolbar tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        tb = findViewById(R.id.toolbar) ;
        this.setSupportActionBar(tb);

        TextView action_bar_title = findViewById(R.id.action_bar_title);
        TextView action_bar_subtitle = findViewById(R.id.action_bar_subtitle);

        action_bar_title.setText("세탁기 예약");
        action_bar_subtitle.setText("예약하려면 빈 칸을 클릭하세요.");

        for(int i=0; i<5; i++) {
            day[i] = findViewById(dayID[i]);
        }

        day[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(day[0].getCurrentTextColor() == Color.parseColor("#808080")) {
                    day[0].setTextColor(Color.parseColor("#FFFFFF"));
                    day[0].setBackgroundResource(R.drawable.floor_textview);
                    for(int i=0; i<5; i++) {
                        if(i != 0) {
                            day[i].setBackgroundResource(0);
                            day[i].setTextColor(Color.parseColor("#808080"));
                        }
                    }
                }
            }
        });

        day[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(day[1].getCurrentTextColor() == Color.parseColor("#808080")) {
                    day[1].setTextColor(Color.parseColor("#FFFFFF"));
                    day[1].setBackgroundResource(R.drawable.floor_textview);
                    for(int i=0; i<5; i++) {
                        if(i != 1) {
                            day[i].setBackgroundResource(0);
                            day[i].setTextColor(Color.parseColor("#808080"));
                        }
                    }
                }
            }
        });

        day[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(day[2].getCurrentTextColor() == Color.parseColor("#808080")) {
                    day[2].setTextColor(Color.parseColor("#FFFFFF"));
                    day[2].setBackgroundResource(R.drawable.floor_textview);
                    for(int i=0; i<5; i++) {
                        if(i != 2) {
                            day[i].setBackgroundResource(0);
                            day[i].setTextColor(Color.parseColor("#808080"));
                        }
                    }
                }
            }
        });

        day[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(day[3].getCurrentTextColor() == Color.parseColor("#808080")) {
                    day[3].setTextColor(Color.parseColor("#FFFFFF"));
                    day[3].setBackgroundResource(R.drawable.floor_textview);
                    for(int i=0; i<5; i++) {
                        if(i != 3) {
                            day[i].setBackgroundResource(0);
                            day[i].setTextColor(Color.parseColor("#808080"));
                        }
                    }
                }
            }
        });

        day[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(day[4].getCurrentTextColor() == Color.parseColor("#808080")) {
                    day[4].setTextColor(Color.parseColor("#FFFFFF"));
                    day[4].setBackgroundResource(R.drawable.floor_textview);
                    for(int i=0; i<5; i++) {
                        if(i != 4) {
                            day[i].setBackgroundResource(0);
                            day[i].setTextColor(Color.parseColor("#808080"));
                        }
                    }
                }
            }
        });
    }
}
