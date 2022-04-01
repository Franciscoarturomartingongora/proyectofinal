package com.example.proyectofin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

public class p3 extends AppCompatActivity {
    private TextView descripcion,precio;
    private TextView descripcion2,precio2;
    private TextView descripcion3,precio3;
    private Button regresar,boton6;
    private EditText total;
    private EditText c1,c2,c3;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p3);

        descripcion = (TextView) findViewById(R.id.descripcion);
        precio = (TextView) findViewById(R.id.precio);
        descripcion2 = (TextView) findViewById(R.id.descripcion2);
        precio2 = (TextView) findViewById(R.id.precio2);
        descripcion3 = (TextView) findViewById(R.id.descripcion3);
        precio3 = (TextView) findViewById(R.id.precio3);
        regresar = (Button) findViewById(R.id.regresar1);
        boton6 = (Button) findViewById(R.id.boton6);
        total = (EditText) findViewById(R.id.total);
        total.setOnClickListener(this::calcu);
        c1 = (EditText) findViewById(R.id.c1);
        c2 = (EditText) findViewById(R.id.c2);
        c3 = (EditText) findViewById(R.id.c3);










        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");


        descripcion.setText("descripcion: "+ p2.itemArrayList.get(position).getDescripcion());
        descripcion2.setText("descripcion2: "+ p2.itemArrayList.get(position).getDescripcion2());
        descripcion3.setText("descripcion3: "+ p2.itemArrayList.get(position).getDescripcion3());
        precio.setText("precio: " + p2.itemArrayList.get(position).getPrecio());
        precio2.setText("precio2: "+ p2.itemArrayList.get(position).getPrecio2());
        precio3.setText("precio3: "+ p2.itemArrayList.get(position).getPrecio3());


        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(p3.this,p2.class);
                startActivity(intent);
            }
        });

    }
public void calcu(View view){
        float n1,n2,n3,res;
          n1 = Float.parseFloat(c1.getText().toString());
          n2 = Float.parseFloat(c2.getText().toString());
          n3 = Float.parseFloat(c3.getText().toString());
        ///int n3 = Integer.parseInt(c3.getText().toString());
         res=n1+n2+n3;
        total.setText(""+res);
}
}
