package com.booboomx.todaynews.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.base.BaseActivity;
import com.booboomx.todaynews.model.GankHttpResponse;
import com.booboomx.todaynews.model.GankItemBean;
import com.booboomx.todaynews.net.gank.RetrofitHelper;
import com.booboomx.todaynews.ui.adapter.MeizhiAdapter;
import com.booboomx.todaynews.utils.ConstanceValue;
import com.booboomx.todaynews.utils.RxUtils;
import com.github.rubensousa.gravitysnaphelper.GravityPagerSnapHelper;

import java.util.List;

import butterknife.BindView;
import rx.Subscriber;
import rx.Subscription;

/**
 * 自定义SnapHelper center top end
 */
public class CustomSnapHelperActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private MeizhiAdapter mAdapter;


    private String type;
    private int page=1;
    private int num=20;


    @Override
    protected void setListener() {

    }

    @Override
    public void processLogic(Bundle savedInstanceState) {


       type= getIntent().getStringExtra(ConstanceValue.TYPE);


        LinearLayoutManager manager=new LinearLayoutManager(this);
        if(type.equals("1")){
            //center
            SnapHelper snapHelper=new LinearSnapHelper();

            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mRecyclerView.setLayoutManager(manager);

            snapHelper.attachToRecyclerView(mRecyclerView);


        }else if(type.equals("2")){//start
            SnapHelper snapHelper=new GravityPagerSnapHelper(Gravity.START);

            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mRecyclerView.setLayoutManager(manager);
            snapHelper.attachToRecyclerView(mRecyclerView);

        }else if(type.equals("3")){
            //top
            SnapHelper snapHelper=new GravityPagerSnapHelper(Gravity.TOP);
            manager.setOrientation(LinearLayoutManager.VERTICAL);

            mRecyclerView.setLayoutManager(manager);
            snapHelper.attachToRecyclerView(mRecyclerView);


        }



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
        return R.layout.activity_custom_snap_helper;
    }
}
