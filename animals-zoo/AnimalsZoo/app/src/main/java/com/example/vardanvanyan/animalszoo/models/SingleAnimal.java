package com.example.vardanvanyan.animalszoo.models;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class SingleAnimal {

    private String name;
    private Drawable image;
    private String description;
    private String videoUrl;
    private ArrayList<Drawable> images;

    public SingleAnimal() {
    }

    public SingleAnimal(String name, Drawable image, String description,
                        String videoUrl, ArrayList<Drawable> images) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.videoUrl = videoUrl;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public ArrayList<Drawable> getImages() {
        return images;
    }

    public void setImages(ArrayList<Drawable> images) {
        this.images = images;
    }
}
