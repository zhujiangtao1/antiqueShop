package com.sailing.entity.Vo;

import com.sailing.entity.AntiqueInfo;
import com.sailing.entity.Fav;

public class PicFavAntiqueInfoVo {
     Fav fav;
     AntiqueInfo antiqueInfo;
      String pic_url;

    public Fav getFav() {
        return fav;
    }

    public void setFav(Fav fav) {
        this.fav = fav;
    }

    public AntiqueInfo getAntiqueInfo() {
        return antiqueInfo;
    }

    public void setAntiqueInfo(AntiqueInfo antiqueInfo) {
        this.antiqueInfo = antiqueInfo;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    @Override
    public String toString() {
        return "PicFavAntiqueInfoVo{" +
                "fav=" + fav +
                ", antiqueInfo=" + antiqueInfo +
                ", pic_url='" + pic_url + '\'' +
                '}';
    }
}
