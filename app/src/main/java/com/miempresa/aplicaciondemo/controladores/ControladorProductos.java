package com.miempresa.aplicaciondemo.controladores;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.miempresa.aplicaciondemo.utilidades.BaseDatos;
import com.miempresa.aplicaciondemo.modelos.Producto;

import java.util.ArrayList;

public class ControladorProductos {

    private BaseDatos baseDatos;
    private String NOMBRE_TABLA = "productos";

    public ControladorProductos(Context context){
        baseDatos = new BaseDatos(context);
    }


    public long agregarProducto(Producto p){
        SQLiteDatabase db = baseDatos.getWritableDatabase();
        ContentValues valoresProducto = new ContentValues();
        valoresProducto.put("codigo", p.getCodigo());
        valoresProducto.put("nombre", p.getNombre());
        valoresProducto.put("descripcion", p.getDescripcion());
        valoresProducto.put("preciocompra", p.getPrecioCompra());
        valoresProducto.put("precioventa", p.getPrecioVenta());
        valoresProducto.put("existencias", p.getExistencias());
        return db.insert(NOMBRE_TABLA, null, valoresProducto);
    }

    public ArrayList<Producto> listarProductos(){
        ArrayList<Producto> productos = new ArrayList<>();
        SQLiteDatabase db = baseDatos.getReadableDatabase();
        String[] columnas = {"codigo","nombre","descripcion","preciocompra","precioventa","existencias","id"};
        Cursor cursor = db.query(
                NOMBRE_TABLA,
                columnas,
                null,
                null,
                null,
                null,
                null

        );
        if(cursor == null){
            return productos;
        }

        if(!cursor.moveToFirst()){
            return productos;
        }

        do{
            String codigo = cursor.getString(0);
            String nombre = cursor.getString(1);
            String descripcion = cursor.getString(2);
            Double precioCompra = cursor.getDouble(3);
            Double precioVenta = cursor.getDouble(4);
            Double existencia = cursor.getDouble(5);
            int id = cursor.getInt(6);

            Producto producto = new Producto(id, codigo, nombre, descripcion, precioCompra,precioVenta,existencia);
            productos.add(producto);

            Log.d("sqliteTEST", producto.toString());



        }while(cursor.moveToNext());

         cursor.close();

        return productos;


    }

}
