package com.isabella.practica3_ecosistemas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Configuracioncolor extends AppCompatActivity {
    private TextView textViewconfigcolor;
    private TextView textViewseleccioncolor;
    private Button buttonazul;
    private Button buttonblanco;
    private Button buttonnegro;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracioncolor);

        textViewconfigcolor = findViewById(R.id.textViewconfigcolor);
        textViewseleccioncolor = findViewById(R.id.textViewseleccioncolor);
        buttonazul = findViewById(R.id.buttonazul);
        buttonblanco = findViewById(R.id.buttonblanco);
        buttonnegro = findViewById(R.id.buttonnegro);

        buttonazul.setOnClickListener(
                (v)->{
                    Intent intent = new Intent(Configuracioncolor.this,MainActivity.class);
                    intent.putExtra("COLOR","Azul");
                    startActivity(intent);
                }
        );

        buttonblanco.setOnClickListener(
                (v)->{
                    Intent intent = new Intent(Configuracioncolor.this,MainActivity.class);
                    intent.putExtra("COLOR","Blanco");
                    startActivity(intent);
                }
        );

        buttonnegro.setOnClickListener(
                (v)->{
                    Intent intent = new Intent(Configuracioncolor.this,MainActivity.class);
                    intent.putExtra("COLOR","Negro");
                    startActivity(intent);
                }
        );










    }
}