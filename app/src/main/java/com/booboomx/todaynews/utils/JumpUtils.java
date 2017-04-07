package com.booboomx.todaynews.utils;

import android.content.Context;
import android.content.Intent;

import com.booboomx.todaynews.ui.activity.MainActivity;
import com.booboomx.todaynews.ui.activity.NewsDetailActivity;

/**
 * Created by booboomx on 17/4/2.
 */

public class JumpUtils {

    public static void  go2MainActivity(Context context){
        Intent intent=new Intent();
        intent.setClass(context, MainActivity.class);
        context.startActivity(intent);

    }



    public static void go2NewsDetailActivity(Context context,String title,String url){

        Intent intent=new Intent();
        intent.setClass(context, NewsDetailActivity.class);
        intent.putExtra(ConstanceValue.TITLE,title);
        intent.putExtra(ConstanceValue.URL,url);
        context.startActivity(intent);

    }


}
