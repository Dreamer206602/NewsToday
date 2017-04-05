package com.booboomx.todaynews.ui.view;

import com.booboomx.todaynews.model.NewsBean;

import java.util.List;

/**
 * Created by booboomx on 17/4/4.
 */

public interface NewListView {

    void onGetNewsListSuccess(List<NewsBean>dataBeanList);

}
