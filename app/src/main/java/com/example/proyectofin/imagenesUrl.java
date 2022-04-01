package com.example.proyectofin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class imagenesUrl extends AppCompatActivity {
 ImageView cate1,cate2,cate3,t1,t2,t3,ta1,ta2,ta3,r1,r2,r3;
 private Button regreso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes_url);

        cate1 = (ImageView) findViewById(R.id.categoria1);
        cate2 = (ImageView) findViewById(R.id.categoria2);
        cate3 = (ImageView) findViewById(R.id.categoria3);
        regreso=(Button)findViewById(R.id.regresar1);

        t1 = (ImageView) findViewById(R.id.t1);
        t2 = (ImageView) findViewById(R.id.t2);
        t3 = (ImageView) findViewById(R.id.t3);

        ta1 = (ImageView) findViewById(R.id.ta1);
        ta2 = (ImageView) findViewById(R.id.ta2);
        ta3 = (ImageView) findViewById(R.id.ta3);

        r1 = (ImageView) findViewById(R.id.r1);
        r2 = (ImageView) findViewById(R.id.r2);
        r3 = (ImageView) findViewById(R.id.r3);

        regreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(imagenesUrl.this,p2.class);
                startActivity(intent);
            }
        });

        Picasso.get().load("https://ejemplo1pc.000webhostapp.com/torta.png").into(cate1);
        Picasso.get().load("https://ejemplo1pc.000webhostapp.com/taco.png").into(cate2);
        Picasso.get().load("https://ejemplo1pc.000webhostapp.com/refresco.png").into(cate3);

        Picasso.get().load("https://ejemplo1pc.000webhostapp.com/torasada.png").into(t1);
        Picasso.get().load("https://ejemplo1pc.000webhostapp.com/torpastor.png").into(t2);
        Picasso.get().load("https://ejemplo1pc.000webhostapp.com/torqueso.png").into(t3);

        Picasso.get().load("https://ejemplo1pc.000webhostapp.com/tacasadaha.png").into(ta1);
        Picasso.get().load("https://ejemplo1pc.000webhostapp.com/tapastor.png").into(ta2);
        Picasso.get().load("https://ejemplo1pc.000webhostapp.com/tapasque.png").into(ta3);

        Picasso.get().load("https://ejemplo1pc.000webhostapp.com/litroyme.png").into(r1);
        Picasso.get().load("https://ejemplo1pc.000webhostapp.com/seisml.png").into(r2);
        Picasso.get().load("https://ejemplo1pc.000webhostapp.com/dosyme.png").into(r3);

    }
}