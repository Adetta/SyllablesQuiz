package com.adetta;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifImageView;

public class Winner  extends AppCompatActivity {
    Boolean isClose = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        GifImageView gifimg = (GifImageView) findViewById(R.id.gifImage);
        GifImageView gifStars = (GifImageView) findViewById(R.id.starsGif);

        gifimg.setOnTouchListener((view, motionEvent) -> {
           if(!isClose)
                gifStars.setVisibility(View.VISIBLE);
            else
                finish();

            isClose = true;
            return false;
        });
    }
}
