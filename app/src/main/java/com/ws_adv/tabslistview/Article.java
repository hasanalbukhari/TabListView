package com.ws_adv.tabslistview;

/**
 * Created by appleuser on 8/3/15.
 */
public class Article {

    Article(){}

    private int imageUrl = 0;
    private String desc = "";

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDesc() {
        return desc;
    }

    public int getImageUrl() {
        return imageUrl;
    }
}
