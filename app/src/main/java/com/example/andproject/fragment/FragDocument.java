package com.example.andproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import com.example.andproject.R;

public class FragDocument extends Fragment {
    CheckBox chkOut;
    LinearLayout linearCalendar, linearTel;
    CalendarView calendarView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.frag_document, container, false);

        chkOut = view.findViewById(R.id.chkOut);
        linearCalendar = view.findViewById(R.id.linearCalendar);
        linearTel = view.findViewById(R.id.linearTel);

        chkOut.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    linearCalendar.setVisibility(View.VISIBLE);
                    linearTel.setVisibility(View.VISIBLE);
                }
                else {
                    linearCalendar.setVisibility(View.INVISIBLE);
                    linearTel.setVisibility(View.INVISIBLE);
                }
            }
        });

        return view;
    }
}
