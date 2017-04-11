package com.booboomx.todaynews.ui.adapter;

import android.widget.ImageView;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.model.GankItemBean;
import com.booboomx.todaynews.utils.ImageLoaderUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by booboomx on 17/4/11.
 */

public class MeizhiAdapter  extends BaseQuickAdapter<GankItemBean,BaseViewHolder>{


    public MeizhiAdapter(List<GankItemBean> data) {
        super(R.layout.item_meizhi,data);
    }

    @Override
    protected void convert(BaseViewHolder holder, GankItemBean item) {


        ImageLoaderUtils.loadImge(mContext,item.getUrl(), (ImageView) holder.getView(R.id.iv_meizhi));

    }
}
