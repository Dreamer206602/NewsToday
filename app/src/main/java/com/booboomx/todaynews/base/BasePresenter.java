package com.booboomx.todaynews.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by booboomx on 17/4/3.
 */

public class BasePresenter<V> implements Presenter<V> {

    public V mVpView;
    private CompositeSubscription mCompositeSubscription;


    public BasePresenter(V view){
        attachView(view);
    }

    @Override
    public void attachView(V view) {
        this.mVpView=view;

    }

    @Override
    public void detachView() {

        onUnSubscribe();
    }


    public void addSubscription(Subscription subscription){
        if (mCompositeSubscription == null) {
            mCompositeSubscription=new CompositeSubscription();
            mCompositeSubscription.add(subscription);
        }
    }

    public void onUnSubscribe(){

        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }

    }
}
