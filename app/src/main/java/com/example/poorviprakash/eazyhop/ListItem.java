package com.example.poorviprakash.eazyhop;

import android.graphics.drawable.Drawable;

public class ListItem {

    private String head;
    private String desc;
    private int img;

    public ListItem(String head, String desc, int img) {
        this.img = img;
        this.head = head;
        this.desc = desc;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public int getImg() { return img; }
}
