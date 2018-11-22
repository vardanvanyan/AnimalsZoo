package com.example.vardanvanyan.animalszoo.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.activities.DetailActivity;
import com.example.vardanvanyan.animalszoo.activities.MainActivity;
import com.example.vardanvanyan.animalszoo.models.SingleAnimal;

import java.util.ArrayList;

public class SingleAnimalsListAdapter extends
        RecyclerView.Adapter<SingleAnimalsListAdapter.SingleAnimalViewHolder> {

    public static final String CURRENT_ITEM_POSITIONS =
            "com.example.smbat_s.animalszoo.adapters.currentPosition";

    private final Context context;
    private ArrayList<SingleAnimal> singleAnimals;
    private int position;

    public SingleAnimalsListAdapter(Context context, ArrayList<SingleAnimal> animalTypes,
            int position) {
        this.context = context;
        this.singleAnimals = animalTypes;
        this.position = position;
    }

    @Override
    public SingleAnimalsListAdapter.SingleAnimalViewHolder onCreateViewHolder(ViewGroup parent,
            int viewType) {
        return new SingleAnimalsListAdapter.SingleAnimalViewHolder(
                LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(SingleAnimalsListAdapter.SingleAnimalViewHolder holder,
            int position) {
        holder.singleItemImage.setImageDrawable(singleAnimals.get(position).getImage());
        holder.name.setText(singleAnimals.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return singleAnimals.size();
    }

    class SingleAnimalViewHolder extends RecyclerView.ViewHolder {

        private static final String IMAGE_TRANSITION_NAME = "animalImage";
        private static final String TEXT_TRANSITION_NAME = "animalName";

        private ImageView singleItemImage;
        private TextView name;

        SingleAnimalViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.single_animal_item, parent, false));
            singleItemImage = itemView.findViewById(R.id.single_image);
            name = itemView.findViewById(R.id.single_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    int[] args = {position, getAdapterPosition()};
                    intent.putExtra(CURRENT_ITEM_POSITIONS, args);
                    Pair<View, String> pair1 = Pair.create((View) singleItemImage, IMAGE_TRANSITION_NAME);
                    Pair<View, String> pair2 = Pair.create((View) name, TEXT_TRANSITION_NAME);
                    @SuppressWarnings("unchecked")
                    ActivityOptionsCompat optionsCompat =
                            ActivityOptionsCompat.makeSceneTransitionAnimation(
                                    (MainActivity) context, pair1, pair2);
                    context.startActivity(intent, optionsCompat.toBundle());
                }
            });
        }
    }
}
