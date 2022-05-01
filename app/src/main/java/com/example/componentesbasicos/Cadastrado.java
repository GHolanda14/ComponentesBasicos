package com.example.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Cadastrado extends AppCompatActivity {
    TextView tvNome,tvSexo,tvSexualidade,tvEstado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrado);

        tvNome = (TextView) findViewById(R.id.tvNome);
        tvSexo = (TextView) findViewById(R.id.tvSexo);
        tvSexualidade = (TextView) findViewById(R.id.tvSexualidade);
        tvEstado = (TextView) findViewById(R.id.tvEstado);

        Intent intent = getIntent();
        tvNome.setText(intent.getStringExtra("nome"));
        tvSexo.setText(intent.getStringExtra("sexo"));
        tvSexualidade.setText(intent.getStringExtra("sexualidade"));
        tvEstado.setText(intent.getStringExtra("estado"));
    }
}