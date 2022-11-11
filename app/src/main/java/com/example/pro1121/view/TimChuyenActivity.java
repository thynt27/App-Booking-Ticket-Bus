package com.example.pro1121.view;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pro1121.R;

public class TimChuyenActivity extends AppCompatActivity {
    EditText diemdi,diemden;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timchuyen);
        diemdi=findViewById(R.id.diemdi);
        diemden=findViewById(R.id.diemden);

    }
}
