package com.example.vardanvanyan.animalszoo.views;


import android.net.Uri;
import android.view.View;
import android.widget.VideoView;

import com.example.vardanvanyan.animalszoo.R;

public class AnimalVideoDialogView {

    private VideoView videoView;

    public AnimalVideoDialogView(View view) {
        this.videoView = view.findViewById(R.id.animal_video);
    }

    public void playVideo(String urlPath) {
        final Uri uri = Uri.parse(urlPath);
        videoView.setVideoURI(uri);
        videoView.start();
    }
}
