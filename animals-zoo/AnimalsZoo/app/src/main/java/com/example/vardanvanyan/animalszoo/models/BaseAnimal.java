package com.example.vardanvanyan.animalszoo.models;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class BaseAnimal {

    private String type;
    private Drawable icon;
    private ArrayList<SingleAnimal> animals;

    public BaseAnimal() {
    }

    public BaseAnimal(String type, Drawable icon,
            ArrayList<SingleAnimal> animals) {
        this.type = type;
        this.icon = icon;
        this.animals = animals;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public ArrayList<SingleAnimal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<SingleAnimal> animals) {
        this.animals = animals;
    }
}
