package com.miempresa.aplicaciondemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
        valoresProducto.put("valorcompra", p.getPrecioCompra());
        valoresProducto.put("valorventa", p.getPrecioVenta());
        valoresProducto.put("existencias", p.getExistencias());
    return db.insert(NOMBRE_TABLA, null, valoresProducto);
    }


}
