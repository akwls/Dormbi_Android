package com.example.andproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.andproject.network.RetrofitClient;
import com.example.andproject.network.ServiceApi;
import com.example.andproject.user.JoinData;
import com.example.andproject.user.JoinResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JoinActivity extends AppCompatActivity {
    ServiceApi service;
    private ProgressBar mProgressView;
    Button btnJoin;
    EditText join_id, join_pw, join_pw_check, join_name, join_student_num, join_tel, join_parent_tel;
    Spinner join_location_spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        join_id = findViewById(R.id.join_id);
        join_pw = findViewById(R.id.join_password);
        join_pw_check = findViewById(R.id.join_password_check);
        join_name = findViewById(R.id.join_name);
        join_student_num = findViewById(R.id.join_student_num);
        join_tel = findViewById(R.id.join_tel);
        join_parent_tel = findViewById(R.id.join_parent_tel);
        join_location_spinner = findViewById(R.id.join_country);
        service = RetrofitClient.getClient().create(ServiceApi.class);
        btnJoin = findViewById(R.id.btnJoin);
        mProgressView = findViewById(R.id.join_progress);
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptJoin();
            }
        });


    }
    public void attemptJoin() {
        join_id.setError(null);
        join_pw.setError(null);
        join_pw_check.setError(null);
        join_name.setError(null);
        join_student_num.setError(null);

        String ID = join_id.getText().toString();
        String pw = join_pw.getText().toString();
        String pw_check = join_pw_check.getText().toString();
        String name = join_name.getText().toString();
        String student_num = join_student_num.getText().toString();
        String tel = join_tel.getText().toString();
        String parent_tel = join_parent_tel.getText().toString();
        String location = (String)join_location_spinner.getSelectedItem();

        boolean cancel = false;
        View focusView = null;

        if (ID.isEmpty()) {
            join_id.setError("아이디를 입력해주세요.");
            focusView = join_id;
            cancel = true;
        } else if (!isPasswordValid(pw)) {
            join_pw.setError("6자 이상의 비밀번호를 입력해주세요.");
            focusView = join_pw;
            cancel = true;
        } else if (!pw_check.equals(pw)) {
            join_pw_check.setError("비밀번호가 일치하지 않습니다.");
            focusView = join_pw_check;
            cancel = true;
        } else if (name.isEmpty()) {
            join_name.setError("이름을 입력해주세요.");
            focusView = join_name;
            cancel = true;
        } else if (student_num.length() != 4) {
            join_student_num.setError("학번을 다시 입력해주세요.");
            focusView = join_student_num;
            cancel = true;
        } else if (tel.isEmpty()) {
            join_tel.setError("전화번호를 입력해주세요.");
            focusView = join_tel;
            cancel = true;
        } else if (parent_tel.isEmpty()) {
            join_parent_tel.setError("부모님 전화번호를 입력해주세요.");
            focusView = join_parent_tel;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            startJoin(new JoinData(ID, pw, name, Integer.parseInt(student_num), tel, parent_tel, location));
            showProgress(true);
        }


    }
    private void startJoin(JoinData data) {
        Log.d("join", "startjoin 시작");
        service.userJoin(data).enqueue(new Callback<JoinResponse>() {
            @Override
            public void onResponse(Call<JoinResponse> call, Response<JoinResponse> response) {
                Log.d("join", "startjoin 성공");
                JoinResponse result = response.body();
                Toast.makeText(JoinActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();
                showProgress(false);

                if (result.getCode() == 200) {
                    finish();
                }
            }

            @Override
            public void onFailure(Call<JoinResponse> call, Throwable t) {
                Toast.makeText(JoinActivity.this, "회원가입 에러 발생", Toast.LENGTH_SHORT).show();
                Log.e("회원가입 에러 발생", t.getMessage());
                showProgress(false);
            }
        });
    }
    private boolean isPasswordValid(String password) {
        return password.length() >= 6;
    }
    private void showProgress(boolean show) {
        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}