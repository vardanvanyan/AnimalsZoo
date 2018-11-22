package com.example.vardanvanyan.animalszoo.providers;


import android.content.Context;

import com.example.vardanvanyan.animalszoo.models.Event;
import com.example.vardanvanyan.animalszoo.tasks.LoadEventsTask;

import java.util.ArrayList;

public class EventsProvider {

    public void loadAnimalTypes(EventsProvider.EventsCallback callback, Context context) {
        new LoadEventsTask(callback, context).execute();
    }

    public interface EventsCallback {
        void onEventsLoaded(ArrayList<Event> animalTypes);
    }
}