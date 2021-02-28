package com.example.chattingapp;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendsListView {

    private String name;
    private int circleImageViewRC;

    public FriendsListView(String name, int rec) {
        this.name = name;
        this.circleImageViewRC = rec;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return circleImageViewRC;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int rec) {
        circleImageViewRC = rec;
    }

}
