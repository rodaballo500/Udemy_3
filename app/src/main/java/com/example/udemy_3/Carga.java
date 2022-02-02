package com.example.udemy_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Carga extends AppCompatActivity {

    TextView app_name, desarrollador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carga);

        app_name = findViewById(R.id.tv_app_name);
        desarrollador = findViewById(R.id.tv_desarrollador);

        // Cambio de letra. le asignamos una fuente de las guardadas en assets/fuentes
        String ubicacion ="fuentes/sans_negrita.ttf";
        Typeface tf = Typeface.createFromAsset(Carga.this.getAssets(),ubicacion); // en Carga.this podriamos usar getApplicationContext()

        final int DURACION = 3000; // tiempo de duracion de la animacion 3 seg

        // con handler podemos ejecutar cierta linea de codigo durante un tiempo determinado

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() { // lo que contenga el run es el codigo que se ejecutara

                Intent intent = new Intent(Carga.this, MainActivityAdministrador.class);
                startActivity(intent);
                finish();

            }
        }, DURACION);

        //se realiza el cambio de letra con el objeto Typeface que creamos antes
        app_name.setTypeface(tf);
        desarrollador.setTypeface(tf);



    }
}