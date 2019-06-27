package com.example.projectdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {
private WebView wb_news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        wb_news = findViewById(R.id.wb_news);
        String news = "http://mini.eastday.com/mobile/190627113649821.html";
        wb_news.loadUrl(news);

    }
}
