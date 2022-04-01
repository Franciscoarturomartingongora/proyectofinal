package com.example.proyectofin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class p2 extends AppCompatActivity {
  private ListView l1;
  private Button boton5,boton4,salir;

  Adaptercategorias Adapter;


  public static ArrayList<Adapteritem> itemArrayList = new ArrayList<>();
    String url = "https://ejemplo1pc.000webhostapp.com/categoria.php";
    Adapteritem categorias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2);
        l1=(ListView) findViewById(R.id.l1);
        boton4=(Button) findViewById(R.id.boton4);
        boton5=(Button) findViewById(R.id.boton5);
        salir=(Button) findViewById(R.id.salir);
        Adapter = new Adaptercategorias(this,itemArrayList);
        l1.setAdapter(Adapter);

        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(p2.this,historial.class);
                startActivity(intent);
            }
        });
        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(p2.this,imagenesUrl.class);
                startActivity(intent);
            }

        });
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"haz salido de la app", Toast.LENGTH_LONG).show();
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }

        });
       l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

           @Override
           public void onItemClick(AdapterView<?> parent, View view,final int position, long id ) {
               AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
               ProgressDialog progressDialog = new ProgressDialog(view.getContext());

               CharSequence [] dialogoItem = {"ver productos"} ;
               builder.setTitle(itemArrayList.get(position).getCategoria());
               builder.setItems(dialogoItem, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int i) {
                       switch (i) { case 0:

                           startActivity(new Intent(getApplicationContext(),p3.class).
                           putExtra("position", position) );
                           break;


                       }

                   }
               });
             builder.create().show(); 
    

           }

       });
        añadirdatos();


    }

    private void añadirdatos() {
        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                itemArrayList.clear();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String exito = jsonObject.getString("exito");
                    JSONArray jsonArray = jsonObject.getJSONArray("datos");
                    if (exito.equals("1")) {
                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject object = jsonArray.getJSONObject(i);
                            String id = object.getString("id");
                            String categoria = object.getString("categoria");
                            String nombre = object.getString("nombre");
                            String descripcion = object.getString("descripcion");
                            String precio = object.getString("precio");
                            String descripcion2 = object.getString("descripcion2");
                            String precio2 = object.getString("precio2");
                            String descripcion3 = object.getString("descripcion3");
                            String precio3 = object.getString("precio3");

                            categorias = new Adapteritem(id, categoria, nombre, descripcion,precio,descripcion2,precio2,descripcion3,precio3);
                            itemArrayList.add(categorias);
                            Adapter.notifyDataSetChanged();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(p2.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

}