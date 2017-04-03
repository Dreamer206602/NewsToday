package com.booboomx.todaynews.ui.fragment;


import com.booboomx.todaynews.R;
import com.booboomx.todaynews.base.BaseFragment;
import com.booboomx.todaynews.base.BasePresenter;

/**
 *
 */
public class MineFragment extends BaseFragment {


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
    }
}
