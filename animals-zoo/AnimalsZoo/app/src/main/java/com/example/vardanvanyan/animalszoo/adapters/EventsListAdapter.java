package com.example.vardanvanyan.animalszoo.adapters;

import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.activities.MainActivity;
import com.example.vardanvanyan.animalszoo.fragments.TimePickerFragment;
import com.example.vardanvanyan.animalszoo.models.Event;

import java.util.ArrayList;

public class EventsListAdapter extends RecyclerView.Adapter<EventsListAdapter.EventViewHolder> {

    private Context context;
    private ArrayList<Event> events;

    public EventsListAdapter(Context context, ArrayList<Event> events) {
        this.context = context;
        this.events = events;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        holder.image.setImageDrawable(events.get(position).getImage());
        holder.title.setText(events.get(position).getTitle());
        holder.description.setText(events.get(position).getDescription());
        holder.date.setText(events.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    class EventViewHolder extends RecyclerView.ViewHolder {

        private static final String TIME_PICKER_TAG = "timePicker";

        private TextView title;
        private ImageView image;
        private TextView description;
        private Button date;
        private ImageButton timeButton;

        EventViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.event_card_item, parent, false));
            title = itemView.findViewById(R.id.card_title);
            description = itemView.findViewById(R.id.card_text);
            image = itemView.findViewById(R.id.card_image);
            date = itemView.findViewById(R.id.card_date);
            timeButton = itemView.findViewById(R.id.date_button);
            timeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogFragment newFragment = new TimePickerFragment();
                    newFragment.show(((MainActivity)context).getSupportFragmentManager(), TIME_PICKER_TAG);
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO
                }
            });
        }
    }
}
