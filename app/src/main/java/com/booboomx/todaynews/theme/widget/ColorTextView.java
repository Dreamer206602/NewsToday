package com.booboomx.todaynews.theme.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.booboomx.todaynews.theme.ColorUiInterface;
import com.booboomx.todaynews.theme.util.ViewAttributeUtil;


/**
 * Created by chengli on 15/6/8.
 */
public class ColorTextView extends TextView implements ColorUiInterface {

    private int attr_drawable = -1;
    private int attr_textAppearance = -1;
    private int attr_textColor = -1;

    public ColorTextView(Context context) {
        this(context, null);
    }

    public ColorTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs != null) {
//        this.attr_textAppearance = ViewAttributeUtil.getTextApperanceAttribute(attrs);
            this.attr_drawable = ViewAttributeUtil.getBackgroundAttibute(attrs);
            this.attr_textColor = ViewAttributeUtil.getTextColorAttribute(attrs);
            changeBackground();
        }
    }

    private void changeBackground() {
        if (attr_drawable > 0) {
            int resource = ViewAttributeUtil.createResource(getResources(), attr_drawable);
            if (resource == 0) return;
            setBackgroundResource(resource);
        }
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setTheme(Resources.Theme themeId) {
        Log.d("COLOR", "id = " + getId());
        changeBackground();
//        if (attr_drawable != -1) {
//            ViewAttributeUtil.applyBackgroundDrawable(this, themeId, attr_drawable);
//        }
//        if(attr_textAppearance != -1) {
//            ViewAttributeUtil.applyTextAppearance(this, themeId, attr_textAppearance);
//        }
        if (attr_textColor != -1) {
            ViewAttributeUtil.applyTextColor(this, themeId, attr_textColor);
        }
    }
}
