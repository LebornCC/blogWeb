package com.bean;

public class Messages {

    int userId;
    String title;
    String message;
    String time;
    public Messages() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Messages(int userId,  String title,String time,String message) {
        super();
        this.userId = userId;
        this.title = title;
        this.time = time;
        this.message = message;
    }
    public int getId() {
        return userId;
    }
    public void setId(int userId) {
        this.userId = userId;
    }
    public String getTitle() { return title ;}
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTime() { return time ;}
    public void setTime(String time) { this.time = time; }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        String returnValue = "{\"title\":\""+title+"\",\"time\":\""+time+"\",\"message\":\""+message+"\"}";
        return returnValue;
    }
}
