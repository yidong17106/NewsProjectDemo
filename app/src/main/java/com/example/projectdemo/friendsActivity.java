package com.example.projectdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class friendsActivity extends AppCompatActivity {

    private TextView tv_home_friends;
    private android.support.v4.app.FragmentManager fragmentManager;
    private android.support.v4.app.FragmentTransaction fragmentTransaction;
    private android.support.v4.app.Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        tv_home_friends=(TextView)findViewById(R.id.tv_home_friends);
        fragment=new InforFragment();
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fg_body,fragment);
        fragmentTransaction.commit();

        tv_home_friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragment=new InforFragment();
                fragmentManager=getSupportFragmentManager();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fg_body,fragment);
                fragmentTransaction.commit();
            }
        });
        findViewById(R.id.iv_cxun).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment=new friendsFragment();
                fragmentManager=getSupportFragmentManager();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fg_body,fragment);
                fragmentTransaction.commit();
            }
        });
    }
    }

