package com.management;

import java.util.ArrayList;
import java.util.UUID;


public class Proveedor {
    private String id;
    private String nombre;
    private String telefono;
    private ArrayList<String> productosProveedor;
    public Proveedor(String nombre, String telefono, ArrayList<String> listaProductosProveedor){
        this.id = UUID.randomUUID().toString().substring(0, 6);
        this.nombre = nombre;
        this.telefono = telefono;
        this.productosProveedor = listaProductosProveedor;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public ArrayList<String> getProductosProveedor(){
        return productosProveedor;
    }
    public void setProductosProveedor(ArrayList<String> productosProveedor){
        this.productosProveedor = productosProveedor;
    }

    @Override
    public String toString(){
        return "\nId: " + id + "\nNombre de Proveedor: " + nombre+"\nTelefono: "+telefono + "\nProductos que provee: " + productosProveedor;
    }
}
