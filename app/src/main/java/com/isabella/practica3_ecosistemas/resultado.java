package com.isabella.practica3_ecosistemas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class resultado extends AppCompatActivity {

    private TextView textViewresultado;
    private Button buttoncalcularotravez;
    private EditText editTextnombre;
    private TextView textViewtexto;
    private TextView textViewnumeronota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        textViewresultado = findViewById(R.id.textViewresultado);
        buttoncalcularotravez = findViewById(R.id.buttoncalcularotravez);
        editTextnombre = findViewById(R.id.editTextnombre);
        textViewtexto = findViewById(R.id.textViewtexto);
        textViewnumeronota = findViewById(R.id.textViewnumeronota);


        try {
            Intent intent = getIntent();
            String color=intent.getStringExtra("COLOR");
            double nota = intent.getDoubleExtra("NOTA",0.0);
            String name = intent.getStringExtra("NAME");
            textViewtexto.setText("Hola "+name+", tu nota es: ");
            textViewnumeronota.setText(""+nota);
            View someView = findViewById(R.id.textViewresultado);
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

        buttoncalcularotravez.setOnClickListener(
                (v)-> {
                    Intent intent = getIntent();
                    String color=intent.getStringExtra("COLOR");
                    Intent i = new Intent(this, MainActivity.class);
                    i.putExtra("COLOR",color);
                    startActivity(i);
                }
        );

    }
}