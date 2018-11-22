package com.example.vardanvanyan.animalszoo.tasks;


import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.models.SingleAnimal;
import com.example.vardanvanyan.animalszoo.providers.AnimalsProvider;

import java.util.ArrayList;

public class LoadAnimalDetailTask extends AsyncTask<Void, Void, SingleAnimal> {

    private static final int BASE_ANIMAL_TYPE_ANIMALS_ID = 2;
    private static final int DETAIL_ANIMAL_NAME_ID = 0;
    private static final int DETAIL_ANIMAL_IMAGE_ID = 1;
    private static final int DETAIL_ANIMAL_DESCRIPTION_ID = 2;
    private static final int SINGLE_ANIMAL_VIDEO_URL_ID = 3;
    private static final int SINGLE_ANIMAL_IMAGES_ARRAY_ID = 4;

    private AnimalsProvider.DetailAnimalCallback callback;
    private Context context;
    private int[] position;

    public LoadAnimalDetailTask(AnimalsProvider.DetailAnimalCallback callback, Context context,
            int[] position) {
        this.callback = callback;
        this.context = context;
        this.position = position;
    }

    @SuppressWarnings("ResourceType")
    @Override
    protected SingleAnimal doInBackground(Void... params) {
        Resources resources = context.getResources();
        TypedArray cardItems = resources.obtainTypedArray(R.array.card_items);
        TypedArray singleCardItem = resources.obtainTypedArray(
                cardItems.getResourceId(position[0], -1));
        TypedArray animals = resources.obtainTypedArray(
                singleCardItem.getResourceId(BASE_ANIMAL_TYPE_ANIMALS_ID, -1));
        final SingleAnimal singleAnimal = getAnimalDetail(resources, animals);
        singleCardItem.recycle();
        cardItems.recycle();
        return singleAnimal;
    }

    @Override
    protected void onPostExecute(SingleAnimal singleAnimal) {
        super.onPostExecute(singleAnimal);
        callback.onAnimalDetailLoaded(singleAnimal);
    }

    @SuppressWarnings("ResourceType")
    @NonNull
    private SingleAnimal getAnimalDetail(Resources resources, TypedArray animals) {
        TypedArray singleItem = resources.obtainTypedArray(animals.getResourceId(position[1], -1));
        final SingleAnimal singleAnimal = new SingleAnimal();
        singleAnimal.setName(singleItem.getString(DETAIL_ANIMAL_NAME_ID));
        singleAnimal.setImage(singleItem.getDrawable(DETAIL_ANIMAL_IMAGE_ID));
        singleAnimal.setDescription(singleItem.getString(DETAIL_ANIMAL_DESCRIPTION_ID));
        singleAnimal.setVideoUrl(singleItem.getString(SINGLE_ANIMAL_VIDEO_URL_ID));
        singleAnimal.setImages(getImagesArray(singleItem, resources));
        singleItem.recycle();
        animals.recycle();
        return singleAnimal;
    }

    @SuppressWarnings("ResourceType")
    private ArrayList<Drawable> getImagesArray(TypedArray singleItem, Resources resources) {
        TypedArray imagesArray = resources.obtainTypedArray(singleItem.getResourceId(
                SINGLE_ANIMAL_IMAGES_ARRAY_ID, -1));
        final ArrayList<Drawable> images = new ArrayList<>();
        for (int j = 0; j < imagesArray.length(); j++) {
            int resId = imagesArray.getResourceId(j, -1);
            if (resId < 0) {
                continue;
            }
            images.add(imagesArray.getDrawable(j));
        }
        imagesArray.recycle();
        return images;
    }
}
