package com.booboomx.todaynews.utils.GlideProgess;

/**
 * Created by booboomx on 17/4/7.
 */

public interface ProgressListener {

    void progress(long bytesRead, long contentLength, boolean done);

}
