package com.booboomx.todaynews.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.app.BaseApplication;
import com.booboomx.todaynews.model.Notice;
import com.booboomx.todaynews.theme.SkinFactory;
import com.booboomx.todaynews.theme.util.ColorUiUtil;
import com.booboomx.todaynews.theme.util.SharedPreferencesMgr;
import com.booboomx.todaynews.utils.ConstanceValue;
import com.booboomx.todaynews.utils.RxBus;
import com.jaeger.library.StatusBarUtil;

import java.lang.reflect.Field;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
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

        mContext=this;
        if(SharedPreferencesMgr.getInt(ConstanceValue.SP_THEME,ConstanceValue.THEME_LIGHT)==ConstanceValue.THEME_LIGHT){
            setTheme(R.style.Theme_Light);
        }else{
            setTheme(R.style.Theme_Night);
        }

        mSubscription=toObServable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Notice>() {
                    @Override
                    public void call(Notice notice) {
                        if(notice.type==ConstanceValue.MSG_TYPE_CHANGE_THEME){

                            ColorUiUtil.changeTheme(getWindow().getDecorView(),getTheme());
                        }

                    }
                });



        setLayoutInflaterFactory();
        initView(savedInstanceState);


    }

    private void setLayoutInflaterFactory() {

        LayoutInflater layoutInflater = getLayoutInflater();
        try{
            Field mFactorySet = LayoutInflater.class.getDeclaredField("mFactorySet");
            mFactorySet.setAccessible(true);
            mFactorySet.set(layoutInflater,false);
            LayoutInflaterCompat.setFactory(layoutInflater,new SkinFactory(this));

        }catch (Exception e){

        }


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

    /**
     * 注册通知事件
     * @return
     */
    public Observable<Notice> toObServable(){
        return  RxBus.getDefault().toObservable(Notice.class);

    }
}
