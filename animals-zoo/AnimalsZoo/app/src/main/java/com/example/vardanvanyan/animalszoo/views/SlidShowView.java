package com.example.vardanvanyan.animalszoo.views;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.adapters.MyViewPagerAdapter;

import java.util.ArrayList;

public class SlidShowView {

    private ViewPager viewPager;
    private TextView lblCount;

    private ArrayList<Drawable> images;
    private int selectedPosition;

    public SlidShowView(View view) {
        viewPager = view.findViewById(R.id.viewpager);
        lblCount = view.findViewById(R.id.lbl_count);
    }

    public void loadSlider(Context context, ArrayList<Drawable> images, int selectedPosition) {
        this.images = images;
        this.selectedPosition = selectedPosition;
        MyViewPagerAdapter viewPagerAdapter = new MyViewPagerAdapter(context, images);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        setCurrentItem(selectedPosition);
    }

    private void setCurrentItem(int position) {
        viewPager.setCurrentItem(position, false);
        displayMetaInfo(selectedPosition);
    }

    private ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            displayMetaInfo(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private void displayMetaInfo(int position) {
        lblCount.setText((position + 1) + " of " + images.size());
    }
}
