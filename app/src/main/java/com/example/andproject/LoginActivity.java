package com.example.andproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.andproject.network.RetrofitClient;
import com.example.andproject.network.ServiceApi;
import com.example.andproject.user.JoinData;
import com.example.andproject.user.JoinResponse;
import com.example.andproject.user.LoginData;
import com.example.andproject.user.LoginResponse;
import com.example.andproject.user.UserInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    public static Activity loginActivity;
    EditText login_id, login_pw;
    Button btnLogin, btnJoin;
    ServiceApi service;
    private ProgressBar mProgressView;
    UserInfo user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginActivity = LoginActivity.this;

        login_id = findViewById(R.id.login_id);
        login_pw = findViewById(R.id.login_password);
        service = RetrofitClient.getClient().create(ServiceApi.class);

        btnLogin = findViewById(R.id.btnLogin);
        btnJoin = findViewById(R.id.btnJoin);
        mProgressView = findViewById(R.id.join_progress);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(in);
            }
        });
    }
    public void attemptLogin() {
        login_id.setError(null);
        login_pw.setError(null);

        String ID = login_id.getText().toString();
        String pw = login_pw.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (ID.isEmpty()) {
            login_id.setError("아이디를 입력해주세요.");
            focusView = login_id;
            cancel = true;
        } else if(pw.isEmpty()) {
            login_pw.setError("비밀번호를 입력해주세요.");
            focusView = login_pw;
            cancel = true;
        }


        if (cancel) {
            focusView.requestFocus();
        } else {
            startLogin(new LoginData(ID, pw));
            showProgress(true);
        }
    }
    private void startLogin(LoginData data) {
        service.userLogin(data).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse result = response.body();
                Toast.makeText(LoginActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();
                showProgress(false);

                if (result.getCode() == 200) {
                    UserInfo.setNum(result.getNum());
                    UserInfo.setName(result.getName());
                    UserInfo.setRoom(result.getRoom());
                    UserInfo.setLocation(result.getLoc());
                    UserInfo.setWashday(result.getWashday());
                    UserInfo.setWashnum(result.getWashnum());
                    UserInfo.setWashtime(result.getWashtime());
                    UserInfo.setGood(result.getGood());
                    UserInfo.setBad(result.getBad());
                    Intent in = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(in);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "로그인 에러 발생", Toast.LENGTH_SHORT).show();
                Log.e("로그인 에러 발생", t.getMessage());
                showProgress(false);
            }
        });
    }
    private void showProgress(boolean show) {
        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}