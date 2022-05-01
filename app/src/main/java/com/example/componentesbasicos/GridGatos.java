package com.example.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;


public class GridGatos extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_gatos);

        gridView = (GridView) findViewById(R.id.gridView);

        String[] legenda = {"Foto 1", "Foto 2", "Foto 3", "Foto 4", "Foto 5","Foto 6"};
        int[] imagens = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f};

        GridAdapter gridAdapter = new GridAdapter(GridGatos.this,legenda,imagens);
        gridView.setAdapter(gridAdapter);
    }
}