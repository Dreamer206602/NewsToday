package com.booboomx.todaynews.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.base.BaseActivity;
import com.booboomx.todaynews.utils.ConstanceValue;
import com.booboomx.todaynews.widget.ProgressWebView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 新闻详情的界面
 */
public class NewsDetailActivity extends BaseActivity {

    public static final String TAG="NewsDetailActivity";

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.iv_share)
    ImageView mIvShare;
    @BindView(R.id.webView)
    ProgressWebView mWebView;


    private String title,url;


    @Override
    protected void setListener() {


    }

    @Override
    public void processLogic(Bundle savedInstanceState) {

        title=getIntent().getStringExtra(ConstanceValue.TITLE);
        url=getIntent().getStringExtra(ConstanceValue.URL);

        Log.i(TAG, "processLogic: "+url);
        if (title != null) {
            mTvTitle.setText(title);
        }


        mWebView.loadUrl(url);


    }


    @OnClick(R.id.iv_back)
    public void onClick(){
        this.finish();
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_news_detail;
    }

}
