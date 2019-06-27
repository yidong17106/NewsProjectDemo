package com.example.projectdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class JsActivity extends AppCompatActivity {
private WebView wb_js;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js);

        wb_js = findViewById(R.id.wb_js);
        String js = "http://mini.eastday.com/mobile/190627105502072.html";
        wb_js.loadUrl(js);
    }
}
