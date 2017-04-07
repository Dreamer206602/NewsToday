package com.booboomx.todaynews.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by booboomx on 17/4/7.
 */

public class FixMultiViewPager extends ViewPager {
    public static final String TAG=FixMultiViewPager.class.getSimpleName();
    public FixMultiViewPager(Context context) {
        super(context);
    }

    public FixMultiViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {

        try {
            return super.onInterceptTouchEvent(event);
        } catch (IllegalArgumentException ex) {
            Log.w(TAG, "onInterceptTouchEvent() ", ex);
            ex.printStackTrace();
        }
        return false;


    }
}
