package com.sailing.entity;


import java.util.Date;

public class History {
    private String historyId;

    private String buyerId;

    private String antId;

    private String sellerId;

    private String Baseinfo;

    private String Address;

    private Date orderTime;

    private  String pic_url;

    private  Double price;

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getAntId() {
        return antId;
    }

    public void setAntId(String antId) {
        this.antId = antId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getBaseinfo() {
        return Baseinfo;
    }

    public void setBaseinfo(String baseinfo) {
        Baseinfo = baseinfo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "History{" +
                "historyId='" + historyId + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", antId='" + antId + '\'' +
                ", sellerId='" + sellerId + '\'' +
                ", Baseinfo='" + Baseinfo + '\'' +
                ", Address='" + Address + '\'' +
                ", orderTime=" + orderTime +
                ", pic_url='" + pic_url + '\'' +
                ", price=" + price +
                '}';
    }
}