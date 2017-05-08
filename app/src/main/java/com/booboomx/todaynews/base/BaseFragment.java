package com.booboomx.todaynews.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.booboomx.todaynews.model.Notice;
import com.booboomx.todaynews.utils.RxBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Observable;

/**
 * Created by booboomx on 17/4/2.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {


    public P mvpPresenter;
    public  final String TAG=getClass().getSimpleName();

    public Context mContext;
    private View rootView;
    public Unbinder mUnbinder;
    public boolean isViewPrepared;//标识Fragment视图已经初始化完毕
    public  boolean hasFetchData;//标识已经触发过懒加载数据

    public String getName(){
        return  BaseFragment.class.getName();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (mContext != null) {
            this.mContext=context;
        }else{
            this.mContext=getActivity();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public  abstract  int getFragmentLayout();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(rootView==null){
            rootView=inflater.inflate(getFragmentLayout(),container,false);
        }

        ViewGroup parent = (ViewGroup) rootView.getParent();

        if (parent != null) {
            parent.removeView(rootView);
        }

        mUnbinder = ButterKnife.bind(this, rootView);
        initView(inflater);
        return rootView;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initEvent();

    }

    @Override
    public void onStart() {
        super.onStart();


    }


    @Override
    public void onResume() {
        super.onResume();


    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(mvpPresenter==null)
            mvpPresenter=createPresenter();
        isViewPrepared=true;
        lazyFetchDataIfPrepared();


    }

    public abstract P createPresenter() ;

    @Override
    public void onPause() {
        super.onPause();


    }


    @Override
    public void onStop() {
        super.onStop();



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // view被销毁后，将可以重新触发数据懒加载，因为在viewpager下，fragment不会再次新建并走onCreate的生命周期流程，将从onCreateView开始

        hasFetchData=false;
        isViewPrepared=false;

        if (mUnbinder != null) {
            mUnbinder.unbind();
        }

        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }


    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();



    }


    /**
     * Fragment视图可见
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(isVisibleToUser){
            lazyFetchDataIfPrepared();
        }


    }

    private void lazyFetchDataIfPrepared() {
        // 用户可见fragment && 没有加载过数据 && 视图已经准备完毕

        if(getUserVisibleHint()&& !hasFetchData&& isViewPrepared){
            hasFetchData=true;
            lazyFetchData();
        }




    }

    /**
     * 懒加载的方式获取数据，仅在满足fragment可见和视图已经准备好的时候调用一次
     *
     * 感觉不太合理
     *
     */
    public void lazyFetchData() {

        if(mvpPresenter==null)
            mvpPresenter=createPresenter();

    }

    private void initEvent() {

    }

    protected  void initView(LayoutInflater inflater){

    }


    /**
     * 注册事件通知
     */
    public Observable<Notice> toObservable() {
        return RxBus.getDefault().toObservable(Notice.class);
    }

    /**
     * 发送消息
     */
    public void post(Notice msg) {
        RxBus.getDefault().post(msg);
    }




}
