package com.booboomx.todaynews.model;

import com.booboomx.todaynews.utils.ConstanceValue;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by booboomx on 17/4/5.
 */

public class NewsBean  implements MultiItemEntity {
    public static final int ARTICLE_NO_IMAGE = 0;
    public static final int ARTICLE_IMAGE = 1;


    public static final int GALLERY_IMGE = 2;
    public static final int GALLERY_NO_IMAGE = 3;
    public static final int VIDEO = 4;


    /**
     * chinese_tag : 体育
     * media_avatar_url : http://p3.pstatp.com/large/bc2000a3611645791f7
     * article_genre : article
     * tag_url : news_sports
     * title : 13岁日本籍华裔立誓击败中国夺奥运金牌，来中国被打到怀疑人生
     * middle_mode : false
     * gallary_image_count : 5
     * image_list : [{"url":"http://p2.pstatp.com/list/ef5000fa3ce130815bc"},{"url":"http://p9.pstatp.com/list/ef5000fa3f737996347"},{"url":"http://p3.pstatp.com/list/e59000f7ce3e08668b6"}]
     * behot_time : 1479438367
     * source_url : /group/6351937181648732418/
     * source : 苏老湿聊体育
     * more_mode : true
     * is_feed_ad : false
     * comments_count : 9000
     * has_gallery : false
     * single_mode : true
     * image_url : http://p2.pstatp.com/list/190x124/ef5000fa3ce130815bc
     * group_id : 6351937181648732418
     * is_diversion_page : false
     * media_url : http://toutiao.com/m50282400523/
     */

    public String chinese_tag;
    public String media_avatar_url;
    public String article_genre;
    public String tag_url;
    public String title;
    public boolean middle_mode;
    public int gallary_image_count;
    public long behot_time;
    public String source_url;
    public String source;
    public boolean more_mode;
    public boolean is_feed_ad;
    public int comments_count;
    public boolean has_gallery;
    public boolean single_mode;
    public String image_url;
    public String group_id;
    public boolean is_diversion_page;
    public String media_url;
    public String video_duration_str;
    public Video video;
    public List<ImageUrl> image_list;

//    @Override
//    public String toString() {
//        return "News{" +
//                "chinese_tag='" + chinese_tag + '\'' +
//                ", media_avatar_url='" + media_avatar_url + '\'' +
//                ", article_genre='" + article_genre + '\'' +
//                ", tag_url='" + tag_url + '\'' +
//                ", title='" + title + '\'' +
//                ", middle_mode=" + middle_mode +
//                ", gallary_image_count=" + gallary_image_count +
//                ", behot_time=" + behot_time +
//                ", source_url='" + source_url + '\'' +
//                ", source='" + source + '\'' +
//                ", more_mode=" + more_mode +
//                ", is_feed_ad=" + is_feed_ad +
//                ", comments_count=" + comments_count +
//                ", has_gallery=" + has_gallery +
//                ", single_mode=" + single_mode +
//                ", image_url='" + image_url + '\'' +
//                ", group_id='" + group_id + '\'' +
//                ", is_diversion_page=" + is_diversion_page +
//                ", media_url='" + media_url + '\'' +
//                ", video_duration_str='" + video_duration_str + '\'' +
//                ", video=" + video +
//                ", image_list=" + image_list +
//                '}';
//    }




    public String getChinese_tag() {
        return chinese_tag;
    }

    public void setChinese_tag(String chinese_tag) {
        this.chinese_tag = chinese_tag;
    }

    public String getMedia_avatar_url() {
        return media_avatar_url;
    }

    public void setMedia_avatar_url(String media_avatar_url) {
        this.media_avatar_url = media_avatar_url;
    }

    public String getArticle_genre() {
        return article_genre;
    }

    public void setArticle_genre(String article_genre) {
        this.article_genre = article_genre;
    }

    public String getTag_url() {
        return tag_url;
    }

    public void setTag_url(String tag_url) {
        this.tag_url = tag_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isMiddle_mode() {
        return middle_mode;
    }

    public void setMiddle_mode(boolean middle_mode) {
        this.middle_mode = middle_mode;
    }

    public int getGallary_image_count() {
        return gallary_image_count;
    }

    public void setGallary_image_count(int gallary_image_count) {
        this.gallary_image_count = gallary_image_count;
    }

    public long getBehot_time() {
        return behot_time;
    }

    public void setBehot_time(long behot_time) {
        this.behot_time = behot_time;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isMore_mode() {
        return more_mode;
    }

    public void setMore_mode(boolean more_mode) {
        this.more_mode = more_mode;
    }

    public boolean is_feed_ad() {
        return is_feed_ad;
    }

    public void setIs_feed_ad(boolean is_feed_ad) {
        this.is_feed_ad = is_feed_ad;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public boolean isHas_gallery() {
        return has_gallery;
    }

    public void setHas_gallery(boolean has_gallery) {
        this.has_gallery = has_gallery;
    }

    public boolean isSingle_mode() {
        return single_mode;
    }

    public void setSingle_mode(boolean single_mode) {
        this.single_mode = single_mode;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public boolean is_diversion_page() {
        return is_diversion_page;
    }

    public void setIs_diversion_page(boolean is_diversion_page) {
        this.is_diversion_page = is_diversion_page;
    }

    public String getMedia_url() {
        return media_url;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }

    public String getVideo_duration_str() {
        return video_duration_str;
    }

    public void setVideo_duration_str(String video_duration_str) {
        this.video_duration_str = video_duration_str;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public List<ImageUrl> getImage_list() {
        return image_list;
    }

    public void setImage_list(List<ImageUrl> image_list) {
        this.image_list = image_list;
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
}


