package com.example.proyectofin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class historial extends AppCompatActivity {
Button REGRE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        REGRE = (Button) findViewById(R.id.regresar1);


        REGRE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(historial.this,p2.class);
                startActivity(intent);
            }
        });
    }
}