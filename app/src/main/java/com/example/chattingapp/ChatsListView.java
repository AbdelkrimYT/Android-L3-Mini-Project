package com.example.chattingapp;

public class ChatsListView {

    private String name;
    private int circleImageViewRC;
    private String message;
    private String time;

    public ChatsListView(String name, int circleImageViewRC, String message, String time) {
        this.name = name;
        this.circleImageViewRC = circleImageViewRC;
        this.message = message;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return circleImageViewRC;
    }

    public void setImage(int circleImageViewRC) {
        this.circleImageViewRC = circleImageViewRC;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
