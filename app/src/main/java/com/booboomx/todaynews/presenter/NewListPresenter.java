package com.booboomx.todaynews.presenter;

import android.util.Log;

import com.booboomx.todaynews.base.BasePresenter;
import com.booboomx.todaynews.model.NewsBean;
import com.booboomx.todaynews.model.ResultResponse;
import com.booboomx.todaynews.net.AppClient;
import com.booboomx.todaynews.net.RetryWhenProcess;
import com.booboomx.todaynews.ui.view.NewListView;
import com.booboomx.todaynews.utils.RxUtils;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by booboomx on 17/4/4.
 */

public class NewListPresenter extends BasePresenter<NewListView> {

    public static final String TAG="NewListPresenter";
    public NewListPresenter(NewListView view) {
        super(view);
    }


    public void getNewsList(String titleCode){

        Subscription subscription= AppClient.getApiService().getNews(titleCode)
                .compose(RxUtils.<ResultResponse<List<NewsBean>>>rxSchedulerHelper())
                .retryWhen(new RetryWhenProcess(5))
                .subscribe(new Subscriber<ResultResponse<List<NewsBean>>>() {
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
                    public void onNext(ResultResponse<List<NewsBean>> listResultResponse) {

                        Log.i(TAG, "onNext: "+listResultResponse.message);

                        mVpView.onGetNewsListSuccess(listResultResponse.data);
                    }
                });
        addSubscription(subscription);


    }






}
