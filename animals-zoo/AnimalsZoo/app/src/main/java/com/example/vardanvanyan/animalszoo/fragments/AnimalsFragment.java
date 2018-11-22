package com.example.vardanvanyan.animalszoo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.models.BaseAnimal;
import com.example.vardanvanyan.animalszoo.providers.AnimalsProvider;
import com.example.vardanvanyan.animalszoo.views.AnimalsListView;

import java.util.ArrayList;

public class AnimalsFragment extends Fragment implements AnimalsProvider.AnimalsCallback {

    private AnimalsListView animalsListView;

    public AnimalsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        final AnimalsProvider animalsProvider = new AnimalsProvider();
        animalsProvider.loadAnimalTypes(this, rootView.getContext());
        animalsListView = new AnimalsListView(rootView);
        return rootView;
    }

    @Override
    public void onAnimalTypesLoaded(ArrayList<BaseAnimal> animalTypes) {
        animalsListView.loadAnimalTypesList(getContext(), animalTypes);
    }
}
