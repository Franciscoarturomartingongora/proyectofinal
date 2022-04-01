package com.example.proyectofin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adaptercategorias  extends ArrayAdapter <Adapteritem> {
Context context;
List<Adapteritem> Arraylistas;


    public Adaptercategorias(@NonNull Context context, List<Adapteritem>Arraylistas) {


        super(context,R.layout.item,Arraylistas);
        this.context=context;
        this.Arraylistas=Arraylistas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,null,true);
        TextView id =view.findViewById(R.id.nombre);
        TextView nombre = view.findViewById(R.id.descripcion);
        id.setText(Arraylistas.get(position).getId());
        nombre.setText(Arraylistas.get(position).getCategoria());
        return view;

    }
}
