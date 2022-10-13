package com.miempresa.aplicaciondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarProducto extends AppCompatActivity {

    private Button btnAgregar, btnAtras;
    private EditText etCodigo, etNombre, etDescripcion, etValorCompra, etValorVenta, etExistencias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto);
        etCodigo = findViewById(R.id.idCodigo);
        etNombre = findViewById(R.id.idNombre);
        etDescripcion = findViewById(R.id.idDescripcion);
        etValorCompra = findViewById(R.id.idValorCompra);
        etValorVenta = findViewById(R.id.idValorVenta);
        etExistencias = findViewById(R.id.idExistencias);
        btnAgregar = findViewById(R.id.idBtnAgregar);
        btnAtras = findViewById(R.id.idBtnAtras);
        ControladorProductos controlador = new ControladorProductos(AgregarProducto.this);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String codigo = etCodigo.getText().toString();
                String nombre = etNombre.getText().toString();
                String descripcion = etDescripcion.getText().toString();
                Double valorcompra = Double.parseDouble(etValorCompra.getText().toString());
                Double valorventa = Double.parseDouble(etValorVenta.getText().toString());
                Double existencias = Double.parseDouble(etExistencias.getText().toString());
                Producto producto = new Producto(codigo,nombre,descripcion,valorcompra,valorventa,existencias);
                long id = controlador.agregarProducto(producto);

                if(id == -1){
                    Toast.makeText(AgregarProducto.this, "error al agregar producto", Toast.LENGTH_LONG).show();
                }else{
                    String variable = "" + id;
                    Toast.makeText(AgregarProducto.this, "el producto se agrego", Toast.LENGTH_LONG).show();
                    Toast.makeText(AgregarProducto.this, variable , Toast.LENGTH_LONG).show();

                }


            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AgregarProducto.this, MainActivity.class);
                startActivity(i);
            }
        });



    }
}