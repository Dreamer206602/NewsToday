package com.booboomx.todaynews.utils;

import com.booboomx.todaynews.model.GankHttpResponse;
import com.booboomx.todaynews.net.exception.ApiException;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by booboomx on 17/4/4.
 */

public class RxUtils {


    /**
     * 统一处理线程
     */
    public static <T> Observable.Transformer<T,T> rxSchedulerHelper(){

        return new Observable.Transformer<T,T>(){

            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 下载 全在子线程
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<T, T> all_io() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable.observeOn(Schedulers.io()).subscribeOn(Schedulers.io());
            }
        };
    }




    public static <T> Observable.Transformer<GankHttpResponse<T>, T> handleGankResult() {   //compose判断结果
        return new Observable.Transformer<GankHttpResponse<T>, T>() {
            @Override
            public Observable<T> call(Observable<GankHttpResponse<T>> httpResponseObservable) {
                return httpResponseObservable.flatMap(new Func1<GankHttpResponse<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(GankHttpResponse<T> tGankHttpResponse) {
                        if(!tGankHttpResponse.getError()) {
                            return createData(tGankHttpResponse.getResults());
                        } else {
                            return Observable.error(new ApiException("服务器返回error"));
                        }
                    }
                });
            }
        };
    }










    /**
     * 生成 Observable
     *
     */
    public static <T> Observable<T> createData(final  T t){

        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try{

                    subscriber.onNext(t);
                    subscriber.onCompleted();
                }catch (Exception e){
                    subscriber.onError(e);

                }
            }
        });

    }


}
