package com.example.vardanvanyan.animalszoo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.adapters.SingleAnimalsListAdapter;
import com.example.vardanvanyan.animalszoo.models.SingleAnimal;
import com.example.vardanvanyan.animalszoo.providers.AnimalsProvider;
import com.example.vardanvanyan.animalszoo.views.AnimalDetailView;

public class DetailActivity extends AppCompatActivity implements
        AnimalsProvider.DetailAnimalCallback{

    private AnimalDetailView animalDetailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int[] args = getIntent().getIntArrayExtra(SingleAnimalsListAdapter.CURRENT_ITEM_POSITIONS);
        final AnimalsProvider animalsProvider = new AnimalsProvider();
        animalsProvider.loadAnimalDetail(this, this, args);
        animalDetailView = new AnimalDetailView(getWindow().getDecorView());
        animalDetailView.setToolbar(this);
    }

    @Override
    public void onAnimalDetailLoaded(SingleAnimal singleAnimal) {
        animalDetailView.loadAnimalDetail(singleAnimal, this);
        animalDetailView.loadImagesList(singleAnimal.getImages(), this);
    }
}