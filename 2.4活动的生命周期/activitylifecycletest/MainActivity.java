package com.example.activitylifecycletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/*android用任务task管理活动，一个任务就是一组存放在栈里的活动的集合，这个栈也被称作返回栈back stack
* 活动状态：每个活动在其生命周期中共有4种状态：运行状态（在栈顶时），暂停状态（不在栈顶但仍然可见，pause），停止状态（不处于栈顶且完全不可见），销毁状态（从返回栈中移除）*/

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";   //logt+tab键 快速生成一个TAG常量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){                                //2.3.5--2. 数据已经被保存下来需要恢复。onCreate()方法中也有一个Bundle类型参数，这个参数一般情况下是Null,
            String tempData = savedInstanceState.getString("data_key"); //但如果活动被系统回收之前有通过onSaveInstanceState()方法来保存数据的话，这个参数就会带有之前保存的全部数据
            Log.d(TAG, tempData);                                       //我只需要再通过相应取值方法把数据取出来即可。取出值后再做相应恢复操作就可以了，比如把文本内容重新赋值到文本输入框
        }                                                               //这里只是简单打印一下。 Bundle保存和取出数据和Intent有些类似，Intent还可以结核Bundle一起用于传递数据：首先把
                                                                        //需要传递的数据保存在Bundle对象中，再将Bundle对象放进intent里，到了目标活动之后先从Intent取出Bundle，再从
                                                                        //再从Bundle中一一取出数据

        Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);     //注册点击事件
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);

        startNormalActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });

        startDialogActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
        
    }
    //七个回调方法中分别打印一句话，通过观察日志直观理解活动的生命周期
    //除了onRestart()，其他两两相对，所以生存期可分为3种
    //完整生存期（onCreate()-->onDestroy()），可见生存期（onStart()-->onStop()）还有前台生存期（onResume()-->onPause()）;
    @Override
    protected void onStart() {              //活动由不可见变为可见时调用
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {             //这个方法在活动准备好与用户进行交互时调用，此时活动一定位于栈顶，处于运行状态
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {              //在系统准备启动或恢复另一个活动时调用，通常在这个方法将一些消耗cpu的资源释放，不然影响新栈顶活动的使用
        super.onPause();
        Log.d(TAG, "onPause");
    }
    
    @Override
    protected void onStop() {               //这个方法在活动完全不可见时调用
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {            //在活动被销毁前调用
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        
    }
    
    @Override
    protected void onRestart() {            //在活动由停滞状态变为运行状态时调用
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override                                                   //2.4.5 --1.活动呗回收了怎么办：onSaveInstanceState()方法可以保证在活动被回收前一定会被调用，
    protected void onSaveInstanceState(Bundle outState) {       //所以，可以通过这个方法来解决活动被回收时活动中临时数据得不到保存的问题。这个方法携带一个Bundle
        super.onSaveInstanceState(outState);                    //类型的参数，Bundle提供一系列的方法用于保存数据，比如可以用putString()方法保存字符串，putInt()保存整型..以此类推
        String tempData = "Something you just typed";           //每个保存方法需要传入两个参数，第一个参数是键，用于后面从Bundle中取值，第二格式保存的内容
        outState.putString("data_key",tempData);
    }
}
