package com.booboomx.todaynews.utils;

import com.booboomx.todaynews.app.BaseApplication;

import java.io.File;

/**
 * Created by booboomx on 17/4/4.
 */

public interface ConstanceValue {

    public static final String PATH_DATA = BaseApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + File.separator + "NetCache";

    String DATA = "data";
    String ARTICLE_GENRE_GALLERY = "gallery";
    String ARTICLE_GENRE_VIDEO = "video";
    String ARTICLE_GENRE_ARTICLE = "article";
    String URL = "url";
    String TITLE="title";
    String SP_THEME = "theme";
    String IMAGE="image";
    String WIDTH="width";
    String HEIGHT="height";
    String LEFT="left";
    String TOP="top";
    String TYPE="type";
    int THEME_LIGHT = 1;
    int THEME_NIGHT = 2;
    /**
     * 修改主题
     */
    int MSG_TYPE_CHANGE_THEME = 100;
}
