package com.example.vardanvanyan.animalszoo.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.activities.MainActivity;
import com.example.vardanvanyan.animalszoo.fragments.AnimalsGridFragment;
import com.example.vardanvanyan.animalszoo.models.BaseAnimal;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AnimalsListAdapter extends RecyclerView.Adapter<AnimalsListAdapter.AnimalTypeViewHolder> {

    private final Context context;
    private ArrayList<BaseAnimal> animalTypes;
    public static final String ANIMAL_TYPE_POSITION = "com.example.smbat_s.animalszoo.adapters.AnimalsListAdapter.ANIMAL_TYPE_POSITION";

    public AnimalsListAdapter(Context context, ArrayList<BaseAnimal> animalTypes) {
        this.context = context;
        this.animalTypes = animalTypes;
    }

    @Override
    public AnimalTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AnimalTypeViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(AnimalTypeViewHolder holder, int position) {
        holder.avatar.setImageDrawable(animalTypes.get(position).getIcon());
        holder.name.setText(animalTypes.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return animalTypes.size();
    }

    class AnimalTypeViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView avatar;
        private TextView name;

        AnimalTypeViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_list, parent, false));
            avatar = itemView.findViewById(R.id.list_avatar);
            name = itemView.findViewById(R.id.list_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AnimalsGridFragment fragment = new AnimalsGridFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt(ANIMAL_TYPE_POSITION, getAdapterPosition());
                    fragment.setArguments(bundle);
                    ((MainActivity)context).getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_container, fragment)
                            .addToBackStack(null)
                            .commit();
                }
            });
        }
    }
}
