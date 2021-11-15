package com.example.andproject.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.andproject.R;
import com.example.andproject.ReserveActivity;

public class FragWash extends Fragment {
    ImageView[] machine = new ImageView[3];
    Button machine_reserve;
    TextView txt4, txt5;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.frag_wash, container, false);
        machine[0] = view.findViewById(R.id.washing_machine_1);
        machine[1] = view.findViewById(R.id.washing_machine_2);
        machine[2] = view.findViewById(R.id.washing_machine_3);

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

        machine_reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getContext(), ReserveActivity.class);
                startActivity(in);
            }
        });

        return view;
    }
}
