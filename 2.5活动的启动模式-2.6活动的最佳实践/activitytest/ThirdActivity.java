package com.example.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {

    private static final String TAG = "ThirdActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Task id is "+getTaskId());
        setContentView(R.layout.third_layout);

        Button button3 = (Button)findViewById(R.id.button_3); //2.6.2 调用ActivityCollector.finishAll()方法让Button3键可以直接退出程序
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ActivityCollector.finishAll();
            }
        });
    }
}
