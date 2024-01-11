package com.example.museumvisitorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        Button btnGallery = findViewById(R.id.button_gallery);
        Button btnTicket = findViewById(R.id.button_ticket);
        Button btnContact = findViewById(R.id.button_contact);

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                startActivity(intent);
            }
        });

        btnTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogTicket();
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogContact();
            }
        });

    }

    private void showDialogTicket() {
        TicketDialogFragment ticketDialogFragment = new TicketDialogFragment();
        ticketDialogFragment.show(getSupportFragmentManager(), "TicketDialogFragment");
    }

    private void showDialogContact() {
        ContactDialogFragment contactDialogFragment = new ContactDialogFragment();
        contactDialogFragment.show(getSupportFragmentManager(), "ContactDialogFragment");
    }

}
