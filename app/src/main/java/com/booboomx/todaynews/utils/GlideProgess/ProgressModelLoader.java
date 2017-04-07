package com.booboomx.todaynews.utils.GlideProgess;

import android.os.Handler;

import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.stream.StreamModelLoader;

import java.io.InputStream;

/**
 * Created by booboomx on 17/4/7.
 */

public class ProgressModelLoader implements StreamModelLoader<String> {

    private Handler handler;

    public ProgressModelLoader(Handler handler) {
        this.handler = handler;
    }

    @Override
    public DataFetcher<InputStream> getResourceFetcher(String model, int width, int height) {
        return new ProgressDataFetcher(model, handler);
    }

}
