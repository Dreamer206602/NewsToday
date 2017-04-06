package com.booboomx.todaynews.ui.adapter;

import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.booboomx.todaynews.R;
import com.booboomx.todaynews.model.NewsBean;
import com.booboomx.todaynews.model.Video;
import com.booboomx.todaynews.utils.ImageLoaderUtils;
import com.booboomx.todaynews.utils.VideoPathDecoder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by booboomx on 17/4/6.
 */

public class VideoAdapter extends BaseQuickAdapter<NewsBean,BaseViewHolder>{

    public static final String TAG="VideoAdapter";
    public VideoAdapter(List<NewsBean> data) {
        super(R.layout.item_video,data);
    }

    @Override
    protected void convert(BaseViewHolder holder, final NewsBean item) {

        String media_avatar_url = item.getMedia_avatar_url();
        String source = item.getSource();
        String image_url = item.getImage_url();
        int comments_count = item.getComments_count();
        String title = item.getTitle();
        if(!TextUtils.isEmpty(media_avatar_url)){
            ImageLoaderUtils.loadeCircleImage(mContext,media_avatar_url, (ImageView) holder.getView(R.id.ivAvatar));
        }

        holder.setText(R.id.tvFrom,source)
                .setText(R.id.tvCommentCount,comments_count+"");

        final JCVideoPlayerStandard videoPlayer = holder.getView(R.id.videoPlayer);

        videoPlayer.titleTextView.setText(title);

        if(!TextUtils.isEmpty(image_url)){
            ImageLoaderUtils.loadImge(mContext,image_url,videoPlayer.thumbImageView);
        }

//                videoPlayer.setDurationText(video_duration_str);
        if (item.video == null) {
            //由于地址加密，所以抽出一个类专门解析播放地址
            VideoPathDecoder decoder = new VideoPathDecoder() {
                @Override
                public void onSuccess(Video s) {
                    item.video = s;
                    setPlayer(videoPlayer, item);
                }

                @Override
                public void onDecodeError(Throwable e) {

                }
            };
            decoder.decodePath(item.source_url);
        } else {
            setPlayer(videoPlayer, item);
        }



    }


    private void setPlayer(JCVideoPlayerStandard videoPlayer, NewsBean news) {
        Log.i(TAG, "setPlayer: "+news.video.main_url);
        videoPlayer.setUp(news.video.main_url, JCVideoPlayer.SCREEN_LAYOUT_LIST, news.title);
    }


}
