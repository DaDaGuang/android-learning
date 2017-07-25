package com.example.uicustomviews;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar(); //3.4.1，将系统标题栏隐藏，首先通过getSupportActionBar()，获得Actionbar实例
        if (actionBar != null ){
            actionBar.hide();                        //然后通过ACtionbar的hide()方法隐藏
        }


    }
}
