package com.example.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
                /*2.3.1 显式intent:
                * 生成intent对象并构造函数接收两个参数，第一个参数context要求提供一个启动活动的上下文，
                * 第二个参数class则指定想要启动的目标活动，通过这个构造函数就可以构建出intent的“意图”
                * 使用intent: 调用Activity类的startActivity方法，接收一个intent参数，便可启动*/
                /*Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);*/

                /*2.3.2 隐式intent
                Intent intent = new Intent("com.example.activitytest.ACTION_START"); //直接将action的字符串传进去，表明我想要启动能相应这个action的活动
                intent.addCategory("com.example.activitytest.MY_CATEGORY");          //再通过addCategory（）方法添加一个category条件
                startActivity(intent);*/

                /*2.3.3 打开网页
                Intent intent = new Intent(Intent.ACTION_VIEW);    //首先指定了Intent.ACTION_VIEW 这个aaction,这个是android系统内置的动作，常量值为android.intent.action.VIEW
                intent.setData(Uri.parse("http://www.baidu.com")); //然后通过Uri.parse()方法，将一个网址字符串解析成一个Uri对象，再调用Intent的setData()方法将这个Uri对象传进去
                startActivity(intent);*/

                /*调用系统拨号界面
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);*/

                /*2.3.4 向下一个活动传递数据
                String data = "你好第二个活动";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data",data); //在启动活动的同时，可以通过putExtra()方法，我们可以把想要传递的数据暂存在Intent中，启动另一个活动后再取出
                startActivity(intent);              // putExtra()方法接收一对键值对
                */

                /*2.3.5返回数据给上一个活动*/
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent,1);   //使用startActivityForResult()方法来启动SecondActivity，这个方法接收两个参数，intent和请求码，用于在之后的回调中判断数据来源，请求码是个唯一值就可以了

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  //onActivityResult方法中有三个参数，第一个是启动活动时的请求码，第二个是返回数据时的处理结果，第三个是带着返回数据的intent
        switch(requestCode){                                                         //在一个活动中有可能调用这个方法来启动很多不同的活动，所以通过requestcode即请求码来判断来源，确定数据是从SecondActivity中来的之后，
            case 1:                                                                  //再通过检查resultcode来判断处理结果是否成功，最后从data中取值并打印出来，完成向上一个活动返回数据的工作
                if(resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {     //创建菜单
        getMenuInflater().inflate(R.menu.main,menu);    //通过getMenuInflater()方法得到MenuInflater对象，再调用他的Inflater方法，给当前活动创建菜单
        return true;                                    //这个方法接受两个参数，一个是指定通过那个资源文件夹创建菜单，第二个参数用于指定我们的菜单项将添加到
                                                        //哪一个Menu对象当中，这里直接使用onCreateOptionsMenu()方法中传入的menu参数
                                                        //然后返回true，表示允许创建的菜单显示出来
    }

    @Override

    /*重写方法定义菜单响应事件，通过调用item.getItemId()方法，来判断点击的是哪个菜单项，
    * 然后给每个菜单项加入自己的逻辑处理，在这里添加的是Toast*/

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();

        }
        return true;
    }

}
