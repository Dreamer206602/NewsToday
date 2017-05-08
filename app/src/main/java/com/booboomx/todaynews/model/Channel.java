package com.booboomx.todaynews.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by booboomx on 17/4/14.
 */

public class Channel implements MultiItemEntity {

    public static final int TYPE_MY = 1;
    public static final int TYPE_OTHER = 2;
    public static final int TYPE_MY_CHANNEL = 3;
    public static final int TYPE_OTHER_CHANNEL = 4;
    public String Title;

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public int itemType;

    public Channel( String title) {
        Title = title;
    }
    @Override
    public int getItemType() {
        if(Title.equals("我的频道")){
            setItemType(1);
            return itemType;
        }else if(Title.equals("其他频道")){
            setItemType(2);
            return itemType;
        }else if(Title.contains("推荐2")){
            setItemType(4);
            return itemType;
        }else{
            setItemType(3);
            return itemType;
        }
    }
}
