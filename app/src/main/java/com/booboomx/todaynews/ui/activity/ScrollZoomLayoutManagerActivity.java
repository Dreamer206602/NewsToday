package com.booboomx.todaynews.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.base.BaseActivity;
import com.booboomx.todaynews.model.GankHttpResponse;
import com.booboomx.todaynews.model.GankItemBean;
import com.booboomx.todaynews.net.gank.RetrofitHelper;
import com.booboomx.todaynews.ui.adapter.MeizhiAdapter;
import com.booboomx.todaynews.utils.ConstanceValue;
import com.booboomx.todaynews.utils.RxUtils;
import com.booboomx.todaynews.widget.customLayoutManager.CustomLayoutManager;
import com.booboomx.todaynews.widget.customLayoutManager.impl.CircleLayoutManager;
import com.booboomx.todaynews.widget.customLayoutManager.impl.CircleZoomLayoutManager;
import com.booboomx.todaynews.widget.customLayoutManager.impl.GalleryLayoutManager;
import com.booboomx.todaynews.widget.customLayoutManager.impl.ScrollZoomLayoutManager;

import java.util.List;

import butterknife.BindView;
import rx.Subscriber;
import rx.Subscription;

public class ScrollZoomLayoutManagerActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private MeizhiAdapter mAdapter;
    private int page=1,num=20;
    private String type;


//    private ScrollZoomLayoutManager mScrollZoomLayoutManager;
//    private CircleLayoutManager mCircleLayoutManager;
//    private GalleryLayoutManager mGalleryLayoutManager;
//    private CircleZoomLayoutManager mCircleZoomLayoutManager;

    private CustomLayoutManager mManager;

    @Override
    protected void setListener() {

    }


    private int Dp2px(float dp) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    @Override
    public void processLogic(Bundle savedInstanceState) {

        type=getIntent().getStringExtra(ConstanceValue.TYPE);

        if(type.equals("1")){

            mManager=new ScrollZoomLayoutManager(this,Dp2px(10));

        }else if(type.equals("2")){

            mManager=new CircleLayoutManager(this);

        }else if(type.equals("3")){
            mManager=new CircleZoomLayoutManager(this);

        }else if(type.equals("4")){

            mManager=new GalleryLayoutManager(this,Dp2px(10));
        }


        mRecyclerView.setLayoutManager(mManager);

        LinearSnapHelper snapHelper=new LinearSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerView);



        initData();
    }

    private void initData() {
        Subscription subscription= RetrofitHelper.getGankApis().getGirlList(num,page)
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

                        mAdapter=new MeizhiAdapter(gankItemBeen);
                        mRecyclerView.setAdapter(mAdapter);


                    }
                });

        addSubscribe(subscription);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_scroll_zoom_layout_manager;
    }
}
