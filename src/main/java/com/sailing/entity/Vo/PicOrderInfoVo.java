package com.sailing.entity.Vo;

import com.sailing.entity.Order;

public class PicOrderInfoVo {
    String pic_url;
    Order order;
    String phone;
    public PicOrderInfoVo(){}
    public PicOrderInfoVo(String pic_url,String phone,Order order){
        this.phone=phone;
        this.pic_url=pic_url;
        this.order=order;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "PicOrderInfoVo{" +
                "pic_url='" + pic_url + '\'' +
                ", order=" + order +
                ", phone='" + phone + '\'' +
                '}';
    }
}
