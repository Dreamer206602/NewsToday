package com.booboomx.todaynews.ui.fragment;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.base.BaseFragment;
import com.booboomx.todaynews.model.NewsBean;
import com.booboomx.todaynews.presenter.NewListPresenter;
import com.booboomx.todaynews.ui.adapter.VideoAdapter;
import com.booboomx.todaynews.ui.view.NewListView;
import com.booboomx.todaynews.utils.ConstanceValue;
import com.booboomx.todaynews.utils.RxUtils;
import com.booboomx.todaynews.widget.ParallaxRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 *
 */
public class VideoListFragment extends BaseFragment<NewListPresenter> implements NewListView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.recyclerView)
    ParallaxRecyclerView mRecyclerView;

    private String mTitleCode;

    private VideoAdapter mAdapter;
    private List<NewsBean> mDatas = new ArrayList<>();

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_video_list;
    }


    @Override
    public NewListPresenter createPresenter() {
        return new NewListPresenter(this);
    }

    @Override
    public void lazyFetchData() {
        super.lazyFetchData();
        mTitleCode = getArguments().getString(ConstanceValue.DATA);

        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.measure(0, 0);
        mSwipeRefreshLayout.setRefreshing(true);

        mAdapter = new VideoAdapter(mDatas);
        mRecyclerView.setAdapter(mAdapter);


        if (mTitleCode != null) {
            mvpPresenter.getNewsList(mTitleCode);

        }


        //视频监听
        mRecyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {

            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                if (JCVideoPlayerManager.getCurrentJcvd() != null) {
                    JCVideoPlayer videoPlayer = JCVideoPlayerManager.getCurrentJcvd();
                    if (((ViewGroup) view).indexOfChild(videoPlayer) != -1 && videoPlayer.currentState == JCVideoPlayer.CURRENT_STATE_PLAYING) {
                        //当滑动的时，正在播放的视频移除屏幕，取消播放这个视频
                        JCVideoPlayer.releaseAllVideos();
                    }
                }
            }
        });


    }


    @Override
    public void onGetNewsListSuccess(List<NewsBean> dataBeanList) {
        mDatas.clear();
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }

        //由于最后一条重复 ，删除掉
        if (dataBeanList.size() > 0)
            dataBeanList.remove(dataBeanList.size() - 1);
        mDatas.addAll(0, dataBeanList);
        mAdapter.notifyItemRangeChanged(0, dataBeanList.size());


    }

    @Override
    public void onRefresh() {

        Subscription subscription = Observable.timer(500, TimeUnit.MICROSECONDS)
                .compose(RxUtils.<Long>rxSchedulerHelper())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {

                        if (mSwipeRefreshLayout.isRefreshing()) {
                            mSwipeRefreshLayout.setRefreshing(false);
                        }

                        mvpPresenter.getNewsList(mTitleCode);


                    }
                });




    }
}
