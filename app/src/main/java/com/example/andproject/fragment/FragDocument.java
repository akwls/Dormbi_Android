package com.example.andproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import com.example.andproject.R;

public class FragDocument extends Fragment {
    CheckBox chkOut;
    LinearLayout linearCalendar, linearTel;
    CalendarView calendarView;
    androidx.appcompat.widget.Toolbar tb;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.frag_document, container, false);

        chkOut = view.findViewById(R.id.chkOut);
        linearCalendar = view.findViewById(R.id.linearCalendar);
        linearTel = view.findViewById(R.id.linearTel);
        tb = view.findViewById(R.id.toolbar) ;
        ((AppCompatActivity)getActivity()).setSupportActionBar(tb);

        TextView action_bar_title = view.findViewById(R.id.action_bar_title);
        TextView action_bar_subtitle = view.findViewById(R.id.action_bar_subtitle);

        action_bar_title.setText("외박일지");
        action_bar_subtitle.setText("지방 학생들만 작성 가능합니다.");



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
