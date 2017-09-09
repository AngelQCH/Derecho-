package com.arteyciencia.a2jqch.derechobolivia.model;

/**
 * Created by Personal Familiar on 27/06/2017.
 */

public class Picture {
    private int picture;
    private String userName;
    private String time;
    private String like_number="0 días";
    public Picture(int picture, String userName, String time, String like_number) {
        this.picture = picture;
        this.userName = userName;
        this.time = time;
        this.like_number = like_number;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLike_number() {
        return like_number;
    }

    public void setLike_number(String like_number) {
        this.like_number = like_number;
    }

}
