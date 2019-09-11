package com.example.bsmallah.myapplication;

public class Post {
    private  int id;
    private int userId;
    private String body;

    public Post(int userId, String body, String title) {
        this.userId = userId;
        this.body = body;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    private String title;

}
