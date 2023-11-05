package com.example.lab6_iot;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class PruebaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);

        // Carga la imagen original en un objeto Bitmap
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.crash);

        // Número deseado de partes en el eje X e Y
        int numPartsX = 4; // Número de partes horizontales
        int numPartsY = 4; // Número de partes verticales

        // Calcula el tamaño de cada parte en función del tamaño original
        int widthPart = originalBitmap.getWidth() / numPartsX;
        int heightPart = originalBitmap.getHeight() / numPartsY;

        // Lista para almacenar las partes recortadas
        List<Bitmap> imageParts = new ArrayList<>();

        // Realiza el recorte y almacena cada parte en la lista
        for (int y = 0; y < numPartsY; y++) {
            for (int x = 0; x < numPartsX; x++) {
                int startX = x * widthPart;
                int startY = y * heightPart;
                Bitmap partBitmap = Bitmap.createBitmap(originalBitmap, startX, startY, widthPart, heightPart);
                imageParts.add(partBitmap);
            }
        }

        GridLayout gridLayout = findViewById(R.id.gridLayout);

        for (Bitmap part : imageParts) {
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(part);
            gridLayout.addView(imageView);
        }

    }
}