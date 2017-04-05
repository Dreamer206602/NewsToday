package com.booboomx.todaynews.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by booboomx on 17/4/4.
 */

public class TitlePagerAdapter extends FragmentPagerAdapter {

    private List<Fragment>mFragments;
    private String[]titles;

    public TitlePagerAdapter(FragmentManager fm,List<Fragment>fragments,String[] titles) {
        super(fm);
        this.mFragments=fragments;
        this.titles=titles;
    }


    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size()>0?mFragments.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles==null?"":titles[position];
    }
}
