package com.example.activitytest;


import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/*2.6.2 随时随地退出程序：
* 创建一个集合类对所有活动进行管理，新建ActivityCollector类作为活动管理器*/

public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>(); //通过一个List来暂存活动

    public static void addActivity(Activity activity){           //通过addActivity方法添加活动
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){        //通过removeActivity从list去除活动
        activities.remove(activity);
    }

    public static void finishAll(){                              // 提供一个finishiAll方法将List存储的活动全部销毁
        for (Activity activity: activities){                     //从此以后不管想在哪个活动中退出程序只需要调用这个方法就可以了。
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
        activities.clear();
        android.os.Process.killProcess(android.os.Process.myPid()); //杀掉当前进程的代码：killPrecess()方法用于杀掉一个进程，它接收一个id参数
    }                                                               //通过myPid()方法获得当前程序进程的id.它只能杀掉当前陈旭的进程，无法杀掉其他程序。

}
