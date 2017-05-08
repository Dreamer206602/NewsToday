package com.booboomx.todaynews.widget;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.booboomx.todaynews.interf.OnChannelDragListener;

/**
 * Created by booboomx on 17/4/14.
 */

public class ItemDragHelperCallBack extends ItemTouchHelper.Callback {

    public ItemDragHelperCallBack(OnChannelDragListener onChannelDragListener) {
        this.mOnChannelDragListener = onChannelDragListener;
    }



    private OnChannelDragListener mOnChannelDragListener;

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();

        int dragFlags;

        if(manager instanceof GridLayoutManager || manager instanceof StaggeredGridLayoutManager){
            //监听上 下 左右
            dragFlags=ItemTouchHelper.UP|ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT|ItemTouchHelper.DOWN;
        }else{

            dragFlags=ItemTouchHelper.UP|ItemTouchHelper.DOWN;

        }

        return makeMovementFlags(dragFlags,0);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

        if(viewHolder.getItemViewType()!=target.getItemViewType()){
            return false;
        }

        if (mOnChannelDragListener != null)
            mOnChannelDragListener.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());

        return true;
    }


    @Override
    public boolean isLongPressDragEnabled() {
        //不需要长按拖动，因为我们的标题和 频道推荐 是不需要拖动的，所以手动控制
        return false;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        //不需要侧滑
        return false;
    }


    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }
}
