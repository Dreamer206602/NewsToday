package com.booboomx.todaynews.utils;

/**
 * Created by booboomx on 17/4/3.
 */

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * 使用Glide加载加载图片的工具类
 *
 */
public class ImageLoaderUtils {


    public static void loadImge(Context context, String url, ImageView imageView){
        Glide.with(context)
                .load(url)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

    }
    public static void loadImge(Activity activity, String url, ImageView imageView){

        Glide.with(activity)
                .load(url)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

    }



}
