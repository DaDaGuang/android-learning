package com.example.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /*private String[] data = {"Apple","Banana","Orange","Watermelon","Pear",
            "Grape","Pineapple","Strawberry","Cherry","Mango","Apple","Banana",
            "Orange","Watermelon","Pear", "Grape","Pineapple","Strawberry","Cherry","Mango"};*/

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(            //3.5.1 数组中的数据是无法直接传递给Listview的，需要借助适配器完成
            MainActivity.this, android.R.layout.simple_list_item_1, data);  //ArrarDapter有多个构造函数的重载，这里以此输入当前上下文，ListView子项布局的id，以及要适配的数据，
        ListView listView = (ListView)findViewById(R.id.list_view);         //这里用android.R.layout.simple_list_item_1作为子项布局的id，这是Android内置的布局文件，里面只有一个TextView，可用于简单地显示一段文本，这样适配器对象就构建好了。
        listView.setAdapter(adapter);                                       // 最后调用serAdapter()方法，将构建好的适配器对象传递进去，这样ListView和数据之间的关联就建立完成了
        */

        initFruits();

        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {                     //3.5.4  使用setOnItemClickListener()方法为ListView注册监听器，当点击ListView中任何一个子项时，
            @Override                                                                               //，就会回调onItemClick方法。在这个方法中通过positon参数判断出点击的是哪一个子项，然后得到相应水果
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {      //最后通过Toast将水果的名字显示出来
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this, fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initFruits(){
        for(int i = 0; i < 2; i++){
            Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
            fruitList.add(mango);
        }
    }
}
