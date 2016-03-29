package com.hrt.domain;

public class Attend {
    private String ac_id;
    private String us_id;
    private String name;
    private String choices;

    public Attend(String ac_id,String us_id,String name,String choices){
        this.ac_id = ac_id;
        this.us_id = us_id;
        this.name = name;
        this.choices = choices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChoices(){return choices;}

    public void setChoices(String choices) {this.choices = choices;}

    public String getAc_id() {
        return ac_id;
    }

    public void setAc_id(String ac_id) {
        this.ac_id = ac_id;
    }

    public String getUs_id() {
        return us_id;
    }

    public void setUs_id(String us_id) {
        this.us_id = us_id;
    }
}
