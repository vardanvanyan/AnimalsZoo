package com.example.vardanvanyan.animalszoo.adapters;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.vardanvanyan.animalszoo.R;

import java.util.ArrayList;

public class MyViewPagerAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<Drawable> images;

    public MyViewPagerAdapter(Context context, ArrayList<Drawable> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.image_fullscreen_preview, container, false);

        ImageView imageViewPreview = view.findViewById(R.id.image_preview);
        imageViewPreview.setImageDrawable(images.get(position));

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == ((View) obj);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}