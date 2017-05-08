package com.booboomx.todaynews.ui.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.interf.OnChannelDragListener;
import com.booboomx.todaynews.model.Channel;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by booboomx on 17/4/14.
 */

public class ChannelAdapter extends BaseMultiItemQuickAdapter<Channel, BaseViewHolder> {

    public static final String TAG=ChannelAdapter.class.getSimpleName();
    private BaseViewHolder mEditViewHolder;
    private boolean mIsEdit;
    private long startTime;
    // touch 间隔时间 用于分辨是否是 "点击"
    public static final long SPACE_TIME = 100;
    private RecyclerView mRecyclerView;


    public void setOnChannelDragListener(OnChannelDragListener onChannelDragListener) {
        mOnChannelDragListener = onChannelDragListener;
    }

    private OnChannelDragListener mOnChannelDragListener;

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mRecyclerView = (RecyclerView) parent;
        return super.onCreateViewHolder(parent, viewType);
    }

    public ChannelAdapter(List<Channel> data) {
        super(data);
        // 默认没有编辑
        mIsEdit = false;
        addItemType(Channel.TYPE_MY, R.layout.item_channel_title);
        addItemType(Channel.TYPE_MY_CHANNEL, R.layout.item_channel);
        addItemType(Channel.TYPE_OTHER, R.layout.item_channel_title);
        addItemType(Channel.TYPE_OTHER_CHANNEL, R.layout.item_channel);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final Channel channel) {

        switch (holder.getItemViewType()) {

            case Channel.TYPE_MY:
                //我的频道
                // 赋值 以便之后修改文字
                mEditViewHolder = holder;
                holder.setText(R.id.tvTitle, channel.Title)
                        .setOnClickListener(R.id.tvEdit, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (!mIsEdit) {
                                    startEditMode(true);
                                    holder.setText(R.id.tvEdit, "完成");
                                } else {
                                    startEditMode(false);
                                    holder.setText(R.id.tvEdit, " 编辑");

                                }

                            }
                        });


                break;

            case Channel.TYPE_OTHER:
                //其他推荐
                holder.setText(R.id.tvTitle, channel.Title)
                        .setVisible(R.id.tvEdit, false);
                break;

            case Channel.TYPE_MY_CHANNEL:
                // 我的频道列表
                holder.setVisible(R.id.ivDelete, mIsEdit);
                holder.getView(R.id.rlItemView)
                        .setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View v) {
                                if (!mIsEdit) {
                                    //编辑模式
                                    startEditMode(true);
                                    mEditViewHolder.setText(R.id.tvEdit, "完成");
                                }

                                if (mOnChannelDragListener != null)
                                    mOnChannelDragListener.onStartDrag(holder);

                                return true;
                            }
                        });

                holder.getView(R.id.tvChannel).setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        //正常模式不需要监听
                        if (!mIsEdit) return false;
                        switch (event.getAction()) {

                            case MotionEvent.ACTION_DOWN:

                                startTime = System.currentTimeMillis();
                                break;

                            case MotionEvent.ACTION_MOVE:

                                if (System.currentTimeMillis() - startTime > SPACE_TIME) {
                                    //当MOVE事件与DOWN事件的触发的间隔时间大于100ms时，则认为是拖拽starDrag
                                    if (mOnChannelDragListener != null) {
                                        mOnChannelDragListener.onStartDrag(holder);
                                    }
                                }

                                break;


                            case MotionEvent.ACTION_CANCEL:
                            case MotionEvent.ACTION_UP:
                                startTime = 0;
                                break;
                        }

                        return false;
                    }
                });
                //在我的频道里面设置true标示，之后会根据这个标示来判断编辑模式是否显示
                holder.getView(R.id.ivDelete).setTag(true);
                holder.setText(R.id.tvChannel, channel.Title);
                holder.getView(R.id.ivDelete).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //执行删除，移动到推荐频道列表
                        if (mIsEdit) {
                            Log.i(TAG, "onClick: mIsEdit->"+mIsEdit);
                            int otherFirstPosition = getOtehrFirstPosition();
                            int currentPosition = holder.getAdapterPosition();
                            //获取到目标View
                            View targetView = mRecyclerView.getLayoutManager().findViewByPosition(otherFirstPosition);
                            //获取到当前需要移动的View
                            View currntView = mRecyclerView.getLayoutManager().findViewByPosition(currentPosition);

                            // 如果targetView不在屏幕内,则indexOfChild为-1  此时不需要添加动画,因为此时notifyItemMoved自带一个向目标移动的动画
                            // 如果在屏幕内,则添加一个位移动画

                            if (mRecyclerView.indexOfChild(targetView) >= 0 && otherFirstPosition != -1) {

                                Log.i(TAG, "onClick: indexOfChild");
                                RecyclerView.LayoutManager manager = mRecyclerView.getLayoutManager();

                                int spanCount = ((GridLayoutManager) manager).getSpanCount();

                                int targetX = targetView.getLeft();
                                int targetY = targetView.getTop();

                                int myChannelSize = getMyChannelSize();

                                if (myChannelSize % spanCount == 1) {
                                    //我的频道最后一行 之后一个，移动后
                                    targetY -= targetView.getHeight();
                                }

                                //我的频道 移动到 推荐频道的第一个
                                //改为推荐频道类型
                                channel.setItemType(Channel.TYPE_OTHER_CHANNEL);

                                if (mOnChannelDragListener != null)
                                    mOnChannelDragListener.onItemMove(currentPosition, otherFirstPosition - 1);

                                startAnimation(currntView, targetX, targetY);

                            } else {

                                Log.i(TAG, "onClick: indexOfChild-->else");
                                channel.setItemType(Channel.TYPE_OTHER_CHANNEL);

                                if (otherFirstPosition == -1)
                                    otherFirstPosition = mData.size();

                                if (mOnChannelDragListener != null)
                                    mOnChannelDragListener.onItemMove(currentPosition, otherFirstPosition - 1);


                            }

                        }

                    }
                });
                break;


            case Channel.TYPE_OTHER_CHANNEL:
                //推荐列表
                holder.setText(R.id.tvChannel, channel.Title).setVisible(R.id.ivDelete, false);
                holder.getView(R.id.tvChannel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int myLastPosition = getMyLasPosition();
                        int currentPosition = holder.getAdapterPosition();

                        //获取到目标View
                        View targetView = mRecyclerView.getLayoutManager().findViewByPosition(myLastPosition);

                        //获取到当前需要移动的View
                        View currntView = mRecyclerView.getLayoutManager().findViewByPosition(currentPosition);

                        // 如果targetView不在屏幕内,则indexOfChild为-1  此时不需要添加动画,因为此时notifyItemMoved自带一个向目标移动的动画
                        // 如果在屏幕内,则添加一个位移动画

                        if (mRecyclerView.indexOfChild(targetView) >= 0 && myLastPosition != -1) {

                            Log.i(TAG, "onClick: TYPE_OTHER_CHANNEL-->");
                            RecyclerView.LayoutManager manager = mRecyclerView.getLayoutManager();
                            int spanCount = ((GridLayoutManager) manager).getSpanCount();


                            int targetX = targetView.getLeft() + targetView.getWidth();
                            int targetY = targetView.getTop();


                            int myChannelSize = getMyChannelSize();
                            if (myChannelSize % spanCount == 0) {
                                //添加到我的频道后会换行，所以找到倒数第4个的位置
                                View lastFourthView = mRecyclerView.getLayoutManager().findViewByPosition(getMyLasPosition() - 3);
                                targetX = lastFourthView.getLeft();
                                targetY = lastFourthView.getTop() + lastFourthView.getHeight();

                            }

                            //我的频道 移动到 推荐频道的第一个
                            channel.setItemType(Channel.TYPE_MY_CHANNEL);
                            if (mOnChannelDragListener != null)
                                mOnChannelDragListener.onItemMove(currentPosition, myLastPosition + 1);
                            startAnimation(currntView, targetX, targetY);


                        } else {
                            channel.setItemType(Channel.TYPE_MY_CHANNEL);
                            if (myLastPosition == -1)
                                myLastPosition = 0;//我的频道没有了，改成0

                            if (mOnChannelDragListener != null)
                                mOnChannelDragListener.onItemMove(currentPosition, myLastPosition + 1);

                        }
                    }
                });

                break;

        }

    }

    private void startAnimation(final View currntView, int targetX, int targetY) {

        final ViewGroup parent = (ViewGroup) mRecyclerView.getParent();

        final ImageView mirrorView = addMirrorView(parent, currntView);

        TranslateAnimation animator
                = getTranslateAnimator(targetX - currntView.getLeft(), targetY - currntView.getTop());
        currntView.setVisibility(View.INVISIBLE);
        mirrorView.startAnimation(animator);
        animator.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                parent.removeView(mirrorView);//删除添加的镜像View
                if (currntView.getVisibility() == View.INVISIBLE) {
                    currntView.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }


    /**
     * 添加需要移动的 镜像View
     */
    private ImageView addMirrorView(ViewGroup parent, View view) {
        view.destroyDrawingCache();
        //首先开启Cache图片 ，然后调用view.getDrawingCache()就可以获取Cache图片
        view.setDrawingCacheEnabled(true);
        ImageView mirrorView = new ImageView(view.getContext());
        //获取该view的Cache图片
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        mirrorView.setImageBitmap(bitmap);
        //销毁掉cache图片
        view.setDrawingCacheEnabled(false);
        int[] locations = new int[2];
        view.getLocationOnScreen(locations);//获取当前View的坐标
        int[] parenLocations = new int[2];
        mRecyclerView.getLocationOnScreen(parenLocations);//获取RecyclerView所在坐标
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(bitmap.getWidth(), bitmap.getHeight());
        params.setMargins(locations[0], locations[1] - parenLocations[1], 0, 0);
        parent.addView(mirrorView, params);//在RecyclerView的Parent添加我们的镜像View，parent要是FrameLayout这样才可以放到那个坐标点
        return mirrorView;
    }

    private int ANIM_TIME = 360;

    /**
     * 获取位移动画
     */
    private TranslateAnimation getTranslateAnimator(float targetX, float targetY) {
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.ABSOLUTE, targetX,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.ABSOLUTE, targetY);
        // RecyclerView默认移动动画250ms 这里设置360ms 是为了防止在位移动画结束后 remove(view)过早 导致闪烁
        translateAnimation.setDuration(ANIM_TIME);
        translateAnimation.setFillAfter(true);
        return translateAnimation;
    }


    /**
     * 获取推荐频道列表的第一个position
     *
     * @return
     */
    private int getOtehrFirstPosition() {
        for (int i = 0; i < mData.size(); i++) {
            Channel channel = mData.get(i);
            if (Channel.TYPE_OTHER_CHANNEL == channel.getItemType()) {
                // 找到第一个返回
                return i;
            }
        }
        return -1;
    }


    /**
     * 我的频道最后一个的position
     *
     * @return
     */
    private int getMyLasPosition() {
        for (int i = mData.size() - 1; i > -1; i--) {
            Channel channel = mData.get(i);
            if (Channel.TYPE_MY_CHANNEL == channel.getItemType()) {
                // 找到第一个返回
                return i;
            }
        }
        return -1;
    }

    private void startEditMode(boolean isEdit) {
        mIsEdit = isEdit;
        int visibleChildCount = mRecyclerView.getChildCount();
        for (int i = 0; i < visibleChildCount; i++) {
            View view = mRecyclerView.getChildAt(i);
            ImageView imgEdit = (ImageView) view.findViewById(R.id.ivDelete);
            if (imgEdit != null) {
                boolean isVis = imgEdit.getTag() == null ? false : (boolean) imgEdit.getTag();
                imgEdit.setVisibility(isEdit && isVis ? View.VISIBLE : View.INVISIBLE);
            }
        }

    }

    public int getMyChannelSize() {
        int size = 0;
        for (int i = 0; i < mData.size(); i++) {
            Channel channel = mData.get(i);
            if (channel.getItemType() == Channel.TYPE_MY_CHANNEL) {
                size++;
            }
        }
        Log.i(TAG, "getMyChannelSize: size-->"+size);

        return size;
    }
}
