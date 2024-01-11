package com.example.museumvisitorapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ImageViewHolder> {

    private List<GalleryItem> galleryItemList;

    public GalleryAdapter(List<GalleryItem> galleryItemList) {
        this.galleryItemList = galleryItemList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.item_gallery, parent, false);

        return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        GalleryItem galleryItem = galleryItemList.get(position);

        holder.imageView.setImageResource(galleryItem.getImageResource());
        holder.textView.setText(galleryItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return galleryItemList.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
        }

    }

}
