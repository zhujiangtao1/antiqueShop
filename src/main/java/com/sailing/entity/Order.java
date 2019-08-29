package com.sailing.entity;

import java.util.Date;

public class Order {
    private String orderId;

    private String antId;

    private String baseinfo;

    private Double antPrice;
    private String sellerId;

    private String address;

    private String buyerId;

    private Date orderTime;

    private String orderStatus;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAntId() {
        return antId;
    }

    public void setAntId(String antId) {
        this.antId = antId;
    }

    public String getBaseinfo() {
        return baseinfo;
    }

    public void setBaseinfo(String baseinfo) {
        this.baseinfo = baseinfo;
    }

    public Double getAntPrice() {
        return antPrice;
    }

    public void setAntPrice(Double antPrice) {
        this.antPrice = antPrice;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order(String orderId, String antId, String baseinfo, Double antPrice, String sellerId, String address, String buyerId, Date orderTime, String orderStatus) {
        this.orderId = orderId;
        this.antId = antId;
        this.baseinfo = baseinfo;
        this.antPrice = antPrice;

        this.sellerId = sellerId;
        this.address = address;
        this.buyerId = buyerId;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", antId='" + antId + '\'' +
                ", baseinfo='" + baseinfo + '\'' +
                ", antPrice=" + antPrice +
                ", sellerId='" + sellerId + '\'' +
                ", address='" + address + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", orderTime=" + orderTime +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}