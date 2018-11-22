package com.example.vardanvanyan.animalszoo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.views.MainView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MainView mainView = new MainView(getWindow().getDecorView(), this);
        mainView.loadDefaultFragment();
        mainView.loadBottomNavigationMenu();
    }
}
