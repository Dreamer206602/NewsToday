package com.booboomx.todaynews.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.booboomx.todaynews.utils.ConstanceValue;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by booboomx on 17/4/4.
 */

public class News implements Parcelable {


    private boolean has_more;
    private String message;
    private List<DataBean> data;

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }


    public static class DataBean implements MultiItemEntity {

        public static final int ARTICLE_NO_IMAGE = 0;
        public static final int ARTICLE_IMAGE = 1;

        public static final int GALLERY_IMGE = 2;
        public static final int GALLERY_NO_IMAGE = 3;
        public static final int VIDEO = 4;


        /**
         * middle_mode : false
         * tag_url : news_world
         * has_gallery : false
         * hot : 1
         * source : 澎湃新闻
         * title : 俄宣布10死50伤地铁爆炸案系恐怖袭击，克宫否认普京座驾原本将经过
         * media_avatar_url : http://p3.pstatp.com/large/c080012f1f1a2f94e13
         * single_mode : false
         * source_url : /group/6404774044046311681/
         * group_id : 6404774044046311681
         * article_genre : article
         * behot_time : 1491229475
         * chinese_tag : 国际
         * is_diversion_page : false
         * more_mode : false
         * is_feed_ad : false
         * image_url : http://p3.pstatp.com/list/190x124/19ed0002d65a4e64ac81
         * comments_count : 10222
         * video_duration_str : 03:29
         * has_video : true
         * media_url : http://toutiao.com/m6637886761/
         * item_id : 6394582359307452673
         * display_title :
         * publish_time : 1488854726
         * tag_id : 6394582359307452673
         * image_list : []
         * id : 6394582359307452673
         * display_info : 本地的你再忙也要加一下这个投资微信！不然后悔
         * is_digg : 0
         * impression_count : 12682593
         * ad : {"log_extra":"{\"rit\":1,\"ad_price\":\"WOJbIwANWYxY4lsjAA1ZjNX37Esye5_Sd_VBBw\",\"req_id\":\"74290788491229475218\"}"}
         * recommend : 0
         * preload_web : 0
         * middle_image : {"height":150,"url_list":[{"url":"http://p1.pstatp.com/large/f2000062aabdd9e4810"},{"url":"http://pb3.pstatp.com/large/f2000062aabdd9e4810"},{"url":"http://pb3.pstatp.com/large/f2000062aabdd9e4810"}],"url":"http://p1.pstatp.com/large/f2000062aabdd9e4810","width":228,"uri":"large/f2000062aabdd9e4810"}
         * item_seo_url : /item/6394582359307452673/
         * large_image_list : []
         * display_url : http://win.95049.net/web2/jrtt20161107/index.html?bid=110197
         * log_extra : {"rit": 1, "ad_price": "WOJbIwAEKM5Y4lsjAAQozp3Uf1SyiCCIPCZwcw", "req_id": "74290788491229475218", "convert_id": 0}
         * url : http://win.95049.net/web2/jrtt20161107/index.html?bid=110197
         * repin_count : 5
         * digg_count : 0
         * has_m3u8_video : 0
         * datetime : 2017-04-03 21:54
         * comment_count : 0
         * go_detail_count : 211283
         * display_time : 1488854726
         * favorite_count : 5
         * ad_click_track_url_list : []
         * ad_label : 广告
         * is_favorite : 0
         * create_time : 1488854726
         * natant_level : 2
         * ad_id : 57281792995
         * external_visit_count : 61459
         * ad_track_url :
         * share_url : http://toutiao.com/group/6394582359307452673/?iid=57332024097&app=news_article
         * bury_count : 0
         * article_sub_type : 0
         * tag : ad
         * group_flags : 0
         * is_bury : 0
         * item_source_url : /item/6394582359307452673/
         * level : 0
         * ad_track_url_list : []
         * article_type : 1
         * seo_url : /group/6394582359307452673/
         * abstract :
         * keywords :
         * has_image : false
         * ad_click_track_url :
         * article_url : http://win.95049.net/web2/jrtt20161107/index.html?bid=110197
         * tips : 0
         * large_mode : false
         * gallary_image_count : 0
         * aggr_type : 1
         * has_mp4_video : 0
         * honey : true
         */

        private boolean middle_mode;
        private String tag_url;
        private boolean has_gallery;
        private int hot;
        private String source;
        private String title;
        private String media_avatar_url;
        private boolean single_mode;
        private String source_url;
        private String group_id;
        private String article_genre;
        private int behot_time;
        private String chinese_tag;
        private boolean is_diversion_page;
        private boolean more_mode;
        private boolean is_feed_ad;
        private String image_url;
        private int comments_count;
        private String video_duration_str;
        private boolean has_video;
        private String media_url;
        private long item_id;
        private String display_title;
        private int publish_time;
        private long tag_id;
        private long id;
        private String display_info;
        private int is_digg;
        private int impression_count;
        private AdBean ad;
        private int recommend;
        private int preload_web;
        private MiddleImageBean middle_image;
        private String item_seo_url;
        private String display_url;
        private String log_extra;
        private String url;
        private int repin_count;
        private int digg_count;
        private int has_m3u8_video;
        private String datetime;
        private int comment_count;
        private int go_detail_count;
        private int display_time;
        private int favorite_count;
        private String ad_label;
        private int is_favorite;
        private int create_time;
        private int natant_level;
        private long ad_id;
        private int external_visit_count;
        private String ad_track_url;
        private String share_url;
        private int bury_count;
        private int article_sub_type;
        private String tag;
        private int group_flags;
        private int is_bury;
        private String item_source_url;
        private int level;
        private int article_type;
        private String seo_url;
        @SerializedName("abstract")
        private String abstractX;
        private String keywords;
        private boolean has_image;
        private String ad_click_track_url;
        private String article_url;
        private int tips;
        private boolean large_mode;
        private int gallary_image_count;
        private int aggr_type;
        private int has_mp4_video;
        private boolean honey;
        private List<?> image_list;
        private List<?> large_image_list;
        private List<?> ad_click_track_url_list;
        private List<?> ad_track_url_list;

        public boolean isMiddle_mode() {
            return middle_mode;
        }

        public void setMiddle_mode(boolean middle_mode) {
            this.middle_mode = middle_mode;
        }

        public String getTag_url() {
            return tag_url;
        }

        public void setTag_url(String tag_url) {
            this.tag_url = tag_url;
        }

        public boolean isHas_gallery() {
            return has_gallery;
        }

        public void setHas_gallery(boolean has_gallery) {
            this.has_gallery = has_gallery;
        }

        public int getHot() {
            return hot;
        }

        public void setHot(int hot) {
            this.hot = hot;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMedia_avatar_url() {
            return media_avatar_url;
        }

        public void setMedia_avatar_url(String media_avatar_url) {
            this.media_avatar_url = media_avatar_url;
        }

        public boolean isSingle_mode() {
            return single_mode;
        }

        public void setSingle_mode(boolean single_mode) {
            this.single_mode = single_mode;
        }

        public String getSource_url() {
            return source_url;
        }

        public void setSource_url(String source_url) {
            this.source_url = source_url;
        }

        public String getGroup_id() {
            return group_id;
        }

        public void setGroup_id(String group_id) {
            this.group_id = group_id;
        }

        public String getArticle_genre() {
            return article_genre;
        }

        public void setArticle_genre(String article_genre) {
            this.article_genre = article_genre;
        }

        public int getBehot_time() {
            return behot_time;
        }

        public void setBehot_time(int behot_time) {
            this.behot_time = behot_time;
        }

        public String getChinese_tag() {
            return chinese_tag;
        }

        public void setChinese_tag(String chinese_tag) {
            this.chinese_tag = chinese_tag;
        }

        public boolean isIs_diversion_page() {
            return is_diversion_page;
        }

        public void setIs_diversion_page(boolean is_diversion_page) {
            this.is_diversion_page = is_diversion_page;
        }

        public boolean isMore_mode() {
            return more_mode;
        }

        public void setMore_mode(boolean more_mode) {
            this.more_mode = more_mode;
        }

        public boolean isIs_feed_ad() {
            return is_feed_ad;
        }

        public void setIs_feed_ad(boolean is_feed_ad) {
            this.is_feed_ad = is_feed_ad;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public String getVideo_duration_str() {
            return video_duration_str;
        }

        public void setVideo_duration_str(String video_duration_str) {
            this.video_duration_str = video_duration_str;
        }

        public boolean isHas_video() {
            return has_video;
        }

        public void setHas_video(boolean has_video) {
            this.has_video = has_video;
        }

        public String getMedia_url() {
            return media_url;
        }

        public void setMedia_url(String media_url) {
            this.media_url = media_url;
        }

        public long getItem_id() {
            return item_id;
        }

        public void setItem_id(long item_id) {
            this.item_id = item_id;
        }

        public String getDisplay_title() {
            return display_title;
        }

        public void setDisplay_title(String display_title) {
            this.display_title = display_title;
        }

        public int getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(int publish_time) {
            this.publish_time = publish_time;
        }

        public long getTag_id() {
            return tag_id;
        }

        public void setTag_id(long tag_id) {
            this.tag_id = tag_id;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getDisplay_info() {
            return display_info;
        }

        public void setDisplay_info(String display_info) {
            this.display_info = display_info;
        }

        public int getIs_digg() {
            return is_digg;
        }

        public void setIs_digg(int is_digg) {
            this.is_digg = is_digg;
        }

        public int getImpression_count() {
            return impression_count;
        }

        public void setImpression_count(int impression_count) {
            this.impression_count = impression_count;
        }

        public AdBean getAd() {
            return ad;
        }

        public void setAd(AdBean ad) {
            this.ad = ad;
        }

        public int getRecommend() {
            return recommend;
        }

        public void setRecommend(int recommend) {
            this.recommend = recommend;
        }

        public int getPreload_web() {
            return preload_web;
        }

        public void setPreload_web(int preload_web) {
            this.preload_web = preload_web;
        }

        public MiddleImageBean getMiddle_image() {
            return middle_image;
        }

        public void setMiddle_image(MiddleImageBean middle_image) {
            this.middle_image = middle_image;
        }

        public String getItem_seo_url() {
            return item_seo_url;
        }

        public void setItem_seo_url(String item_seo_url) {
            this.item_seo_url = item_seo_url;
        }

        public String getDisplay_url() {
            return display_url;
        }

        public void setDisplay_url(String display_url) {
            this.display_url = display_url;
        }

        public String getLog_extra() {
            return log_extra;
        }

        public void setLog_extra(String log_extra) {
            this.log_extra = log_extra;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getRepin_count() {
            return repin_count;
        }

        public void setRepin_count(int repin_count) {
            this.repin_count = repin_count;
        }

        public int getDigg_count() {
            return digg_count;
        }

        public void setDigg_count(int digg_count) {
            this.digg_count = digg_count;
        }

        public int getHas_m3u8_video() {
            return has_m3u8_video;
        }

        public void setHas_m3u8_video(int has_m3u8_video) {
            this.has_m3u8_video = has_m3u8_video;
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public int getGo_detail_count() {
            return go_detail_count;
        }

        public void setGo_detail_count(int go_detail_count) {
            this.go_detail_count = go_detail_count;
        }

        public int getDisplay_time() {
            return display_time;
        }

        public void setDisplay_time(int display_time) {
            this.display_time = display_time;
        }

        public int getFavorite_count() {
            return favorite_count;
        }

        public void setFavorite_count(int favorite_count) {
            this.favorite_count = favorite_count;
        }

        public String getAd_label() {
            return ad_label;
        }

        public void setAd_label(String ad_label) {
            this.ad_label = ad_label;
        }

        public int getIs_favorite() {
            return is_favorite;
        }

        public void setIs_favorite(int is_favorite) {
            this.is_favorite = is_favorite;
        }

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
        }

        public int getNatant_level() {
            return natant_level;
        }

        public void setNatant_level(int natant_level) {
            this.natant_level = natant_level;
        }

        public long getAd_id() {
            return ad_id;
        }

        public void setAd_id(long ad_id) {
            this.ad_id = ad_id;
        }

        public int getExternal_visit_count() {
            return external_visit_count;
        }

        public void setExternal_visit_count(int external_visit_count) {
            this.external_visit_count = external_visit_count;
        }

        public String getAd_track_url() {
            return ad_track_url;
        }

        public void setAd_track_url(String ad_track_url) {
            this.ad_track_url = ad_track_url;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public int getBury_count() {
            return bury_count;
        }

        public void setBury_count(int bury_count) {
            this.bury_count = bury_count;
        }

        public int getArticle_sub_type() {
            return article_sub_type;
        }

        public void setArticle_sub_type(int article_sub_type) {
            this.article_sub_type = article_sub_type;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public int getGroup_flags() {
            return group_flags;
        }

        public void setGroup_flags(int group_flags) {
            this.group_flags = group_flags;
        }

        public int getIs_bury() {
            return is_bury;
        }

        public void setIs_bury(int is_bury) {
            this.is_bury = is_bury;
        }

        public String getItem_source_url() {
            return item_source_url;
        }

        public void setItem_source_url(String item_source_url) {
            this.item_source_url = item_source_url;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getArticle_type() {
            return article_type;
        }

        public void setArticle_type(int article_type) {
            this.article_type = article_type;
        }

        public String getSeo_url() {
            return seo_url;
        }

        public void setSeo_url(String seo_url) {
            this.seo_url = seo_url;
        }

        public String getAbstractX() {
            return abstractX;
        }

        public void setAbstractX(String abstractX) {
            this.abstractX = abstractX;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public boolean isHas_image() {
            return has_image;
        }

        public void setHas_image(boolean has_image) {
            this.has_image = has_image;
        }

        public String getAd_click_track_url() {
            return ad_click_track_url;
        }

        public void setAd_click_track_url(String ad_click_track_url) {
            this.ad_click_track_url = ad_click_track_url;
        }

        public String getArticle_url() {
            return article_url;
        }

        public void setArticle_url(String article_url) {
            this.article_url = article_url;
        }

        public int getTips() {
            return tips;
        }

        public void setTips(int tips) {
            this.tips = tips;
        }

        public boolean isLarge_mode() {
            return large_mode;
        }

        public void setLarge_mode(boolean large_mode) {
            this.large_mode = large_mode;
        }

        public int getGallary_image_count() {
            return gallary_image_count;
        }

        public void setGallary_image_count(int gallary_image_count) {
            this.gallary_image_count = gallary_image_count;
        }

        public int getAggr_type() {
            return aggr_type;
        }

        public void setAggr_type(int aggr_type) {
            this.aggr_type = aggr_type;
        }

        public int getHas_mp4_video() {
            return has_mp4_video;
        }

        public void setHas_mp4_video(int has_mp4_video) {
            this.has_mp4_video = has_mp4_video;
        }

        public boolean isHoney() {
            return honey;
        }

        public void setHoney(boolean honey) {
            this.honey = honey;
        }

        public List<?> getImage_list() {
            return image_list;
        }

        public void setImage_list(List<?> image_list) {
            this.image_list = image_list;
        }

        public List<?> getLarge_image_list() {
            return large_image_list;
        }

        public void setLarge_image_list(List<?> large_image_list) {
            this.large_image_list = large_image_list;
        }

        public List<?> getAd_click_track_url_list() {
            return ad_click_track_url_list;
        }

        public void setAd_click_track_url_list(List<?> ad_click_track_url_list) {
            this.ad_click_track_url_list = ad_click_track_url_list;
        }

        public List<?> getAd_track_url_list() {
            return ad_track_url_list;
        }

        public void setAd_track_url_list(List<?> ad_track_url_list) {
            this.ad_track_url_list = ad_track_url_list;
        }

        @Override
        public int getItemType() {

            if (article_genre.equals(ConstanceValue.ARTICLE_GENRE_ARTICLE)) {

                if (image_list == null || image_list.size() == 0) {
                    return ARTICLE_NO_IMAGE;
                } else {

                    return ARTICLE_IMAGE;
                }

            } else if (article_genre.equals(ConstanceValue.ARTICLE_GENRE_GALLERY)) {

                if (image_list == null || image_list.size() == 0) {
                    return GALLERY_NO_IMAGE;
                } else {
                    return GALLERY_IMGE;
                }

            } else if (article_genre.equals(ConstanceValue.ARTICLE_GENRE_VIDEO)) {

                return VIDEO;
            }


            return 0;

        }




        public static class AdBean {
            /**
             * log_extra : {"rit":1,"ad_price":"WOJbIwANWYxY4lsjAA1ZjNX37Esye5_Sd_VBBw","req_id":"74290788491229475218"}
             */

            private String log_extra;

            public String getLog_extra() {
                return log_extra;
            }

            public void setLog_extra(String log_extra) {
                this.log_extra = log_extra;
            }
        }

        public static class MiddleImageBean {


            private int height;
            private String url;
            private int width;
            private String uri;
            private List<UrlListBean> url_list;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public List<UrlListBean> getUrl_list() {
                return url_list;
            }

            public void setUrl_list(List<UrlListBean> url_list) {
                this.url_list = url_list;
            }

            public static class UrlListBean {

                private String url;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.has_more ? (byte) 1 : (byte) 0);
        dest.writeString(this.message);
        dest.writeList(this.data);
    }

    public News() {
    }

    protected News(Parcel in) {
        this.has_more = in.readByte() != 0;
        this.message = in.readString();
        this.data = new ArrayList<DataBean>();
        in.readList(this.data, DataBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<News> CREATOR = new Parcelable.Creator<News>() {
        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };
}
