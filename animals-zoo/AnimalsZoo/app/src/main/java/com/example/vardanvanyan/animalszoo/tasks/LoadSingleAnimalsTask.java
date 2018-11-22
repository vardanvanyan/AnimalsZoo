package com.example.vardanvanyan.animalszoo.tasks;


import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.models.SingleAnimal;
import com.example.vardanvanyan.animalszoo.providers.AnimalsProvider;

import java.util.ArrayList;

public class LoadSingleAnimalsTask extends AsyncTask<Void, Void, ArrayList<SingleAnimal>> {

    private static final int BASE_ANIMAL_TYPE_ANIMALS_ID = 2;
    private static final int SINGLE_ANIMAL_NAME_ID = 0;
    private static final int SINGLE_ANIMAL_IMAGE_ID = 1;

    private AnimalsProvider.SingleAnimalsCallback callback;
    private Context context;
    private int position;

    public LoadSingleAnimalsTask(AnimalsProvider.SingleAnimalsCallback callback, Context context,
            int position) {
        this.callback = callback;
        this.context = context;
        this.position = position;
    }

    @SuppressWarnings("ResourceType")
    @Override
    protected ArrayList<SingleAnimal> doInBackground(Void... params) {
        Resources resources = context.getResources();
        TypedArray cardItems = resources.obtainTypedArray(R.array.card_items);
        TypedArray singleCardItem = resources.obtainTypedArray(cardItems.getResourceId(position, -1));
        TypedArray animals = resources.obtainTypedArray(
                singleCardItem.getResourceId(BASE_ANIMAL_TYPE_ANIMALS_ID, -1));
        final ArrayList<SingleAnimal> singleAnimals = getSingleAnimals(resources, animals);
        singleCardItem.recycle();
        cardItems.recycle();
        return singleAnimals;
    }

    @Override
    protected void onPostExecute(ArrayList<SingleAnimal> singleAnimals) {
        super.onPostExecute(singleAnimals);
        callback.onSingleAnimalsLoaded(singleAnimals);
    }

    @SuppressWarnings("ResourceType")
    @NonNull
    private ArrayList<SingleAnimal> getSingleAnimals(Resources resources, TypedArray animals) {
        TypedArray singleItem;
        final ArrayList<SingleAnimal> singleAnimals = new ArrayList<>();
        for (int j = 0; j < animals.length(); j++) {
            int resId = animals.getResourceId(j, -1);
            if (resId < 0) {
                continue;
            }
            singleItem = resources.obtainTypedArray(resId);
            final SingleAnimal singleAnimal = new SingleAnimal();
            singleAnimal.setName(singleItem.getString(SINGLE_ANIMAL_NAME_ID));
            singleAnimal.setImage(singleItem.getDrawable(SINGLE_ANIMAL_IMAGE_ID));
            singleAnimals.add(singleAnimal);
            singleItem.recycle();
        }
        animals.recycle();
        return singleAnimals;
    }
}