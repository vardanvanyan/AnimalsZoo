package com.example.vardanvanyan.animalszoo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vardanvanyan.animalszoo.R;

public class SplashScreenActivity extends AppCompatActivity {

    private static final long SPLASH_SCREEN_DURATION = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        startSplashScreen();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    private void startSplashScreen() {
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(SPLASH_SCREEN_DURATION);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

}
