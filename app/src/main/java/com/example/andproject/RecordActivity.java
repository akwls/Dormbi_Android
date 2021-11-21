package com.example.andproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andproject.network.RetrofitClient;
import com.example.andproject.network.ServiceApi;
import com.example.andproject.user.Score;
import com.example.andproject.user.ScoreResponse;
import com.example.andproject.user.UserInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecordActivity extends AppCompatActivity {
    TextView txtTitle;
    Button btnSubmit;
    EditText edtGood, edtBad;
    ServiceApi service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        txtTitle = findViewById(R.id.action_bar_title);
        txtTitle.setText("상벌점 기록하기");

        edtBad = findViewById(R.id.edtBad);
        edtGood = findViewById(R.id.edtGood);

        service = RetrofitClient.getClient().create(ServiceApi.class);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String good = edtGood.getText().toString();
            String bad = edtBad.getText().toString();

            if(!good.equals("") && !bad.equals("")) updateScore(new Score(good, bad, UserInfo.getNum(), UserInfo.getName()));
            }
        });




    }
    void updateScore(Score score) {
        service.userScore(score).enqueue(new Callback<ScoreResponse>() {
            @Override
            public void onResponse(Call<ScoreResponse> call, Response<ScoreResponse> response) {
                ScoreResponse result = response.body();
                Toast.makeText(RecordActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ScoreResponse> call, Throwable t) {
                Toast.makeText(RecordActivity.this, "에러 발생", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
