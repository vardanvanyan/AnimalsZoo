package com.example.vardanvanyan.animalszoo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.adapters.AnimalsListAdapter;
import com.example.vardanvanyan.animalszoo.models.SingleAnimal;
import com.example.vardanvanyan.animalszoo.providers.AnimalsProvider;
import com.example.vardanvanyan.animalszoo.views.AnimalsListView;

import java.util.ArrayList;

public class AnimalsGridFragment extends Fragment implements AnimalsProvider.SingleAnimalsCallback {

    private View rootView;
    private int position;
    private AnimalsListView animalsListView;

    public AnimalsGridFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list, container, false);
        position = getArguments().getInt(AnimalsListAdapter.ANIMAL_TYPE_POSITION);
        final AnimalsProvider animalsProvider = new AnimalsProvider();
        animalsProvider.loadSingleAnimals(this, rootView.getContext(), position);
        animalsListView = new AnimalsListView(rootView);
        return rootView;
    }

    @Override
    public void onSingleAnimalsLoaded(ArrayList<SingleAnimal> singleAnimals) {
        animalsListView.loadAnimals(getContext(), singleAnimals, position);
    }
}
