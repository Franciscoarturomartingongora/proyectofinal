package com.example.proyectofin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class p1 extends AppCompatActivity {
private EditText nombreusuario,passwoord,correo;
private Button boton3,inicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1);
        nombreusuario=(EditText) findViewById(R.id.nombreusuario);
        passwoord=(EditText) findViewById(R.id.passwoord);
        correo=(EditText) findViewById(R.id.correo);
        boton3=(Button)findViewById(R.id.boton3);
        inicio=(Button)findViewById(R.id.inicio);


        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(p1.this,MainActivity.class);
                startActivity(intent);
            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertar();
            }}); }
    private void insertar() {
        String nombre=nombreusuario.getText().toString().trim();
        String email=correo.getText().toString().trim();
        String contraseña=passwoord.getText().toString().trim();
        ProgressDialog progressDialog = new ProgressDialog(this);
        if (nombre.isEmpty()){
            nombreusuario.setError("Complete los campos");
        } else if (contraseña.isEmpty()){
            correo.setError("Complete los campos");
        }
        else if (email.isEmpty()){
            passwoord.setError("Complete los campos");
        }else{
            progressDialog.show();
            StringRequest request=new StringRequest(Request.Method.POST, "https://ejemplo1pc.000webhostapp.com/registro.php", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equalsIgnoreCase("datos insertados")) {
                        Toast.makeText(p1.this, "datos ingresados", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    } else {
                        Toast.makeText(p1.this, response, Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(p1.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String >params=new HashMap<String, String>();
                    params.put("nombre",nombre);
                    params.put("email",email);
                    params.put("contraseña",contraseña);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(p1.this);
            requestQueue.add(request);


        }
    }
}