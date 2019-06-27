package com.example.projectdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class CarActivity extends AppCompatActivity {
private WebView wb_car;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);


        wb_car = findViewById(R.id.wb_car);
        Intent intent= getIntent();
        String tt = "http://mini.eastday.com/mobile/190627112556208.html";
        wb_car.loadUrl(tt);



    }
}
