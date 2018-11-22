package com.example.vardanvanyan.animalszoo.tasks;


import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.AsyncTask;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.models.BaseAnimal;
import com.example.vardanvanyan.animalszoo.providers.AnimalsProvider;

import java.util.ArrayList;

public class LoadAnimalTypesTask extends AsyncTask<Void, Void, ArrayList<BaseAnimal>> {

    private static final int BASE_ANIMAL_TYPE_NAME_ID = 0;
    private static final int BASE_ANIMAL_TYPE_ICON_ID = 1;

    private AnimalsProvider.AnimalsCallback callback;
    private Context context;

    public LoadAnimalTypesTask(AnimalsProvider.AnimalsCallback callback, Context context) {
        this.callback = callback;
        this.context = context;
    }

    @SuppressWarnings("ResourceType")
    @Override
    protected ArrayList<BaseAnimal> doInBackground(Void... params) {
        Resources resources = context.getResources();
        TypedArray cardItems = resources.obtainTypedArray(R.array.card_items);
        TypedArray itemDef;
        ArrayList<BaseAnimal> animalTypes = new ArrayList<>();
        for (int i = 0; i < cardItems.length(); i++) {
            int resId = cardItems.getResourceId(i, -1);
            if (resId < 0) {
                continue;
            }
            itemDef = resources.obtainTypedArray(resId);
            BaseAnimal animal = new BaseAnimal();
            animal.setType(itemDef.getString(BASE_ANIMAL_TYPE_NAME_ID));
            animal.setIcon(itemDef.getDrawable(BASE_ANIMAL_TYPE_ICON_ID));
            animalTypes.add(animal);
            itemDef.recycle();
        }
        cardItems.recycle();
        return animalTypes;
    }

    @Override
    protected void onPostExecute(ArrayList<BaseAnimal> animalTypes) {
        super.onPostExecute(animalTypes);
        callback.onAnimalTypesLoaded(animalTypes);
    }
}