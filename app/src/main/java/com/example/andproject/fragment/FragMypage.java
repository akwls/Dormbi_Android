package com.example.andproject.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.andproject.R;
import com.example.andproject.RecordActivity;
import com.example.andproject.network.RetrofitClient;
import com.example.andproject.network.ServiceApi;
import com.example.andproject.user.JoinResponse;
import com.example.andproject.user.LoginResponse;
import com.example.andproject.user.UserInfo;

import java.nio.file.Path;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragMypage extends Fragment {
    TextView txtTitle;
    TextView txtRecord, txtOut, txtVersion;
    TextView txtName, txtRoom, txtLoc, txtWash, txtScore;
    View dlgView;
    EditText edtPw;
    ServiceApi service;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_mypage, container, false);
        txtTitle = view.findViewById(R.id.action_bar_title);
        txtTitle.setText("마이페이지");
        txtRecord = view.findViewById(R.id.txtRecord);
        txtOut = view.findViewById(R.id.txtOut);
        txtVersion = view.findViewById(R.id.txtVersion);
        service = RetrofitClient.getClient().create(ServiceApi.class);

        txtName = view.findViewById(R.id.txtName);
        txtRoom = view.findViewById(R.id.txtRoom);
        txtLoc = view.findViewById(R.id.txtLoc);
        txtWash = view.findViewById(R.id.txtWash);
        txtScore = view.findViewById(R.id.txtScore);

        txtName.setText(UserInfo.getNum() + " " +UserInfo.getName());
        txtRoom.setText(UserInfo.getRoom() + "호");
        txtLoc.setText("거주 지역 : " + UserInfo.getLocation());
        String washday = "";
        switch (UserInfo.getWashday()) {
            case 1: washday = "월"; break;
            case 2: washday = "화"; break;
            case 3: washday = "수"; break;
            case 4: washday = "목"; break;
            case 5: washday = "금"; break;
        }
        String washtime = "";
        switch (UserInfo.getWashtime()) {
            case 1 : washtime = "19:00~20:10"; break;
            case 2 : washtime = "20:10~21:20"; break;
            case 3 : washtime = "21:20~22:30"; break;
        }

        txtWash.setText("세탁기 시간 : " + washday + "요일" + " / " + washtime + " / " + UserInfo.getWashnum() + "번 세탁기");
        txtScore.setText("상점 : " + UserInfo.getGood() +" / 벌점 : " + UserInfo.getBad());

        txtRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getContext(), RecordActivity.class);
                startActivity(in);
            }
        });

        txtOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlgView = View.inflate(getContext(), R.layout.dialog_out, null);
                edtPw = dlgView.findViewById(R.id.edtPw);
                final String pw = edtPw.getText().toString();
                AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());
                dlg.setTitle("기숙사 퇴소 처리");
                dlg.setView(dlgView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), pw, Toast.LENGTH_SHORT).show();
                        service.DeleteStudent(UserInfo.getNum(), pw).enqueue(new Callback<JoinResponse>() {
                            @Override
                            public void onResponse(Call<JoinResponse> call, Response<JoinResponse> response) {
                                Log.d("탈퇴", "성공");
                                if(response.body().getCode() == 200)
                                    Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT ).show();
                            }

                            @Override
                            public void onFailure(Call<JoinResponse> call, Throwable t) {
                                Toast.makeText(getContext(), "퇴소 처리 오류", Toast.LENGTH_SHORT ).show();
                            }
                        });
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dlg.show();
            }
        });


        txtVersion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "앱 버전 : 1.0", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
