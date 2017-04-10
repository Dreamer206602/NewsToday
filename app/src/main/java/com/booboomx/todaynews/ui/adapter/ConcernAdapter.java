package com.booboomx.todaynews.ui.adapter;

import com.booboomx.todaynews.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by booboomx on 17/4/10.
 */

public class ConcernAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public ConcernAdapter(List<String> data) {
        super(R.layout.item_concern,data);
    }

    @Override
    protected void convert(BaseViewHolder holder, String item) {

        holder.setText(R.id.tv_title,item);

    }
}
