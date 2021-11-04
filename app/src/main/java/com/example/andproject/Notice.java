package com.example.andproject;

public class Notice {
    String title;
    String date;
    String teacher;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTeacher() { return teacher; }

    public void setTeacher(String teacher) { this.teacher = teacher; }

    public Notice(String title, String date, String teacher) {
        this.title = title;
        this.date = date;
        this.teacher = teacher;
    }
}
