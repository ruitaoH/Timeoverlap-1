package com.hrt.domain;

public class User {
    private String us_id;
    private String name;
    private String phone;

    public User(String us_id,String name,String phone){
        this.us_id = us_id;
        this.name = name;
        this.phone = phone;
    }

    public String getUs_id() {
        return us_id;
    }

    public void setUs_id(String us_id) {
        this.us_id = us_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

