package com.booboomx.todaynews.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.base.BaseActivity;
import com.booboomx.todaynews.ui.adapter.MyFragmentPagerAdapter;
import com.booboomx.todaynews.ui.fragment.ConcernFragment;
import com.booboomx.todaynews.ui.fragment.HomeFragment;
import com.booboomx.todaynews.ui.fragment.MineFragment;
import com.booboomx.todaynews.ui.fragment.VideoFragment;
import com.booboomx.todaynews.view.UnScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    @BindView(R.id.viewPager)
    UnScrollViewPager mViewPager;
    RadioGroup mTabRgMenu;

    private MyFragmentPagerAdapter mPagerAdapter;


    @Override
    public void processLogic(Bundle savedInstanceState) {


        List<Fragment> fragments = getFragments();
        mViewPager.setScrollable(false);//禁止左右滑动
        mPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments);

        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(fragments.size());


    }


    @Override
    protected void setListener() {

        mTabRgMenu.setOnCheckedChangeListener(this);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((RadioButton) mTabRgMenu.getChildAt(position)).setChecked(true);


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public List<Fragment> getFragments() {

        List<Fragment> mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new VideoFragment());
        mFragments.add(new ConcernFragment());
        mFragments.add(new MineFragment());

        return mFragments;
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.tab_rb_1:
                mViewPager.setCurrentItem(0, false);
                break;
            case R.id.tab_rb_2:
                mViewPager.setCurrentItem(1, false);
                break;
            case R.id.tab_rb_3:
                mViewPager.setCurrentItem(2, false);
                break;
            case R.id.tab_rb_4:
                mViewPager.setCurrentItem(3, false);

                break;
        }

    }
}
