package com.example.pro1121.news;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.pro1121.R;


public class TinTucActivity extends AppCompatActivity {
    TextView nextNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin_tuc);

        nextNews = findViewById(R.id.nextNews);

        nextNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TinTucActivity.this, TinTuc2Activity.class);
                startActivity(i);
            }
        });
    }
}