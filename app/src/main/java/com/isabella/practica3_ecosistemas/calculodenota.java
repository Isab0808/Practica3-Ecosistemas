package com.isabella.practica3_ecosistemas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calculodenota extends AppCompatActivity {

    private TextView textViewcalculodenota;
    private EditText editTextproyecto1;
    private EditText editTextproyecto2;
    private EditText editTextquices;
    private EditText editTextparcial1;
    private EditText editTextparcial2;
    private Button buttoncalcular;
    private EditText editTextejerciciossemanales;


    public double getGrade(){
        double proyecto1=Double.parseDouble(editTextproyecto1.getText().toString());
        double proyecto2=Double.parseDouble(editTextproyecto2.getText().toString());
        double quices=Double.parseDouble(editTextquices.getText().toString());
        double parcial1=Double.parseDouble(editTextparcial1.getText().toString());
        double parcial2=Double.parseDouble(editTextparcial2.getText().toString());
        double ejerciciossemanales=Double.parseDouble(editTextejerciciossemanales.getText().toString());

        return (proyecto1*0.15)+(proyecto2*0.15)+(quices*0.15)+(parcial1*0.25)+(parcial2*0.25)+(ejerciciossemanales*0.05);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculodenota);
        textViewcalculodenota = findViewById(R.id.textViewcalculodenota);
        editTextproyecto1 = findViewById(R.id.editTextproyecto1);
        editTextproyecto2 = findViewById(R.id.editTextproyecto2);
        editTextquices = findViewById(R.id.editTextquices);
        editTextparcial1 = findViewById(R.id.editTextparcial1);
        editTextparcial2 = findViewById(R.id.editTextparcial2);
        buttoncalcular = findViewById(R.id.buttoncalcular);
        editTextejerciciossemanales = findViewById(R.id.editTextejerciciossemanales);

        try {
            Intent intent = getIntent();
            String color=intent.getStringExtra("COLOR");
            View someView = findViewById(R.id.textViewcalculodenota);
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

        buttoncalcular.setOnClickListener(
                (v)->{
                    Intent intent = getIntent();
                    String color=intent.getStringExtra("COLOR");
                    String name=intent.getStringExtra("NAME");
                    double nota = getGrade();
                    Intent i = new Intent(calculodenota.this, com.isabella.practica3_ecosistemas.resultado.class);
                    i.putExtra("COLOR",color);
                    i.putExtra("NOTA",nota);
                    i.putExtra("NAME",name);
                    startActivity(i);
                }
        );

    }
}