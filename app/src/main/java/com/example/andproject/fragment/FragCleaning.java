package com.example.andproject.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.andproject.R;

public class FragCleaning extends Fragment {
    TextView txt4, txt5;
    TextView[] week = new TextView[5];
    Integer[] dayID = {R.id.txtw1, R.id.txtw2, R.id.txtw3, R.id.txtw4, R.id.txtw5 };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.frag_cleaning, container, false);
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
                }
            }
        });

        for(int i=0; i<week.length; i++) {
            week[i] = view.findViewById(dayID[i]);
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
            }
        });

        return view;
    }
}
