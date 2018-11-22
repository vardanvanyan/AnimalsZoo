package com.example.vardanvanyan.animalszoo.fragments;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.vardanvanyan.animalszoo.R;
import com.example.vardanvanyan.animalszoo.views.AnimalDetailView;
import com.example.vardanvanyan.animalszoo.views.AnimalVideoDialogView;

public class VideoDialogFragment extends DialogFragment {

    public VideoDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_video_dialog, container, false);
        final String videoUrl = getArguments().getString(AnimalDetailView.VIDEO_URL_KEY);
        final AnimalVideoDialogView dialogView = new AnimalVideoDialogView(view);
        dialogView.playVideo(videoUrl);
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity(), R.style.CustomDialog);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

}
