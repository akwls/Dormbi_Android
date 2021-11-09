package com.example.andproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RecordActivity extends AppCompatActivity {
    TextView txtTitle;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        txtTitle = findViewById(R.id.action_bar_title);
        txtTitle.setText("상벌점 기록하기");

        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기록되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
