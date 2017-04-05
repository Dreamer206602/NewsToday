package com.booboomx.todaynews.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.base.BaseActivity;
import com.booboomx.todaynews.utils.ImageLoaderUtils;
import com.booboomx.todaynews.utils.JumpUtils;
import com.booboomx.todaynews.widget.CountDownView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 欢迎页
 */
public class WelcomeActivity extends BaseActivity {


    @BindView(R.id.img_splash)
    ImageView mImgSplash;
    @BindView(R.id.countDownView)
    CountDownView mCountDownView;


    public static final String URL="http://www.3vsheji.com/uploads/allimg/151222/1F92594D_0.jpg";

    @Override
    protected void setListener() {

    }

    @Override
    public void processLogic(Bundle savedInstanceState) {

        mCountDownView.start();

        ImageLoaderUtils.loadImge(this,URL,mImgSplash);
        mCountDownView.setListener(new CountDownView.CountDownTimerListener() {
            @Override
            public void onStartCount() {

            }

            @Override
            public void onFinishCount() {
                JumpUtils.go2MainActivity(WelcomeActivity.this);
            }
        });



    }

    @OnClick(R.id.countDownView)
    public void Click(){
        JumpUtils.go2MainActivity(WelcomeActivity.this);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }


}
