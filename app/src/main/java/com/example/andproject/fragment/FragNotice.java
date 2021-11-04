package com.example.andproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.andproject.Notice;
import com.example.andproject.NoticeAdapter;
import com.example.andproject.R;

import java.util.ArrayList;

public class FragNotice extends Fragment {
    ListView mList;
    NoticeAdapter mAdapter;
    ArrayList<Notice> mArray;
    Notice mItem;

    String[] title = {"백신 접종 관련 기숙사 공지", "화장실 물 잘 내리세요.", "중간고사 기숙사 입실 시간", "학년별 석식 시간"};
    String[] date = {"2021.10.20", "2021.10.19", "2021.10.17", "2021.09.15"};
    String[] teacher = {"사감선생님", "사감선생님", "이하얀 선생님", "사감선생님"};
    


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.frag_notice, container, false);
        mList = view.findViewById(R.id.list);
        mArray = new ArrayList<>();

        for(int i=0; i<title.length; i++) {
            mItem = new Notice(title[i], date[i], teacher[i]);
            mArray.add(mItem);
        }
        mAdapter = new NoticeAdapter(getContext(), mArray);
        mList.setAdapter(mAdapter);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Notice item = (Notice)mList.getItemAtPosition(i);
                String title = item.getTitle();
                Toast.makeText(getContext(), title, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
