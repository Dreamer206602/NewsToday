package com.booboomx.todaynews.widget.transformer;


import android.util.Log;
import android.view.View;

import github.hellocsl.layoutmanager.gallery.GalleryLayoutManager;

/**
 * Created by booboomx on 17/4/12.
 */

public class ScaleTransformer implements GalleryLayoutManager.ItemTransformer{
    public static final String TAG=ScaleTransformer.class.getSimpleName();
    @Override
    public void transformItem(GalleryLayoutManager layoutManager, View item, float fraction) {
        Log.i(TAG, "transformItem: ->"+fraction);
        item.setPivotX(item.getWidth() / 2.f);
        item.setPivotY(item.getHeight()/2.0f);
        float scale = 1 - 0.3f * Math.abs(fraction);
        item.setScaleX(scale);
        item.setScaleY(scale);
//        item.setAlpha(0.6f);
    }
}
