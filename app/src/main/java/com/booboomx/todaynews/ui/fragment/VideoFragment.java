package com.booboomx.todaynews.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.base.BaseFragment;
import com.booboomx.todaynews.base.BasePresenter;
import com.booboomx.todaynews.ui.adapter.TitlePagerAdapter;
import com.booboomx.todaynews.utils.ConstanceValue;
import com.booboomx.todaynews.widget.colortrackview.ColorTrackTabViewIndicator;
import com.booboomx.todaynews.widget.colortrackview.ColorTrackView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 视频的界面
 */
public class VideoFragment extends BaseFragment {

    @BindView(R.id.indicator)
    ColorTrackTabViewIndicator mIndicator;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    private String[] titles = new String[]{"全部", "逗比剧", "音乐台", "看天下", "小品", "唱将", "最娱乐"};
    private String[] titlesCode = new String[]{"video", "subv_funny", "subv_voice", "subv_society", "subv_comedy", "subv_haoshengyin", "subv_entertainment"};

    private List<Fragment>fragments=new ArrayList<>();

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_video;
    }


    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void lazyFetchData() {
        super.lazyFetchData();

        for (int i = 0; i < titles.length; i++) {

            VideoListFragment fragment=new VideoListFragment();
            Bundle bundle=new Bundle();
            bundle.putString(ConstanceValue.DATA,titlesCode[i]);
            fragment.setArguments(bundle);

            fragments.add(fragment);

        }


        mViewpager.setAdapter(new TitlePagerAdapter(getChildFragmentManager(),fragments,titles));

        mIndicator.setTitles(titles, new ColorTrackTabViewIndicator.CorlorTrackTabBack() {
            @Override
            public void onClickButton(Integer position, ColorTrackView colorTrackView) {
                mViewpager.setCurrentItem(position,false);
            }
        });


        View childAt = mIndicator.getChildAt(0);


        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);


        //重新测量
        childAt.measure(w,h);
        childAt.setMinimumWidth(childAt.getMeasuredWidth()+mIndicator.getTabWidth());

        mViewpager.setOffscreenPageLimit(titles.length);


        mIndicator.setupViewPager(mViewpager);
    }

}
