package com.booboomx.todaynews.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.base.BaseActivity;
import com.booboomx.todaynews.interf.OnChannelDragListener;
import com.booboomx.todaynews.model.Channel;
import com.booboomx.todaynews.ui.adapter.ChannelAdapter;
import com.booboomx.todaynews.widget.ItemDragHelperCallBack;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ChannelActivity extends BaseActivity implements OnChannelDragListener {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private List<Channel>mDatas=new ArrayList<>();
    private ChannelAdapter mAdapter;
    private final String[] titles = new String[]{"推荐", "视频", "热点", "社会", "娱乐", "科技", "汽车", "体育", "财经", "军事", "国际", "时尚", "游戏", "旅游", "历史", "探索", "美食", "育儿", "养生", "故事", "美文"};

    private ItemTouchHelper mHelper;


    @OnClick(R.id.iv_close)
    public void onClick(){
        finish();

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void processLogic(Bundle savedInstanceState) {

        initDatas();

        mAdapter=new ChannelAdapter(mDatas);

        GridLayoutManager manager=new GridLayoutManager(this,4);
        mRecyclerView.setLayoutManager(manager);

        mRecyclerView.setAdapter(mAdapter);

        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                int itemViewType = mAdapter.getItemViewType(position);

                return itemViewType==Channel.TYPE_MY_CHANNEL||itemViewType==Channel.TYPE_OTHER_CHANNEL?1:4;
            }
        });

        ItemDragHelperCallBack callBack=new ItemDragHelperCallBack(this);


        mHelper=new ItemTouchHelper(callBack);

        mAdapter.setOnChannelDragListener(this);

        mHelper.attachToRecyclerView(mRecyclerView);
    }

    private void initDatas() {

        mDatas.add(new Channel("我的频道"));
        for (int i = 0; i < titles.length; i++) {
            String title = titles[i];
            mDatas.add(new Channel(title));
        }
        mDatas.add(new Channel("其他频道"));
        for (int i = 0; i < titles.length; i++) {
            String title = titles[i];
            mDatas.add(new Channel(title + "推荐2"));
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_channel;
    }

    @Override
    public void onStartDrag(BaseViewHolder baseViewHolder) {

        mHelper.startDrag(baseViewHolder);

    }

    @Override
    public void onItemMove(int startPos, int endPos) {

        Channel channel = mDatas.get(startPos);
        //先删除之前的位置
        mDatas.remove(startPos);
        //添加到现在的位置
        mDatas.add(endPos,channel);
        mAdapter.notifyItemMoved(startPos,endPos);

    }
}
