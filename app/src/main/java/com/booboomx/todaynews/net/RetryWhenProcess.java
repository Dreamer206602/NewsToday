package com.booboomx.todaynews.net;

import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * Created by booboomx on 17/4/8.
 */

public class RetryWhenProcess implements Func1<Observable<? extends Throwable>, Observable<?>> {

    private long mInterval;

    public RetryWhenProcess(long interval) {

        mInterval = interval;
    }

    @Override
    public Observable<?> call(final Observable<? extends Throwable> observable) {
        return observable.flatMap(new Func1<Throwable, Observable<?>>() {
            @Override
            public Observable<?> call(Throwable throwable) {
                return observable.flatMap(new Func1<Throwable, Observable<?>>() {
                    @Override
                    public Observable<?> call(Throwable throwable) {
                        if (throwable instanceof UnknownHostException) {
                            return Observable.error(throwable);
                        }
                        return Observable.just(throwable).zipWith(Observable.range(1, 5), new Func2<Throwable, Integer, Integer>() {
                            @Override
                            public Integer call(Throwable throwable, Integer i) {

                                return i;
                            }
                        }).flatMap(new Func1<Integer, Observable<? extends Long>>() {
                            @Override
                            public Observable<? extends Long> call(Integer retryCount) {

                                return Observable.timer((long) Math.pow(mInterval, retryCount), TimeUnit.SECONDS);
                            }
                        });
                    }
                });
            }
        });
    }
}

