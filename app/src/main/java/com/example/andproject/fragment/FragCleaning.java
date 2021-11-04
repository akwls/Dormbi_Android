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

        return view;
    }
}
