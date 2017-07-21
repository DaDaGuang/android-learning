package com.example.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by msi on 2017/7/20.
 */

/*2.6.1 知晓当前实在哪一个活动
* 通过构建所有Activity的父类（让其他活动继承这个类而不是AppCompatActivity），然后重写OnCreate方法，在方法中获取当前实例的类名，并通过log打印*/
public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, getClass().getSimpleName());
        ActivityCollector.addActivity(this);  //2.6.2
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this); //2.6.2
    }
}
