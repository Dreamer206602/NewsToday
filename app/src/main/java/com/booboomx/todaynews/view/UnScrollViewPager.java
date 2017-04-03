package com.booboomx.todaynews.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by booboomx on 17/4/3.
 */

public class UnScrollViewPager extends ViewPager {
    private boolean isScrollable=false;
    private Context mContext;

    public UnScrollViewPager(Context context) {
        super(context);
        this.mContext=context;
    }

    public UnScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScrollable(boolean scrollable) {
        isScrollable = scrollable;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(isScrollable)
            return  super.onTouchEvent(ev);

        boolean b = super.onTouchEvent(ev);

        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(isScrollable){
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }
}

