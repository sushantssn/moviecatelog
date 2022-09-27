package com.movie.catelog.demo.pojo;

public class CatelogItem {

    private String name;
    private String desc;
    private int rating;

    public CatelogItem(String name, String desc, int rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }
    public CatelogItem(){}

    public String getName() {
        return name;
    }


    public String getDesc() {
        return desc;
    }

    public int getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
