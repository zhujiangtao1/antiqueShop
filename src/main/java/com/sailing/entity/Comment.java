package com.sailing.entity;

import java.util.Date;

public class Comment {
    private int commentid;
    private String antid;
    private String uid;
    private String comment_test;
    private String username;
    private Date commentTime;

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public String getAntid() {
        return antid;
    }

    public void setAntid(String antid) {
        this.antid = antid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getComment_test() {
        return comment_test;
    }

    public void setComment_test(String comment_test) {
        this.comment_test = comment_test;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentid=" + commentid +
                ", antid='" + antid + '\'' +
                ", uid='" + uid + '\'' +
                ", comment_test='" + comment_test + '\'' +
                ", username='" + username + '\'' +
                ", commentTime=" + commentTime +
                '}';
    }
}
