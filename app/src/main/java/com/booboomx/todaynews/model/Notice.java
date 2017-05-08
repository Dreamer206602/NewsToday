package com.booboomx.todaynews.model;

/**
 * Created by booboomx on 17/5/8.
 */

public class Notice {
    public int type;
    public Object content;

    public Notice(int type) {
        this.type = type;
    }

    public Notice(int type, Object content) {
        this.type = type;
        this.content = content;
    }

    public Notice() {
    }
}
