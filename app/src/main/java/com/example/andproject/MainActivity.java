package com.example.andproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.andproject.fragment.FragCleaning;
import com.example.andproject.fragment.FragDocument;
import com.example.andproject.fragment.FragMypage;
import com.example.andproject.fragment.FragNotice;
import com.example.andproject.fragment.FragWash;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Fragment fragment_wash, fragment_cleaning, fragment_document, fragment_notice, fragment_mypage;
    BottomNavigationView bottomNavigationItemView;
    LoginActivity la = (LoginActivity)LoginActivity.loginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        la.finish();


        fragment_wash = new FragWash();
        fragment_cleaning = new FragCleaning();
        fragment_document = new FragDocument();
        fragment_notice = new FragNotice();
        fragment_mypage = new FragMypage();
        bottomNavigationItemView = findViewById(R.id.bottomNavigationView);

        FragmentTransaction frag_manager = getSupportFragmentManager().beginTransaction();
        frag_manager.replace(R.id.main_layout, fragment_wash).commitAllowingStateLoss();

        bottomNavigationItemView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.washing:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_wash).commitAllowingStateLoss();
                        return true;
                    case R.id.cleaning:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_cleaning).commitAllowingStateLoss();
                        return true;
                    case R.id.document:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_document).commitAllowingStateLoss();
                        return true;
                    case R.id.notice:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_notice).commitAllowingStateLoss();
                        return true;
                    case R.id.user:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_mypage).commitAllowingStateLoss();
                        return true;
                }
                return false;
            }
        });
    }

}
