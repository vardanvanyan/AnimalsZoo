package com.example.vardanvanyan.animalszoo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.models.Event;
import com.example.vardanvanyan.animalszoo.providers.EventsProvider;
import com.example.vardanvanyan.animalszoo.views.EventsListViw;

import java.util.ArrayList;

public class EventsFragment extends Fragment implements EventsProvider.EventsCallback {

    private EventsListViw eventsListViw;

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        final EventsProvider animalsProvider = new EventsProvider();
        animalsProvider.loadAnimalTypes(this, rootView.getContext());
        eventsListViw = new EventsListViw(rootView);
        return rootView;
    }

    @Override
    public void onEventsLoaded(ArrayList<Event> events) {
        eventsListViw.loadEventsList(getContext(), events);
    }
}
