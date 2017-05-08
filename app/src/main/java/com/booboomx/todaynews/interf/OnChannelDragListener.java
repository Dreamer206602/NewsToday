package com.booboomx.todaynews.interf;

import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by booboomx on 17/4/14.
 */

public interface OnChannelDragListener {

    void onStartDrag(BaseViewHolder baseViewHolder);

    void onItemMove(int startPos,int endPos);
}
