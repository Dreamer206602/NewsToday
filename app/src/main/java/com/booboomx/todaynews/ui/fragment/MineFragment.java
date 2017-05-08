package com.booboomx.todaynews.ui.fragment;


import android.animation.Animator;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.base.BaseFragment;
import com.booboomx.todaynews.base.BasePresenter;
import com.booboomx.todaynews.model.Notice;
import com.booboomx.todaynews.theme.util.SharedPreferencesMgr;
import com.booboomx.todaynews.utils.ConstanceValue;
import com.booboomx.todaynews.utils.ImageLoaderUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 */
public class MineFragment extends BaseFragment {

    @BindView(R.id.iv_headView)
    ImageView mIvHeadView;

    @BindView(R.id.tv_theme)
    TextView mTvTheme;

    public static final String URL = "http://upload.jianshu.io/users/upload_avatars/1859948/497273cbba1d.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/120/h/120";

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_mine;
    }


    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void lazyFetchData() {
        super.lazyFetchData();

        ImageLoaderUtils.loadeCircleImage(getContext(), URL, mIvHeadView);


    }

    @OnClick(R.id.tv_theme)
    public void changeTheme(View view) {

        if (SharedPreferencesMgr.getInt(ConstanceValue.SP_THEME, ConstanceValue.THEME_LIGHT) == ConstanceValue.THEME_LIGHT) {
            SharedPreferencesMgr.setInt(ConstanceValue.SP_THEME, ConstanceValue.THEME_NIGHT);
            getActivity().setTheme(R.style.Theme_Night);

        } else {

            SharedPreferencesMgr.setInt(ConstanceValue.SP_THEME, ConstanceValue.THEME_LIGHT);
            getActivity().setTheme(R.style.Theme_Light);
        }

        final View rootView = getActivity().getWindow().getDecorView();

        if(Build.VERSION.SDK_INT>=14){
            rootView.setDrawingCacheEnabled(true);
            rootView.buildDrawingCache(true);

            final Bitmap localBitmap = Bitmap.createBitmap(rootView.getDrawingCache());

            rootView.setDrawingCacheEnabled(false);

            if (localBitmap != null&&rootView instanceof ViewGroup) {

                final View localView2=new View(getActivity());
                localView2.setBackgroundDrawable(new BitmapDrawable());

                ViewGroup.LayoutParams params=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

                ((ViewGroup)rootView).addView(localView2,params);

                localView2.animate().alpha(0)
                        .setDuration(400)
                        .setListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                                post(new Notice(ConstanceValue.MSG_TYPE_CHANGE_THEME));
                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {

                                ((ViewGroup)rootView).removeView(localView2);
                                localBitmap.recycle();

                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        }).start();

            }else{
                post(new Notice(ConstanceValue.MSG_TYPE_CHANGE_THEME));
            }



        }

    }
}
