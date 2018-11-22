package com.example.vardanvanyan.animalszoo.views;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.activities.DetailActivity;
import com.example.vardanvanyan.animalszoo.adapters.AnimalImagesListAdapter;
import com.example.vardanvanyan.animalszoo.fragments.VideoDialogFragment;
import com.example.vardanvanyan.animalszoo.models.SingleAnimal;

import java.util.ArrayList;

public class AnimalDetailView {

    public static final String VIDEO_URL_KEY = "com.example.smbat_s.animalszoo.views.VIDEO_PARH";
    private static final String VIDEO_DIALOG_TAG = "dialog";

    private ImageView animalImage;
    private TextView animalName;
    private TextView animalDescription;
    private ImageView videoImageButton;
    private Toolbar toolbar;
    private RecyclerView recyclerView;


    public AnimalDetailView(View view) {
        this.animalImage = view.findViewById(R.id.bg_image);
        this.animalName = view.findViewById(R.id.animal_name);
        this.animalDescription = view.findViewById(R.id.animal_description);
        this.videoImageButton = view.findViewById(R.id.video_button);
        this.toolbar = view.findViewById(R.id.toolbar);
        this.recyclerView = view.findViewById(R.id.images_recycler_view);
    }

    public void loadAnimalDetail(final SingleAnimal animal, final Context context) {
        animalImage.setImageDrawable(animal.getImage());
        animalName.setText(animal.getName());
        animalDescription.setText(animal.getDescription());
        videoImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showVideoDialog((DetailActivity) context, animal);
            }
        });
    }

    public void setToolbar(Context context) {
        toolbar.setTitle("");
        ((DetailActivity)context).setSupportActionBar(toolbar);
        if(((DetailActivity)context).getSupportActionBar() != null) {
            ((DetailActivity)context).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void showVideoDialog(DetailActivity context, SingleAnimal animal) {
        FragmentTransaction ft = context.getSupportFragmentManager().beginTransaction();
        Fragment prev = context.getSupportFragmentManager().findFragmentByTag(VIDEO_DIALOG_TAG);
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        DialogFragment newFragment = new VideoDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(VIDEO_URL_KEY, animal.getVideoUrl());
        newFragment.setArguments(bundle);
        newFragment.show(ft, VIDEO_DIALOG_TAG);
    }

    public void loadImagesList(ArrayList<Drawable> images, Context context) {
        final AnimalImagesListAdapter adapter = new AnimalImagesListAdapter(context, images);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }
}
