package com.booboomx.todaynews.interf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.booboomx.todaynews.ui.activity.ImageDownLoadActivity;
import com.booboomx.todaynews.utils.ConstanceValue;

/**
 * Created by booboomx on 17/4/6.
 */

//  js通信的接口
public class JavascriptWebViewInterface {

    public static final String TAG=JavascriptWebViewInterface.class.getSimpleName();

    private Context mContext;

    public JavascriptWebViewInterface(Context context){
        this.mContext=context;
    }


    @android.webkit.JavascriptInterface
    public void openImage(String img,int width,int height){
        Log.i(TAG, "openImage: img->"+img);
        Log.i(TAG, "openImage: width->"+height);
        Log.i(TAG, "openImage: height->"+height);

        Intent intent=new Intent();
        intent.putExtra(ConstanceValue.LEFT,0);
        intent.putExtra(ConstanceValue.TOP,0);
        intent.putExtra(ConstanceValue.IMAGE,img);
        intent.putExtra(ConstanceValue.WIDTH,width);
        intent.putExtra(ConstanceValue.HEIGHT,height);

        intent.setClass(mContext, ImageDownLoadActivity.class);
        mContext.startActivity(intent);
        ((Activity)mContext).overridePendingTransition(0,0);

    }



}

