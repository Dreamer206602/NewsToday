package com.booboomx.todaynews.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.base.BaseActivity;
import com.booboomx.todaynews.utils.ConstanceValue;
import com.booboomx.todaynews.utils.ImageLoaderUtils;

import butterknife.BindView;

public class ImageDownLoadActivity extends BaseActivity {

    @BindView(R.id.iv_image)
    ImageView mIvImage;

    private String image;
    @Override
    protected void setListener() {

    }

    @Override
    public void processLogic(Bundle savedInstanceState) {

        image=getIntent().getStringExtra(ConstanceValue.IMAGE);
        ImageLoaderUtils.loadImge(this,image,mIvImage);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_image_down_load;
    }
}
