package com.example.vardanvanyan.animalszoo;


import android.app.Application;

import com.example.vardanvanyan.animalszoo.helpers.DataBaseHelper;

public class AnimalsZooApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataBaseHelper.initInstance(this);
    }
}
