package com.booboomx.todaynews.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.base.BaseActivity;
import com.booboomx.todaynews.model.GankHttpResponse;
import com.booboomx.todaynews.model.GankItemBean;
import com.booboomx.todaynews.net.gank.RetrofitHelper;
import com.booboomx.todaynews.ui.adapter.MeizhiAdapter;
import com.booboomx.todaynews.utils.RxUtils;
import com.booboomx.todaynews.widget.transformer.ScaleTransformer;

import java.util.List;

import butterknife.BindView;
import github.hellocsl.layoutmanager.gallery.GalleryLayoutManager;
import rx.Subscriber;
import rx.Subscription;

public class GalleryLayoutManagerActivity extends BaseActivity {


    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private MeizhiAdapter mAdapter;
    private int page = 1, num = 20;

    private GalleryLayoutManager mManager;

    @Override
    protected void setListener() {

    }

    @Override
    public void processLogic(Bundle savedInstanceState) {

        mManager = new GalleryLayoutManager(GalleryLayoutManager.HORIZONTAL);
        //layoutManager.attach(mPagerRecycleView);  默认选中位置为0
        //不要使用 RecycleView#setLayoutManager 方法，而是使用 GalleryLayoutManager#attach 方法
        //layoutManager.attach(mPagerRecycleView, 30);

        mManager.attach(mRecyclerView, 10);
        mManager.setItemTransformer(new ScaleTransformer());



        initData();

    }

    private void initData() {
        Subscription subscription = RetrofitHelper.getGankApis().getGirlList(num, page)
                .compose(RxUtils.<GankHttpResponse<List<GankItemBean>>>rxSchedulerHelper())
                .compose(RxUtils.<List<GankItemBean>>handleGankResult())
                .subscribe(new Subscriber<List<GankItemBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<GankItemBean> gankItemBeen) {

                        mAdapter = new MeizhiAdapter(gankItemBeen);
                        mRecyclerView.setAdapter(mAdapter);


                    }
                });

        addSubscribe(subscription);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_gallery_layout_manager;
    }
}
