package com.example.vardanvanyan.animalszoo.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.views.SlidShowView;

import java.util.ArrayList;


public class SlideShowFragment extends DialogFragment {

    public static SlideShowFragment newInstance() {
        return new SlideShowFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_image_slider, container, false);

        final ArrayList<Drawable> images = (ArrayList<Drawable>) getArguments().getSerializable("images");
        final int selectedPosition = getArguments().getInt("position");

        SlidShowView slidShowView = new SlidShowView(view);
        slidShowView.loadSlider(getActivity(), images, selectedPosition);

        return view;
    }
}
