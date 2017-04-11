package com.booboomx.todaynews.utils;

import android.content.Context;
import android.content.Intent;

import com.booboomx.todaynews.ui.activity.CustomSnapHelperActivity;
import com.booboomx.todaynews.ui.activity.LinearSnapHelperActivity;
import com.booboomx.todaynews.ui.activity.MainActivity;
import com.booboomx.todaynews.ui.activity.NewsDetailActivity;
import com.booboomx.todaynews.ui.activity.PagerSnapHelperActivity;

/**
 * Created by booboomx on 17/4/2.
 */

public class JumpUtils {

    public static void go2MainActivity(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, MainActivity.class);
        context.startActivity(intent);

    }


    public static void go2NewsDetailActivity(Context context, String title, String url) {

        Intent intent = new Intent();
        intent.setClass(context, NewsDetailActivity.class);
        intent.putExtra(ConstanceValue.TITLE, title);
        intent.putExtra(ConstanceValue.URL, url);
        context.startActivity(intent);

    }


    public static void go2LinearSnapHelperActivity(Context context, String type) {
        Intent intent = new Intent();
        intent.setClass(context, LinearSnapHelperActivity.class);
        intent.putExtra(ConstanceValue.TYPE, type);
        context.startActivity(intent);
    }

    public static void go2PagerSnapHelperActivity(Context context, String type) {
        Intent intent = new Intent();
        intent.setClass(context, PagerSnapHelperActivity.class);
        intent.putExtra(ConstanceValue.TYPE, type);
        context.startActivity(intent);
    }

    public static void go2CustomSnapHelperActivity(Context context, String type) {
        Intent intent = new Intent();
        intent.setClass(context, CustomSnapHelperActivity.class);
        intent.putExtra(ConstanceValue.TYPE, type);
        context.startActivity(intent);
    }


}
