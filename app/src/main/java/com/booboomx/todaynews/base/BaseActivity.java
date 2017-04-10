package com.booboomx.todaynews.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.booboomx.todaynews.app.BaseApplication;
import com.jaeger.library.StatusBarUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by booboomx on 17/4/2.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;
    private CompositeSubscription mCompositeSubscription;
    protected Subscription mSubscription;
    public Unbinder mUnbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initView(savedInstanceState);


    }

    private void initView(Bundle savedInstanceState) {

        setContentView(getLayoutId());
        BaseApplication.getInstance().addActivity(this);
        mUnbinder=ButterKnife.bind(this);

        StatusBarUtil.setColor(this, Color.RED);

        processLogic(savedInstanceState);
        setListener();





    }

    protected abstract void setListener();


    @Override
    protected void onDestroy() {
        mUnbinder.unbind();
        unSubscribe();
        super.onDestroy();
    }

    public void addSubscribe(Subscription subscription){

        if(mCompositeSubscription==null){
            mCompositeSubscription=new CompositeSubscription();
        }

        mCompositeSubscription.add(subscription);



    }

    public void unSubscribe(){
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    public abstract void processLogic(Bundle savedInstanceState);

    public abstract int getLayoutId();
}
