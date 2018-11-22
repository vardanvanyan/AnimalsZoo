package com.example.vardanvanyan.animalszoo.views;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import android.view.View;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.activities.MainActivity;
import com.example.vardanvanyan.animalszoo.fragments.AnimalsFragment;
import com.example.vardanvanyan.animalszoo.fragments.EventsFragment;
import com.example.vardanvanyan.animalszoo.fragments.SettingsFragment;

public class MainView {

    private BottomNavigationView bottomNavigationView;
    private Fragment fragment;
    private FragmentManager fragmentManager;

    public MainView(View view, Activity activity) {
        this.bottomNavigationView = view.findViewById(R.id.bottom_navigation);
        fragmentManager = ((MainActivity)activity).getSupportFragmentManager();
    }

    public void loadDefaultFragment() {
        fragmentManager.beginTransaction().add(R.id.main_container, new AnimalsFragment()).commit();
    }

    public void loadBottomNavigationMenu() {
        bottomNavigationView.inflateMenu(R.menu.bottom_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.action_search:
                        fragment = new AnimalsFragment();
                        break;
                    case R.id.action_cart:
                        fragment = new EventsFragment();
                        break;
                    case R.id.action_hot_deals:
                        fragment = new SettingsFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit();
                return true;
            }
        });
    }


}
