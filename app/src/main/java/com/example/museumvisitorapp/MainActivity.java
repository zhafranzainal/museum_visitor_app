package com.example.museumvisitorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable originalDrawable = getDrawable(R.drawable.ic_logo);
        Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();

        // Create a scaled version of the Bitmap
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(
                originalBitmap,
                100,
                100,
                false);

        // Convert the scaled Bitmap back to a Drawable
        Drawable scaledDrawable = new BitmapDrawable(getResources(), scaledBitmap);

        // Set the scaled logo as the action bar icon
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(scaledDrawable);

    }

}
