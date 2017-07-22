package com.example.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{ //实现接口的方式注册监听器

    private EditText editText;  //3.2.3 EditText 通过button获取输入的信息，生成一个EditText类文件

    private ImageView imageView; //3.2.4通过代码动态地更改Image View中的图片

    private ProgressBar progressBar; //3.2.5 尝试点击按钮让进度条消失，再点击一下又出现的效果

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        /*button.setOnClickListener(new View.OnClickListener() {  //匿名类的方式注册监听器
            @Override
            public void onClick(View v) {
                //在此添加逻辑
            }
        }); */

        editText = (EditText)findViewById(R.id.edit_text);  //3.2.3

        imageView = (ImageView)findViewById(R.id.image_view); //3.2.4

        progressBar = (ProgressBar)findViewById(R.id.progress_bar); //3.2.5

        button.setOnClickListener(this); //实现接口的方式注册监听器
    }

    @Override
    public void onClick(View v){         //实现接口的方式注册监听器
        switch (v.getId()){
            case R.id.button:
                /*
                String inputText = editText.getText().toString();          //3.2.3 EditText 通过button获取输入的信息
                Toast.makeText(MainActivity.this,"you typed " +inputText,Toast.LENGTH_SHORT).show();  //使用Toast将输入的内容显示出来
                */

                /*
                imageView.setImageResource(R.drawable.img_2);  //3.2.4通过setImageResource()方法更改图片
                */

                /*
                if (progressBar.getVisibility() == View.GONE){  //3.2.5(1) 在点击事件中，通过getVisibi方法判断是否可见
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
                */

                /*
                int progress = progressBar.getProgress(); //3.2.5(2) 每点击一次按钮，我们就获取进度条的当前进度，然后加上10作为更新后的进度
                progress = progress + 10;
                progressBar.setProgress(progress);
                */

                /*3.2.6 AlertDialog*/
                /*
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);        //首先通过AlertDialog.Builder 创建一个AlertDialog的实例
                dialog.setTitle("This is Dialog");                                              //为这个对话框设置标题
                dialog.setMessage("Something important.");                                      //设置内容
                dialog.setCancelable(false);                                                    //能否通过Back键取消
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {          //setPositiveButton()设置确定按钮的点击事件
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {      //setNegativeButton()设置取消按钮的点击事件
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                    }
                });
                dialog.show();                                                                  //最后调用show()方法显示出来
                break;
                */

                /*3.2.7 ProgressDialog*/
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);          //生成progressdialog对象
                progressDialog.setTitle("This is progressDialog");                              //设置标题
                progressDialog.setMessage("Loading...");                                        //内容
                progressDialog.setCancelable(true);                                             //能否通过Back键取消，（设置false的话，一定要要在代码中做好控制，当数据加载完成后必须调用
                progressDialog.show();                                                          //progressDialog的dismiss()方法来关闭对话框，否则将会一直存在。）最后调用show()方法显示出来

                break;


            default:
                break;
        }
    }
}
