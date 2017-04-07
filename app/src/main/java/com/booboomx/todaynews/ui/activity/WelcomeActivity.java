package com.booboomx.todaynews.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.utils.ImageLoaderUtils;
import com.booboomx.todaynews.utils.JumpUtils;
import com.booboomx.todaynews.widget.CountDownView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 欢迎页
 */
public class WelcomeActivity extends FragmentActivity {


    @BindView(R.id.img_splash)
    ImageView mImgSplash;
    @BindView(R.id.countDownView)
    CountDownView mCountDownView;


    private Unbinder mUnbinder;

    public static final String URL="http://www.3vsheji.com/uploads/allimg/151222/1F92594D_0.jpg";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.activity_welcome);
        mUnbinder=ButterKnife.bind(this);



        initView();

    }

    private void initView() {

        mCountDownView.start();

        ImageLoaderUtils.loadImge(this,URL,mImgSplash);
        mCountDownView.setListener(new CountDownView.CountDownTimerListener() {
            @Override
            public void onStartCount() {

            }

            @Override
            public void onFinishCount() {
                JumpUtils.go2MainActivity(WelcomeActivity.this);
                finish();
            }
        });

    }



    @OnClick(R.id.countDownView)
    public void Click(){
        JumpUtils.go2MainActivity(WelcomeActivity.this);
        finish();

    }


    @Override
    protected void onDestroy() {
        mUnbinder.unbind();
        super.onDestroy();

    }
}
