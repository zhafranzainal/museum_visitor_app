package com.example.museumvisitorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Museum Levels & Galleries");
        actionBar.setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<GalleryItem> galleryItemList = new ArrayList<>();
        galleryItemList.add(new GalleryItem(R.drawable.gallery1, "Gallery 1 \n\n Introduction and History of Sungai Lembing"));
        galleryItemList.add(new GalleryItem(R.drawable.gallery2, "Gallery 2 \n\n Mining Process and Safety"));
        galleryItemList.add(new GalleryItem(R.drawable.gallery3, "Gallery 3 \n\n Mining Diorama"));
        galleryItemList.add(new GalleryItem(R.drawable.gallery4, "Gallery 4 \n\n Machinery and Electrical Equipment"));

        GalleryAdapter galleryAdapter = new GalleryAdapter(galleryItemList);

        recyclerView.setAdapter(galleryAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }

        return super.onOptionsItemSelected(item);

    }

}
