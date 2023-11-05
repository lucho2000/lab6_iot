package com.example.lab6_iot;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.lab6_iot.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        binding.buttonSV.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, StfPuzzleSVActivity.class);
            startActivity(intent);

        });

        binding.buttonSMemory.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, JuegoMemoriaActivity.class);
            startActivity(intent);

        });

        setContentView(binding.getRoot());



    }
}