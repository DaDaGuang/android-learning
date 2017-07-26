package com.example.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit>{                                  //3.5.2 创建一个自定义的适配器，继承自ArrayAdapter，并将泛型指定为Fruit类

    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects){  //首先重写了父类的一组构造函数，用于将上下文、ListView子项布局的ID和数据传递进来
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {             //再重写了getView方法，这个方法在每个子项被滚动到屏幕内部的时候会被调用。在getView方法中，首先通过

        Fruit fruit = getItem(position); //获取当前项的Fruit实例                           //getItem()方法得到当前项的Fruit实例，然后使用LayoutInflater来为这个子项加载我们传入的布局

        /*View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);//这里LayoutInflater的inflate（）方法接收三个参数，第三个指定False是表示只让我们在父布局中声明的layout属性生效，但不会为这个View添加父布局（因为一旦View有了父布局，就不能添加到ListView中了）
        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);         //接下来调用View的findViewById方法分别获取到IMageView和TextView的实例
        TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
        fruitImage.setImageResource(fruit.getImageId());                                //并分别调用他们的setImageResource()和setText方法来设置显示的图片和文字
        fruitName.setText(fruit.getName());
        return view;                                                                    // 最后将布局返回，这样自定义适配器就完成了
        */

        class ViewHolder{                                                               // 3.5.3 提升ListView的运行效率。 上面代码ListView的运行效率是很低的，因为在FruitAdapter的getView方法中，每次都将布局重新加载一遍
            ImageView fruitImage;                                                       // 而且就算优化了这一步（利用convetView），不会再重复加载布局，但每次在getView()方法中还是会调用View的findviewbyid方法来获取一次控件的实例
            TextView fruitName;                                                         //这里，可以借助一个ViewHolder来对这部分进行优化。
        }                                                                               //新增内部类ViewHolder，用于对控件的实例进行缓存。当convetView为null的时候，创建一个ViewHolder对象，并将控件的实例都存放在ViewHolder里，然后
                                                                                        //调用View的setTag方法，将ViewHolder对象存储在View中。
        View view;                                                                      //当convetView不为null的时候，调用View的getTag方法,把ViewHolder重新取出。这样所有控件的实例都缓存在了ViewHolder里，就没有必要每次都通过FIndviewbyid方法
        ViewHolder viewHolder;                                                          // 获取控件实例了。这两部优化之后，运行效率upup!

        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView)view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);//将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();//重新获取ViewHolder
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;

    }
}
