package com.isabella.practica3_ecosistemas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button buttonconfig;
    private TextView textViewescribetunombre;
    private EditText editTextnombre;
    private Button buttoncontinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonconfig = findViewById(R.id.buttonconfig);
        textViewescribetunombre = findViewById(R.id.textViewescribetunombre);
        editTextnombre = findViewById(R.id.editTextnombre);
        buttoncontinuar = findViewById(R.id.buttoncontinuar);
        try {
            Intent intent = getIntent();
            String color=intent.getStringExtra("COLOR");
            View someView = findViewById(R.id.textViewescribetunombre);
            View root = someView.getRootView();
            switch (color){
                case "Azul":
                    root.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));
                    break;
                case "Negro":
                    root.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
                    break;
                case "Blanco":
                    root.setBackgroundColor(getResources().getColor(android.R.color.white));
                    break;
            }
        }
        catch (Exception e){
        }

        buttonconfig.setOnClickListener(
                (v)->{
                    String config = buttonconfig.getText().toString();
                    Intent i = new Intent(this, com.isabella.practica3_ecosistemas.Configuracioncolor.class);
                    startActivity(i);
                }
                );

        buttoncontinuar.setOnClickListener(
                (v)->{
                    Intent intent = getIntent();
                    String color=intent.getStringExtra("COLOR");
                    String continuar =  buttoncontinuar.getText().toString();
                    String nombre = editTextnombre.getText().toString();
                    Intent i = new Intent(MainActivity.this, com.isabella.practica3_ecosistemas.calculodenota.class);
                    i.putExtra("NAME",nombre);
                    //i.putExtra("NAME",nombre);
                    i.putExtra("COLOR",color);
                    startActivity(i);
                }
        );

    }
}