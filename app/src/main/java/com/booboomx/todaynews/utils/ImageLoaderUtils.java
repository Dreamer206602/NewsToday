package com.booboomx.todaynews.utils;

/**
 * Created by booboomx on 17/4/3.
 */

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * 使用Glide加载加载图片的工具类
 */
public class ImageLoaderUtils {


    public static void loadImge(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

    }

    public static void loadImge(Activity activity, String url, ImageView imageView) {

        Glide.with(activity)
                .load(url)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

    }

    public static void loadeCircleImage(Context context, String url, ImageView imageView) {

        //原图基础上复合变换成圆图 +毛玻璃（高斯模糊）

//        Glide.with(context).load(url).bitmapTransform(new BlurTransformation(context, 25), new CropCircleTransformation(context)).crossFade(1000).into(imageView);


        //原图 -> 圆图
        Glide.with(context).load(url).bitmapTransform(new CropCircleTransformation(context)).crossFade(1000).into(imageView);



        //原图的毛玻璃、高斯模糊效果
       // Glide.with(context).load(url).bitmapTransform(new BlurTransformation(context, 25)).crossFade(1000).into(imageView);



        //原图处理成圆角，如果是四周都是圆角则是RoundedCornersTransformation.CornerType.ALL
        //Glide.with(context).load(url).bitmapTransform(new RoundedCornersTransformation(context, 30, 0, RoundedCornersTransformation.CornerType.BOTTOM)).crossFade(1000).into(imageView);


    }


}
