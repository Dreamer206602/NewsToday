package com.booboomx.todaynews.app;

import android.app.Activity;
import android.app.Application;

import com.booboomx.todaynews.theme.util.SharedPreferencesMgr;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by booboomx on 17/4/2.
 */

public class BaseApplication extends Application {

    //运用list来保存我们每一个activity
    private List<Activity> mList = new LinkedList<>();


    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        SharedPreferencesMgr.init(this, "weyye");

    }


    //实例话一次
    public synchronized static BaseApplication getInstance() {

        if (instance == null) {
            instance = new BaseApplication();
        }
        return instance;
    }

    public void addActivity(Activity activity) {
        mList.add(activity);
    }


    //关闭每一个list内的activity
    public void exit() {
        try {

            for (Activity activity : mList) {
                if (activity != null) {
                    activity.finish();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }


    //杀进程
    public void onLowMemory(){
        super.onLowMemory();
        System.gc();
    }
}
