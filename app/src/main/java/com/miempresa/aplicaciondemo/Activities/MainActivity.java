package com.miempresa.aplicaciondemo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.miempresa.aplicaciondemo.R;
import com.miempresa.aplicaciondemo.controladores.ControladorProductos;
import com.miempresa.aplicaciondemo.modelos.Producto;
import com.miempresa.aplicaciondemo.utilidades.AdaptadorProductos;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnIrAgregar;
    private RecyclerView reciclerProductos;
    private AdaptadorProductos adaptador;
    private ControladorProductos controlador;
    private List<Producto> listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIrAgregar = findViewById(R.id.button);
        reciclerProductos = findViewById(R.id.reciclerproductos);

        controlador = new ControladorProductos(MainActivity.this);
        listaProductos = new ArrayList<>();
        adaptador = new AdaptadorProductos(listaProductos);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        reciclerProductos.setLayoutManager(mLayoutManager);
        reciclerProductos.setItemAnimator(new DefaultItemAnimator());
        reciclerProductos.setAdapter(adaptador);

        listarProductos();



        btnIrAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AgregarProducto.class);
                startActivity(i);
            }
        });
         }

         public void listarProductos(){

        if(adaptador == null) return;
        listaProductos = controlador.listarProductos();
        adaptador.setListaProductos(listaProductos);
        adaptador.notifyDataSetChanged();

         }

}