package com.booboomx.todaynews.theme.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;

import com.booboomx.todaynews.theme.ColorUiInterface;
import com.booboomx.todaynews.theme.util.ViewAttributeUtil;


/**
 * Created by chengli on 15/6/8.
 */
public class ColorImageButton extends ImageButton implements ColorUiInterface {

    private int attr_drawable = -1;

    public ColorImageButton(Context context) {
        super(context);
    }

    public ColorImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.attr_drawable = ViewAttributeUtil.getSrcAttribute(attrs);
    }

    public ColorImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.attr_drawable = ViewAttributeUtil.getSrcAttribute(attrs);
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setTheme(Resources.Theme themeId) {
        if(attr_drawable != -1) {
            ViewAttributeUtil.applyBackgroundDrawable(this, themeId, attr_drawable);
        }
    }
}
