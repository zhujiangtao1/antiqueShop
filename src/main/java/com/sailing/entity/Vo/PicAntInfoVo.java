package com.sailing.entity.Vo;


import com.sailing.entity.AntiqueInfo;

public class PicAntInfoVo {
    String pic_url;
    AntiqueInfo antiqueInfo;

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public AntiqueInfo getAntiqueInfo() {
        return antiqueInfo;
    }

    public void setAntiqueInfo(AntiqueInfo antiqueInfo) {
        this.antiqueInfo = antiqueInfo;
    }

    @Override
    public String toString() {
        return "PicAntInfoVo{" +
                "pic_url='" + pic_url + '\'' +
                ", antiqueInfo=" + antiqueInfo +
                '}';
    }
}
