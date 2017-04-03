package com.booboomx.todaynews.base;

/**
 * Created by booboomx on 17/4/3.
 */

public interface Presenter<V> {

    void attachView(V view);

    void detachView();

}
