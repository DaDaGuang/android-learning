package com.example.uicustomviews;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/*3.4.2 : 引入布局能够解决重复编写代码的问题，但如果布局中有一些控件要求能够响应事件，我们还是需要在每个活动中为这些控件单独编写一次
* 事件注册的代码。例如标题栏的返回按钮，这个按钮功能都是相同的，即销毁当前活动，这样无疑会增加很多重复代码，这种情况需要用自定义控件的方法解决*/

public class TitleLayout extends LinearLayout {                       //新建TitleLayout继承自LinLayout，让他成为自定义标题栏控件

    public TitleLayout(Context context, AttributeSet attrs){          //首先重写了LinearLayout中带有两个参数的构造函数，在布局中引入TitleLayout控件就会调用这个构造函数
        super(context, attrs);                                        //然后要在构造函数中对标题栏布局进行动态加载，要借助LAyoutInflatter来实现，通过from()方法构建出一个LayoutInflater对象
        LayoutInflater.from(context).inflate(R.layout.title, this);   //然后调用Inflate（）方法就可以动态加载一个布局文件，inflate()方法接收两个参数，第一个是要加载的布局文件的id，第二个是给加载好的布局添加一个父布局

        Button titleBack = (Button)findViewById(R.id.title_back);
        Button titleEdit = (Button)findViewById(R.id.title_edit);

        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)getContext()).finish();
            }
        });

        titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"You Click Edit Button",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
