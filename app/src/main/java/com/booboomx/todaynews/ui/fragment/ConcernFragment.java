package com.booboomx.todaynews.ui.fragment;


import android.support.v7.widget.LinearLayoutManager;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.base.BaseFragment;
import com.booboomx.todaynews.base.BasePresenter;
import com.booboomx.todaynews.ui.adapter.ConcernAdapter;
import com.booboomx.todaynews.widget.ParallaxRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 关注的界面
 */
public class ConcernFragment extends BaseFragment {


    @BindView(R.id.recyclerView)
    ParallaxRecyclerView mRecyclerView;
    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_concern;
    }


    private List<String>datas=new ArrayList<>();
    private ConcernAdapter mAdapter;
    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void lazyFetchData() {
        super.lazyFetchData();


        LinearLayoutManager manager=new LinearLayoutManager(getContext()){

            @Override
            public boolean canScrollVertically() {

                return false;
            }
        };

        mRecyclerView.setLayoutManager(manager);
        datas.add("狼王-加内特");
        datas.add("石佛-邓肯");
        datas.add("小飞侠-科比");
        datas.add("奥尼尔");
        datas.add("托尼-帕克");
        datas.add("面瘫-卡哇伊-莱昂纳德");
        datas.add("千年老二-杜兰特");
        datas.add("神龟-威少");
        datas.add("保罗");
        datas.add("加索尔");
        datas.add("啵啵维奇");
        datas.add("丹尼-格林");


        mAdapter=new ConcernAdapter(datas);
        mRecyclerView.setAdapter(mAdapter);




    }
}
