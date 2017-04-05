package com.booboomx.todaynews.ui.fragment;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.base.BaseFragment;
import com.booboomx.todaynews.model.NewsBean;
import com.booboomx.todaynews.presenter.NewListPresenter;
import com.booboomx.todaynews.ui.adapter.NewListAdapter;
import com.booboomx.todaynews.ui.view.NewListView;
import com.booboomx.todaynews.utils.ConstanceValue;
import com.booboomx.todaynews.utils.RxUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/**
 *
 */
public class NewsListFragment extends BaseFragment<NewListPresenter> implements SwipeRefreshLayout.OnRefreshListener, NewListView {


    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout mSwipeRefresh;

    private String titleCode;
    private NewListAdapter mAdapter;

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_news_list;
    }

    @Override
    public NewListPresenter createPresenter() {
        return new NewListPresenter(this);
    }


    @Override
    public void lazyFetchData() {
        super.lazyFetchData();


        mSwipeRefresh.setOnRefreshListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        if (TextUtils.isEmpty(titleCode))
            titleCode = getArguments().getString(ConstanceValue.DATA);

        mvpPresenter.getNewsList(titleCode);


    }


    @Override
    public void onRefresh() {

        Subscription subscription= Observable.timer(1000, TimeUnit.MILLISECONDS)
                .compose(RxUtils.<Long>rxSchedulerHelper())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {

                        mSwipeRefresh.setRefreshing(false);

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });




    }


    @Override
    public void onGetNewsListSuccess(List<NewsBean> dataBeanList) {

        mAdapter=new NewListAdapter(dataBeanList);
        mRecyclerView.setAdapter(mAdapter);


    }
}
