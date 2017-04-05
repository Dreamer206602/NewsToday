package com.booboomx.todaynews.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

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
import butterknife.OnClick;

/**
 * 主页
 */
public class HomeFragment extends BaseFragment {


    @BindView(R.id.indicator)
    ColorTrackTabViewIndicator mIndicator;
    @BindView(R.id.iv_category)
    ImageView mIvCategory;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;

    private String[] titles = new String[]{"推荐", "视频", "热点", "社会", "娱乐", "科技", "汽车", "体育", "财经", "军事", "国际", "时尚", "游戏", "旅游", "历史", "探索", "美食", "育儿", "养生", "故事", "美文"};
    private String[] titlesCode = new String[]{"__all__", "video", "news_hot", "news_society", "news_entertainment", "news_tech", "news_car", "news_sports", "news_finance", "news_military", "news_world", "news_fashion", "news_game", "news_travel", "news_history", "news_discovery", "news_food", "news_baby", "news_regimen", "news_story", "news_essay"};

   private List<Fragment>fragments=new ArrayList<>();
    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_home;
    }


    @Override
    public BasePresenter createPresenter() {
        return null;
    }


    @Override
    public void lazyFetchData() {
        super.lazyFetchData();

        for (int i = 0; i < titles.length; i++) {

            NewsListFragment fragment=new NewsListFragment();
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



    @OnClick({R.id.feed_top_search_hint,R.id.iv_category})
    public void OnClick(View view){

        switch (view.getId()){
            case R.id.iv_category:

                break;
        }

    }



}
