package com.example.vardanvanyan.animalszoo.models;


import android.graphics.drawable.Drawable;

public class Event {

    private String title;
    private Drawable image;
    private String description;
    private String date;

    public Event() {
    }

    public Event(String title, Drawable image, String description, String date) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
