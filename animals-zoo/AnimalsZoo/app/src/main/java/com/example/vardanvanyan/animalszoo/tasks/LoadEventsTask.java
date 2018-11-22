package com.example.vardanvanyan.animalszoo.tasks;


import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.AsyncTask;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.models.Event;
import com.example.vardanvanyan.animalszoo.providers.EventsProvider;

import java.util.ArrayList;

public class LoadEventsTask extends AsyncTask<Void, Void, ArrayList<Event>> {

    private static final int EVENT_NAME_ID = 0;
    private static final int EVENT_IMAGE_ID = 1;
    private static final int EVENT_DESCRIPTION_ID = 2;
    private static final int EVENT_DATE_ID = 3;

    private EventsProvider.EventsCallback callback;
    private Context context;

    public LoadEventsTask(EventsProvider.EventsCallback callback, Context context) {
        this.callback = callback;
        this.context = context;
    }

    @SuppressWarnings("ResourceType")
    @Override
    protected ArrayList<Event> doInBackground(Void... params) {
        Resources resources = context.getResources();
        TypedArray cardItems = resources.obtainTypedArray(R.array.events_items);
        TypedArray itemDef;
        ArrayList<Event> events = new ArrayList<>();
        for (int i = 0; i < cardItems.length(); i++) {
            int resId = cardItems.getResourceId(i, -1);
            if (resId < 0) {
                continue;
            }
            itemDef = resources.obtainTypedArray(resId);
            Event event = new Event();
            event.setTitle(itemDef.getString(EVENT_NAME_ID));
            event.setImage(itemDef.getDrawable(EVENT_IMAGE_ID));
            event.setDescription(itemDef.getString(EVENT_DESCRIPTION_ID));
            event.setDate(itemDef.getString(EVENT_DATE_ID));
            events.add(event);
            itemDef.recycle();
        }
        cardItems.recycle();
        return events;
    }

    @Override
    protected void onPostExecute(ArrayList<Event> events) {
        super.onPostExecute(events);
        callback.onEventsLoaded(events);
    }
}