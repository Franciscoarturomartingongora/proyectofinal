package com.example.proyectofin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class MainActivity extends AppCompatActivity {
private Button boton2;
private EditText editusuario, editpassword;
    String _email,_password;
    String url = "https://ejemplo1pc.000webhostapp.com/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editusuario=(EditText)findViewById(R.id.editusuario);
      editpassword=(EditText)findViewById(R.id.editpassword);

        boton2=(Button) findViewById(R.id.boton2);




        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(MainActivity.this, p1.class));


            }

        });


            }


    public void iniciar (View view){
        if(editusuario.getText().toString().equals("")){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }else if(editpassword.getText().toString().equals("")){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }else{
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("cargando...");
            progressDialog.show();

            _email = editusuario.getText().toString().trim();
            _password = editpassword.getText().toString().trim();

            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();

                    if (response.equalsIgnoreCase("ingresaste correctamente")) {
                        editusuario.setText("");
                        editpassword.setText("");
                        startActivity(new Intent(getApplicationContext(), p2.class));
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();

                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("email",_email);
                    params.put("contraseña",_password);
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
            requestQueue.add(request);
        }


    }

    }