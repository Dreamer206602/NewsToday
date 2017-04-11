package com.booboomx.todaynews.ui.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.base.BaseFragment;
import com.booboomx.todaynews.base.BasePresenter;
import com.booboomx.todaynews.ui.adapter.ConcernAdapter;
import com.booboomx.todaynews.utils.JumpUtils;
import com.booboomx.todaynews.widget.ParallaxRecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 关注的界面
 */
public class ConcernFragment extends BaseFragment {


    @BindView(R.id.recyclerView)
    ParallaxRecyclerView mRecyclerView;

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_concern;
    }


    private List<String> datas = new ArrayList<>();
    private ConcernAdapter mAdapter;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void lazyFetchData() {
        super.lazyFetchData();


        LinearLayoutManager manager = new LinearLayoutManager(getContext()) {

            @Override
            public boolean canScrollVertically() {

                return false;
            }
        };

        mRecyclerView.setLayoutManager(manager);
        datas.add("LinearSnapHelper-VERTICAL");
        datas.add("LinearSnapHelper-HORIZONTAL");
        datas.add("PagerSnapHelper-VERTICAL");
        datas.add("PagerSnapHelper-HORIZONTAL");


        datas.add("CustomSnapHelper-CENTER");
        datas.add("CustomSnapHelper-START");
        datas.add("CustomSnapHelper-TOP");


        mAdapter = new ConcernAdapter(datas);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {

                switch (position) {
                    case 0:
                        JumpUtils.go2LinearSnapHelperActivity(getContext(), "0");
                        break;
                    case 1:
                        JumpUtils.go2LinearSnapHelperActivity(getContext(), "1");
                        break;

                    case 2:
                        JumpUtils.go2PagerSnapHelperActivity(getContext(), "0");
                        break;
                    case 3:
                        JumpUtils.go2PagerSnapHelperActivity(getContext(), "1");
                        break;

                    case 4://center
                        JumpUtils.go2CustomSnapHelperActivity(getContext(), "1");
                        break;
                    case 5://start
                        JumpUtils.go2CustomSnapHelperActivity(getContext(), "2");
                        break;
                    case 6://top
                        JumpUtils.go2CustomSnapHelperActivity(getContext(), "3");
                        break;


                }
            }
        });


    }
}
