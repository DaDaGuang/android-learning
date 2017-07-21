package com.example.activitytest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    private static final String TAG = "SecondActivity";
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Task id is"+getTaskId());
        setContentView(R.layout.second_layout);
        /*2.3.4 向下一个活动传递数据（接收FirstAvtivity中的数据）
        Intent intent = getIntent();                       //通过getIntent()方法获取到用于启动SecondActivity的intent，
        String data = intent.getStringExtra("extra_data"); //然后调用getStringExtra()方法，传入相应键，就可以得到传递的数据（若传递整形数据getIntExtra,布尔型就getBooleanExtra，以此类推）
        Log.d("SecondActivity", data);
        */

        /*2.3.5 返回数据给上一个活动
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){  //注册点击事件

            public void onClick(View v){
                Intent intent = new Intent();                   //构建intent，仅仅用于传递数据，没有指定“意图”，
                intent.putExtra("data_return","你好第一个活动");   //把数据放进intent中
                setResult(RESULT_OK,intent);                    //调用setResult方法，专门用于向上一个活动返回数据，这个方法接收两个参数，第一个用于向上一个活动返回处理结果，一般只用RESULT_OK或
                finish();                                       //RESULT_CANCELED 这两个值，第二个参数则把带有数据的intent传递回去，然后调用finishi()方法，销毁当前活动
            }                                                   //销毁之后会回调上一个活动的onActivityResult()方法，因此要在FirstActivity方法中重写这个方法来得到返回的数据
        });
    }

    @Override                                            //如果用户在SecondActivity中不是通过点击按钮，而是通过Back键回到FirstActivity
    public void onBackPressed() {                        //可以在SecondActivity中重写onBackPressed()方法来解决这个问题
        Intent intent = new Intent();
        intent.putExtra("data_return","你好第一个活动");
        setResult(RESULT_OK,intent);
        finish();
        */

        /*2.5*/
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

    }

    /*2.6.3启动活动的最佳方法
        * 假设SecondActivity中需要用到两个非常重要的字符串参数，启动的时候必须传递过来*/
    public static void actionStart(Context context, String data1, String data2){  //添加一个actionStart方法，在这个方法中完成了Intent的创建，并且所有
        Intent intent = new Intent(context, SecondActivity.class);                //SecondActivity中需要的数据都通过actionStart方法测参数传递过来
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);
    }


}

