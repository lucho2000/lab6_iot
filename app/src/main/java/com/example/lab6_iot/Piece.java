package com.example.lab6_iot;

import android.content.Context;

import androidx.appcompat.widget.AppCompatImageView;

public class Piece extends AppCompatImageView {

    public int xCoord;
    public int yCoord;
    public int pieceWidth;
    public int pieceHeight;
    public boolean canMove = true;


    public Piece(Context context) {
        super(context);
    }
}
