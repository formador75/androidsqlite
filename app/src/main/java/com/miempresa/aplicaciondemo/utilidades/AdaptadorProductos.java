package com.miempresa.aplicaciondemo.utilidades;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.miempresa.aplicaciondemo.R;
import com.miempresa.aplicaciondemo.modelos.Producto;

import java.util.List;

public class AdaptadorProductos extends RecyclerView.Adapter<AdaptadorProductos.MyVistaProductos> {

    private List<Producto> listaProductos;

    public void setListaProductos(List<Producto> listaProductos){
        this.listaProductos = listaProductos;
    }

    public AdaptadorProductos(List<Producto> productos){
        this.listaProductos = productos;
    }


    @NonNull
    @Override
    public MyVistaProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View filaProducto = LayoutInflater.from(parent.getContext()).inflate(R.layout.producto, parent, false);
        return new MyVistaProductos(filaProducto);

    }

    @Override
    public void onBindViewHolder(@NonNull MyVistaProductos holder, int position) {

        Producto p = listaProductos.get(position);
        String nombre = p.getNombre();
        String codigo = p.getCodigo();
        String descripcion = p.getDescripcion();
        double precioCompra = p.getPrecioCompra();
        double precioventa = p.getPrecioVenta();
        double existencias = p.getExistencias();

        holder.nombre.setText(nombre);
        holder.descripcion.setText(descripcion);
        holder.codigo.setText(codigo);
        holder.precioVenta.setText(String.valueOf(precioventa));
        holder.precioCompra.setText(String.valueOf(precioCompra));
        holder.existencias.setText(String.valueOf(existencias));

    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    class MyVistaProductos extends RecyclerView.ViewHolder{
        TextView nombre,codigo,descripcion,precioCompra,precioVenta,existencias;
        public MyVistaProductos(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtnombre);
            codigo = itemView.findViewById(R.id.txtcodigo);
            descripcion = itemView.findViewById(R.id.txtdescripcion);
            precioCompra = itemView.findViewById(R.id.txtpreciocompra);
            precioVenta = itemView.findViewById(R.id.txtprecioventa);
            existencias = itemView.findViewById(R.id.txtexistencias);

        }
    }

}
