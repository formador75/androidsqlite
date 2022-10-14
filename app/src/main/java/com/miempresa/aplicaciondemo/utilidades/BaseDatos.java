package com.miempresa.aplicaciondemo.utilidades;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {

    private static final String NOMBRE_BASE_DATOS = "proyectomisiontic";
    private static final String NOMBRE_TABLA_PRODUCTOS="productos";
    private static final int VERSION_BASE_DATOS=1;


    public BaseDatos(@Nullable Context context) {
        super(context, NOMBRE_BASE_DATOS, null, VERSION_BASE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(id integer primary key autoincrement," +
                "codigo text," +
                "nombre text," +
                "descripcion text," +
                "preciocompra double," +
                "precioventa double," +
                "existencias double)", NOMBRE_TABLA_PRODUCTOS));

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
