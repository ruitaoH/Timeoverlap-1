package com.hrt.domain;

import java.awt.*;

public class Activity {
    private String ac_id;
    private String subject;
    private String date;
    private float last;
    private String dead;
    private String us_id;
    private String place;
    private String ac_code;

    public Activity(String ac_id,String subject,String date,float last,String dead,String us_id,String place,String ac_code){
        this.ac_id = ac_id;
        this.subject = subject;
        this.date = date;
        this.last = last;
        this.dead = dead;
        this.us_id = us_id;
        this.place = place;
        this.ac_code = ac_code;
    }

    public String getAc_id() {
        return ac_id;
    }

    public void setAc_id(String ac_id) {
        this.ac_id = ac_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getLast() {
        return last;
    }

    public void setLast(float last) {
        this.last = last;
    }

    public String getDead() {
        return dead;
    }

    public void setDead(String dead) {
        this.dead = dead;
    }

    public String getUs_id() {
        return us_id;
    }

    public void setUs_id(String us_id) {
        this.us_id = us_id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAc_code() {
        return ac_code;
    }

    public void setAc_code(String ac_code) {
        this.ac_code = ac_code;
    }
}
