package com.example.lab6_iot;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {


    private Context context;
    private List<Uri> imageUris;

    public ImageAdapter(List<Uri> imageUris) {
        this.imageUris = imageUris;
    }



    @NonNull
    @Override
    public ImageAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_imagenes, parent, false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ImageViewHolder holder, int position) {
        Uri imageUri = imageUris.get(position);
        holder.bind(imageUri);
    }

    @Override
    public int getItemCount() {
        return imageUris.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }


        public void bind(Uri imageUri) {
            // Cargar y mostrar la imagen en el ImageView
            Picasso.get().load(imageUri).resize(680, 1024).into(imageView);

        }

    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Uri> getImageUris() {
        return imageUris;
    }

    public void setImageUris(List<Uri> imageUris) {
        this.imageUris = imageUris;
    }
}
