package com.booboomx.todaynews.utils;

import android.content.Context;
import android.content.Intent;

import com.booboomx.todaynews.ui.MainActivity;

/**
 * Created by booboomx on 17/4/2.
 */

public class JumpUtils {

    public static void  go2MainActivity(Context context){
        Intent intent=new Intent();
        intent.setClass(context, MainActivity.class);
        context.startActivity(intent);
    }


}
