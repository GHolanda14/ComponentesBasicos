package com.example.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    EditText etNome;
    LinearLayout bgApp;
    AutoCompleteTextView actvEstados;
    Button btnCliqueLongo;
    MediaPlayer somCurto, somLongo;
    ListView listServico;
    RadioGroup rgbSexo;
    String sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.listSexualidade));
        spinner.setAdapter(adapter);

        etNome = (EditText)findViewById(R.id.etNome);
        bgApp = (LinearLayout) findViewById(R.id.bgApp);
        actvEstados = (AutoCompleteTextView) findViewById(R.id.actvEstados);
        btnCliqueLongo = (Button)findViewById(R.id.btnCliqueLongo);
        somCurto = MediaPlayer.create(this,R.raw.curto);
        somLongo = MediaPlayer.create(this,R.raw.longo);
        listServico = (ListView)findViewById(R.id.listServico);
        rgbSexo = (RadioGroup)findViewById(R.id.rbgSexo);

        ArrayAdapter<String> adp = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.listEstados));
        actvEstados.setThreshold(1);
        actvEstados.setAdapter(adp);

        btnCliqueLongo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getApplicationContext(),"Você deu um clique longo!",Toast.LENGTH_LONG).show();
                somLongo.start();
                return true;
            }
        });
        rgbSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton rb = (RadioButton) findViewById(id);
                sexo = rb.getText().toString();
            }
        });
    }

    public void somCurto(View view){
        Toast.makeText(this,"Um pouco mais...", Toast.LENGTH_SHORT).show();
        somCurto.start();
    }

    public void cadastro(View view){
        Intent intent = new Intent(this,Cadastrado.class);
        intent.putExtra("nome",etNome.getText().toString());
        intent.putExtra("sexo", sexo);
        intent.putExtra("estado", actvEstados.getText().toString());
        intent.putExtra("sexualidade", spinner.getSelectedItem().toString());
        startActivity(intent);
    }

    public void abrirGrid(View view){
        Intent intent = new Intent(this, GridGatos.class);
        startActivity(intent);
    }

    public void mostrarList(View view){
        if(listServico.getVisibility() == View.INVISIBLE){
            listServico.setVisibility(View.VISIBLE);
        }else{
            listServico.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        Toast.makeText(this,"Fundo alterado", Toast.LENGTH_SHORT).show();
        if(id == R.id.bgBatman){
            bgApp.setBackgroundResource(R.drawable.batman);
            return true;
        }
        else if(id == R.id.bgSuperman){
            bgApp.setBackgroundResource(R.drawable.superman);
            return true;
        }else if(id == R.id.bgVegeta) {
            bgApp.setBackgroundResource(R.drawable.vegeta);
            return true;
        }else if(id == R.id.bgClassico){
            bgApp.setBackgroundColor(1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}