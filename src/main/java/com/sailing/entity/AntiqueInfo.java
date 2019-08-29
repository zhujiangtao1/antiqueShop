package com.sailing.entity;

public class AntiqueInfo {
    private String antId;
    private String years;
    private String category;
    private String antique_name;
    private double price;
    private String antique_damage;
    private String size;
    private String jian;
    private String islocked;
    private String address;
    private String uid;

    public AntiqueInfo(){

    }
    public AntiqueInfo( AntiqueInfo antiqueInfo){
        this.antId=antiqueInfo.getAntId();
        this.years=antiqueInfo.getYears();
        this.category=antiqueInfo.getCategory();
        this.antique_name=antiqueInfo.getAntique_name();
        this.price=antiqueInfo.getPrice();
        this.antique_damage=antiqueInfo.getAntique_damage();
        this.size=antiqueInfo.getSize();
        this.jian=antiqueInfo.getJian();
        this.islocked=antiqueInfo.getIslocked();
        this.address=antiqueInfo.getAddress();
        this.uid=antiqueInfo.getUid();

    }

    public String getAntId() {
        return antId;
    }

    public void setAntId(String antId) {
        this.antId = antId;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAntique_name() {
        return antique_name;
    }

    public void setAntique_name(String antique_name) {
        this.antique_name = antique_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAntique_damage() {
        return antique_damage;
    }

    public void setAntique_damage(String antique_damage) {
        this.antique_damage = antique_damage;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getJian() {
        return jian;
    }

    public void setJian(String jian) {
        this.jian = jian;
    }

    public String getIslocked() {
        return islocked;
    }

    public void setIslocked(String islocked) {
        this.islocked = islocked;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "AntiqueInfo{" +
                "antId='" + antId + '\'' +
                ", years='" + years + '\'' +
                ", category='" + category + '\'' +
                ", antique_name='" + antique_name + '\'' +
                ", price=" + price +
                ", antique_damage='" + antique_damage + '\'' +
                ", size='" + size + '\'' +
                ", jian='" + jian + '\'' +
                ", islocked='" + islocked + '\'' +
                ", address='" + address + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}