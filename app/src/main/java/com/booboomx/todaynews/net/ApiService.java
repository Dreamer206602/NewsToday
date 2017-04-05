package com.booboomx.todaynews.net;

import com.booboomx.todaynews.model.NewsBean;
import com.booboomx.todaynews.model.ResultResponse;
import com.booboomx.todaynews.model.VideoModel;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by booboomx on 17/4/4.
 */

public interface ApiService {


    String HOST = "http://www.toutiao.com/";
    String API_SERVER_URL = HOST + "api/";

    String URL_ARTICLE_FEED = "article/feed/";
    String URL_COMMENT_LIST = "comment/list/";
    String HOST_VIDEO = "http://i.snssdk.com";
    String URL_VIDEO="/video/urls/v/1/toutiao/mp4/%s?r=%s";



    /**
     * 获取新闻数据列表
     */
    @GET(URL_ARTICLE_FEED + "?utm_source=toutiao&widen=1&max_behot_time_tmp=0&as=A1C528E25E76FB8&cp=582EC64FEBD84E1&max_behot_time=0")
    Observable<ResultResponse<List<NewsBean>>> getNews(@Query("category") String category);



    /**
     * 获取视频页的html代码
     */
    @GET
    Observable<String> getVideoHtml(@Url String url);


    /**
     * 获取视频数据json
     * @param url
     * @return
     */
    @GET
    Observable<ResultResponse<VideoModel>> getVideoData(@Url String url);


}
