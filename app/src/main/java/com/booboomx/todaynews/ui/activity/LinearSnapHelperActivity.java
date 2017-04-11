package com.booboomx.todaynews.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.base.BaseActivity;
import com.booboomx.todaynews.model.GankHttpResponse;
import com.booboomx.todaynews.model.GankItemBean;
import com.booboomx.todaynews.net.gank.RetrofitHelper;
import com.booboomx.todaynews.ui.adapter.MeizhiAdapter;
import com.booboomx.todaynews.utils.ConstanceValue;
import com.booboomx.todaynews.utils.RxUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import butterknife.BindView;
import rx.Subscriber;
import rx.Subscription;

public class LinearSnapHelperActivity extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener{

    public static final String TAG=LinearSnapHelperActivity.class.getSimpleName();
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private MeizhiAdapter mAdapter;
    private int num=20;
    private int page=1;


    private String type;


    @Override
    protected void setListener() {

    }

    @Override
    public void processLogic(Bundle savedInstanceState) {

        type=getIntent().getStringExtra(ConstanceValue.TYPE);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        if(type.equals("0")){
            manager.setOrientation(LinearLayoutManager.VERTICAL);
        }else{
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        }
        mRecyclerView.setLayoutManager(manager);
        LinearSnapHelper linearSnapHelper=new LinearSnapHelper();
        linearSnapHelper.attachToRecyclerView(mRecyclerView);


        Subscription subscription= RetrofitHelper.getGankApis().getGirlList(num,page)
                .compose(RxUtils.<GankHttpResponse<List<GankItemBean>>>rxSchedulerHelper())
                .compose(RxUtils.<List<GankItemBean>>handleGankResult())
                .subscribe(new Subscriber<List<GankItemBean>>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        Log.i(TAG, "onStart: ");
                    }

                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted: ");

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i(TAG, "onError: "+e.getMessage());

                    }

                    @Override
                    public void onNext(List<GankItemBean> gankItemBeen) {

                        if(gankItemBeen.size()>0){

                            getData(gankItemBeen);

                        }

                    }


                });

        addSubscribe(subscription);





    }

    private void getData(List<GankItemBean> gankItemBeen) {

        mAdapter=new MeizhiAdapter(gankItemBeen);
        mRecyclerView.setAdapter(mAdapter);


        mAdapter.setOnLoadMoreListener(this,mRecyclerView);



    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_linear_snap_helper;
    }

    @Override
    public void onLoadMoreRequested() {

        page++;
        Subscription subscription=RetrofitHelper.getGankApis().getGirlList(num,page)
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
                        if(gankItemBeen.size()>0){
                            mAdapter.addData(gankItemBeen);
                        }

                    }
                });
        addSubscribe(subscription);


    }
}
