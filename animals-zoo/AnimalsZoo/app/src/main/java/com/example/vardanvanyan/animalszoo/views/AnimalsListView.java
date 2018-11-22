package com.example.vardanvanyan.animalszoo.views;


import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.adapters.AnimalsListAdapter;
import com.example.vardanvanyan.animalszoo.adapters.SingleAnimalsListAdapter;
import com.example.vardanvanyan.animalszoo.models.BaseAnimal;
import com.example.vardanvanyan.animalszoo.models.SingleAnimal;

import java.util.ArrayList;

public class AnimalsListView {

    private RecyclerView recyclerView;

    public AnimalsListView(View view) {
        this.recyclerView = view.findViewById(R.id.animal_types_recycler_view);
    }

    public void loadAnimalTypesList(Context context, ArrayList<BaseAnimal> animalTypes) {
        final AnimalsListAdapter adapter = new AnimalsListAdapter(context, animalTypes);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    public void loadAnimals(Context context, ArrayList<SingleAnimal> singleAnimals, int position) {
        final SingleAnimalsListAdapter adapter = new SingleAnimalsListAdapter(context,
                singleAnimals, position);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        int tilePadding = context.getResources().getDimensionPixelSize(R.dimen.tile_padding);
        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
    }
}
