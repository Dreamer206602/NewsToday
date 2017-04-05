package com.booboomx.todaynews.model;

/**
 * Created by booboomx on 17/4/5.
 */

public class Video {

    /**
     * backup_url_1 : aHR0cDovL3Y3LnBzdGF0cC5jb20vYmM0YmExYTk4MGY2OGY2NmQxMmM4Mjg2NjZhYjBmZDkvNTg5YzI4NGIvdmlkZW8vbS8xMTQzMDI2MDAwMDJkZTE5MTdiM2QwZDIyMDFhYWM1ZWFlYzI0YjQ5YTBiYjJhNGZiMDU1NWYzNWUzLw==
     * bitrate : 228992
     * definition : 360p
     * main_url : aHR0cDovL3YxLjM2NXlnLmNvbS8yMjAxYjhlYmVkZGJmY2MwYjg3MWQ0ZWNjMWM1OWE3ZC81ODljMjg0Yi92aWRlby9tLzExNDMwMjYwMDAwMmRlMTkxN2IzZDBkMjIwMWFhYzVlYWVjMjRiNDlhMGJiMmE0ZmIwNTU1ZjM1ZTMv
     * preload_interval : 25
     * preload_max_step : 10
     * preload_min_step : 5
     * preload_size : 327680
     * size : 8357746.0
     * socket_buffer : 1.373952E8
     * user_video_proxy : 1
     * vheight : 360
     * vtype : mp4
     * vwidth : 640
     */
    public String backup_url_1;
    public int bitrate;
    public String definition;
    public String main_url;
    public int preload_interval;
    public int preload_max_step;
    public int preload_min_step;
    public int preload_size;
    public double size;
    public double socket_buffer;
    public int user_video_proxy;
    public int vheight;
    public String vtype;
    public int vwidth;

    public String getBackup_url_1() {
        return backup_url_1;
    }

    public void setBackup_url_1(String backup_url_1) {
        this.backup_url_1 = backup_url_1;
    }

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getMain_url() {
        return main_url;
    }

    public void setMain_url(String main_url) {
        this.main_url = main_url;
    }

    public int getPreload_interval() {
        return preload_interval;
    }

    public void setPreload_interval(int preload_interval) {
        this.preload_interval = preload_interval;
    }

    public int getPreload_max_step() {
        return preload_max_step;
    }

    public void setPreload_max_step(int preload_max_step) {
        this.preload_max_step = preload_max_step;
    }

    public int getPreload_min_step() {
        return preload_min_step;
    }

    public void setPreload_min_step(int preload_min_step) {
        this.preload_min_step = preload_min_step;
    }

    public int getPreload_size() {
        return preload_size;
    }

    public void setPreload_size(int preload_size) {
        this.preload_size = preload_size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getSocket_buffer() {
        return socket_buffer;
    }

    public void setSocket_buffer(double socket_buffer) {
        this.socket_buffer = socket_buffer;
    }

    public int getUser_video_proxy() {
        return user_video_proxy;
    }

    public void setUser_video_proxy(int user_video_proxy) {
        this.user_video_proxy = user_video_proxy;
    }

    public int getVheight() {
        return vheight;
    }

    public void setVheight(int vheight) {
        this.vheight = vheight;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public int getVwidth() {
        return vwidth;
    }

    public void setVwidth(int vwidth) {
        this.vwidth = vwidth;
    }
    //    @Override
//    public String toString() {
//        return "Video{" +
//                "backup_url_1='" + backup_url_1 + '\'' +
//                ", bitrate=" + bitrate +
//                ", definition='" + definition + '\'' +
//                ", main_url='" + main_url + '\'' +
//                ", preload_interval=" + preload_interval +
//                ", preload_max_step=" + preload_max_step +
//                ", preload_min_step=" + preload_min_step +
//                ", preload_size=" + preload_size +
//                ", size=" + size +
//                ", socket_buffer=" + socket_buffer +
//                ", user_video_proxy=" + user_video_proxy +
//                ", vheight=" + vheight +
//                ", vtype='" + vtype + '\'' +
//                ", vwidth=" + vwidth +
//                '}';
//    }
}
