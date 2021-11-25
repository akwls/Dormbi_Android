package com.example.andproject.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import com.example.andproject.Goout;
import com.example.andproject.GooutResponse;
import com.example.andproject.R;
import com.example.andproject.network.RetrofitClient;
import com.example.andproject.network.ServiceApi;
import com.example.andproject.user.UserInfo;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.prolificinteractive.materialcalendarview.MaterialCalendarView.SELECTION_MODE_RANGE;

public class FragDocument extends Fragment {
    CheckBox chkOut;
    LinearLayout linearCalendar, linearTel;
    MaterialCalendarView calendarView;
    androidx.appcompat.widget.Toolbar tb;
    Button btnSubmit;
    EditText edtTel;
    ServiceApi service;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.frag_document, container, false);

        service = RetrofitClient.getClient().create(ServiceApi.class);
        chkOut = view.findViewById(R.id.chkOut);
        linearCalendar = view.findViewById(R.id.linearCalendar);
        linearTel = view.findViewById(R.id.linearTel);
        tb = view.findViewById(R.id.toolbar) ;
        ((AppCompatActivity)getActivity()).setSupportActionBar(tb);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        calendarView = view.findViewById(R.id.calendarView);
        calendarView.setSelectionMode(SELECTION_MODE_RANGE);
        edtTel = view.findViewById(R.id.edtTel);

        TextView action_bar_title = view.findViewById(R.id.action_bar_title);

        action_bar_title.setText("외박일지");
        chkOut.setEnabled(false);

        String userLoc = UserInfo.getLocation();
        if(!userLoc.equals("서울") && !userLoc.equals("경기") && !userLoc.equals("인천")) {
            chkOut.setEnabled(true);
        }

        chkOut.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    linearCalendar.setVisibility(View.VISIBLE);
                    linearTel.setVisibility(View.VISIBLE);
                   btnSubmit.setVisibility(View.VISIBLE);

                }
                else {
                    linearCalendar.setVisibility(View.GONE);
                    linearTel.setVisibility(View.GONE);
                    btnSubmit.setVisibility(View.GONE);
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<CalendarDay> dates = calendarView.getSelectedDates();
                if(dates.size() == 0) {
                    Toast.makeText(getContext(), "날짜를 선택해주세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(edtTel.getText().toString().isEmpty()) {
                        Toast.makeText(getContext(), "부모님 전화번호를 적어주세요.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        String startDay = dates.get(0).toString();
                        startDay = startDay.substring(12, startDay.length()-1);
                        String endDay = dates.get(dates.size()-1).toString();
                        endDay = endDay.substring(12, endDay.length()-1);
                        String pTel = edtTel.getText().toString();
                        Goout goout = new Goout(UserInfo.getNum(), UserInfo.getName(), UserInfo.getRoom(), startDay, endDay, pTel);
                        writeGoout(goout);
                    }
                }
            }
        });

        return view;
    }

    void writeGoout(Goout goout) {
        service.GooutList(goout).enqueue(new Callback<GooutResponse>() {
            @Override
            public void onResponse(Call<GooutResponse> call, Response<GooutResponse> response) {
                Log.d("writeGoout", "startjoin 성공");
                GooutResponse result = response.body();
                Toast.makeText(getContext(), result.getMessage(), Toast.LENGTH_SHORT).show();
                chkOut.setChecked(false);
                linearCalendar.setVisibility(View.GONE);
                linearTel.setVisibility(View.GONE);
                btnSubmit.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<GooutResponse> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
