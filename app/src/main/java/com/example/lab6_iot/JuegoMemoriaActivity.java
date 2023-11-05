package com.example.lab6_iot;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.TextView;

import com.example.lab6_iot.databinding.ActivityJuegoMemoriaBinding;

import java.util.List;

public class JuegoMemoriaActivity extends AppCompatActivity {

    ActivityJuegoMemoriaBinding binding;

    int contadorImagenes = 0; //contador de imagenes

    TextView textCuenta;

    List<Uri> selectedImageUris;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJuegoMemoriaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        textCuenta = findViewById(R.id.textView4);


        //ImageAdapter imageAdapter = new ImageAdapter(selectedImageUris);
        //imageAdapter.setContext(JuegoMemoriaActivity.this);
        //imageAdapter.setImageUris(selectedImageUris);

        //binding.recyclerView.setAdapter(imageAdapter);
        //binding.recyclerView.setLayoutManager(new LinearLayoutManager(JuegoMemoriaActivity.this, LinearLayoutManager.HORIZONTAL, false));


        //pedir imagen
        binding.button.setOnClickListener(view -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){

                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });
    }

    //al subir imagen, aqui se actualiza el contador en el text view
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {

            Uri selectedImageUri = data.getData();
            contadorImagenes++;
            // Actualiza el TextView con el nuevo conteo de imágenes
            textCuenta.setText("" + contadorImagenes);

//            if (data != null) {
//                if (data.getClipData() != null) {
//                    // Cuando se seleccionan múltiples imágenes
//                    int count = data.getClipData().getItemCount();
//                    for (int i = 0; i < count; i++) {
//                        Uri imageUri = data.getClipData().getItemAt(i).getUri();
//                        selectedImageUris.add(imageUri);
//                        contadorImagenes++;
//                        // Actualiza el TextView con el nuevo conteo de imágenes
//                        textCuenta.setText("" + contadorImagenes);
//                        // Aquí puedes manejar la URI de la imagen, por ejemplo, agregarla a una lista.
//                    }
//                } else if (data.getData() != null) {
//                    // Cuando se selecciona una única imagen
//                    Uri imageUri = data.getData();
//                    contadorImagenes++;
//                    textCuenta.setText("" + contadorImagenes);
//                    // Aquí puedes manejar la URI de la imagen, por ejemplo, agregarla a una lista.
//                }
//            }
        }

    }
}