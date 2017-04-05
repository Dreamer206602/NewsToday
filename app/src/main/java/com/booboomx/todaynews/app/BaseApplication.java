package com.booboomx.todaynews.app;

import android.app.Application;

import com.booboomx.todaynews.utils.SharedPreferencesMgr;

/**
 * Created by booboomx on 17/4/2.
 */

public class BaseApplication extends Application {


    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance=this;
        SharedPreferencesMgr.init(this, "weyye");

    }


    public static BaseApplication getInstance(){
        return instance;
    }
}
