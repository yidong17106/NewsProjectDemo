package com.example.projectdemo;

public class Item {

    private int iconId;
    private String iconName;


    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }


    public Item(int iconId, String iconName) {
        this.iconId = iconId;
        this.iconName = iconName;
    }



}
