package com.booboomx.todaynews.interf;

import android.content.Context;
import android.content.Intent;

import com.booboomx.todaynews.ui.activity.ImageDownLoadActivity;
import com.booboomx.todaynews.utils.ConstanceValue;

/**
 * Created by booboomx on 17/4/6.
 */

//  js通信的接口
public class JavascriptWebViewInterface {

    private Context mContext;

    public JavascriptWebViewInterface(Context context){
        this.mContext=context;
    }


    @android.webkit.JavascriptInterface
    public void openImage(String img){
        Intent intent=new Intent();
        intent.putExtra(ConstanceValue.IMAGE,img);
        intent.setClass(mContext, ImageDownLoadActivity.class);
        mContext.startActivity(intent);

    }



}

