package com.sailing.entity;

public class Pic  {
    private String picId;
    private String antid;
    private String picUrl;

public Pic(){}
public Pic(String picId,String antId,String picUrl){
    this.antid=antid;
    this.picId=picId;
    this.picUrl=picUrl;

}
    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public String getAntid() {
        return antid;
    }

    public void setAntid(String antid) {
        this.antid = antid;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        return "Pic{" +
                "picId='" + picId + '\'' +
                ", antid='" + antid + '\'' +
                ", picUrl='" + picUrl + '\'' +
                '}';
    }
}