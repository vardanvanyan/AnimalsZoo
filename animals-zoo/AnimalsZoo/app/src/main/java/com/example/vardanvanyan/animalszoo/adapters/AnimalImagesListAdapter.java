package com.example.vardanvanyan.animalszoo.adapters;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.activities.DetailActivity;
import com.example.vardanvanyan.animalszoo.fragments.SlideShowFragment;

import java.util.ArrayList;

public class AnimalImagesListAdapter extends
        RecyclerView.Adapter<AnimalImagesListAdapter.ImageViewHolder> {

    private Context context;
    private ArrayList<Drawable> images;

    public AnimalImagesListAdapter(Context context, ArrayList<Drawable> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public AnimalImagesListAdapter.ImageViewHolder onCreateViewHolder(ViewGroup parent,
                                                                              int viewType) {
        return new AnimalImagesListAdapter.ImageViewHolder(
                LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(AnimalImagesListAdapter.ImageViewHolder holder,
                                 int position) {
        holder.cardImage.setImageDrawable(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView cardImage;

        ImageViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.card_animal_image, parent, false));
            cardImage = itemView.findViewById(R.id.card_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("images", images);
                    bundle.putInt("position", 1);

                    FragmentTransaction ft = ((DetailActivity)context).getSupportFragmentManager().beginTransaction();
                    SlideShowFragment newFragment = SlideShowFragment.newInstance();
                    newFragment.setArguments(bundle);
                    newFragment.show(ft, "slideshow");
                }
            });
        }
    }
}
