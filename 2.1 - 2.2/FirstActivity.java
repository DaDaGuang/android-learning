package com.example.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);                  //给当前活动加载一个布局
        Button button1  = (Button) findViewById(R.id.button_1); //findViewByID方法获取在布局文件中定义的元素
                                                                //但返回的是一个View对象，需要向下转型成Button对象
        button1.setOnClickListener(new View.OnClickListener(){  //得到按钮的实例后，通过setOnClickListener方法为按钮注册一个监听器
            @Override
            public  void onClick(View v){                       //点击按钮时就会执行监听器中的onClick方法，即Toast的功能需要在onClick中编写
                Toast.makeText(FirstActivity.this,"You clicked Button 1",
                        Toast.LENGTH_SHORT).show();             //Toast 用法： 通过静态方法makeText()创建出一个toast对象，然后调用show()方法显示出来
                                                                //makeText()方法需要传入三个参数，第一个参数是Context.toast要求的上下文，
                                                                //由于活动本身是一个Context对象，所以传入FirstActivity.this即可
                                                                //第二个参数是显示的文本内容，第三个是显示的时长，short可以改成long 是两个内置常量
            }
        });
    }
}
