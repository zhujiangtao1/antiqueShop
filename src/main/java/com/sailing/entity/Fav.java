package com.sailing.entity;

public class Fav {
    private String favid;
    private String uid;
    private String antId;

    @Override
    public String toString() {
        return "Fav{" +
                "favid='" + favid + '\'' +
                ", uid='" + uid + '\'' +
                ", antId='" + antId + '\'' +
                '}';
    }

    public Fav() {
    }

    public Fav(String favid, String uid, String antId) {
        this.favid=favid;
        this.uid = uid;
        this.antId = antId;
    }

    public String getFavid() {
        return favid;
    }

    public void setFav_id(String favid) {
        this.favid = favid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAntId() {
        return antId;
    }

    public void setAntId(String antId) {
        this.antId = antId;
    }
}