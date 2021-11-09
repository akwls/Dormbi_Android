package com.example.andproject.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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

public class FragMypage extends Fragment {
    TextView txtTitle;
    TextView txtRecord, txtOut, txtVersion;
    View dlgView;
    EditText edtPw;
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
