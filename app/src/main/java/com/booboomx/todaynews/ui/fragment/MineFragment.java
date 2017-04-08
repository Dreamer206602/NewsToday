package com.booboomx.todaynews.ui.fragment;


import android.widget.ImageView;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.base.BaseFragment;
import com.booboomx.todaynews.base.BasePresenter;
import com.booboomx.todaynews.utils.ImageLoaderUtils;

import butterknife.BindView;

/**
 *
 */
public class MineFragment extends BaseFragment {

    @BindView(R.id.iv_headView)
    ImageView mIvHeadView;

    public static final String URL="http://upload.jianshu.io/users/upload_avatars/1859948/497273cbba1d.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/120/h/120";

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_mine;
    }



    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void lazyFetchData() {
        super.lazyFetchData();

        ImageLoaderUtils.loadeCircleImage(getContext(),URL,mIvHeadView);



    }
}
