package com.management.utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.management.Proveedor;
import com.management.Archivos.ArchivoProveedor;


public class UtilsProveedor{


    public static ArrayList<String> obtenerListaProductos(String listaProductos){
        String [] lista = listaProductos.trim().split(",");
        ArrayList<String> productos = new ArrayList<String>(Arrays.asList(lista));
        for (String producto : productos) {
            producto.toLowerCase();
        }
        return productos;
    }

    public static String obtenerListaProductos(ArrayList<String> listaProductos){
        return String.join(",", listaProductos);
    }

    public static ArrayList<String> obtenerListaNombreProductosProveedores(){
        ArrayList<Proveedor> proveedores = ArchivoProveedor.getAllProveedores();
        Set<String> productos = new HashSet<>();
        for(Proveedor proveedor : proveedores){
            for(String producto : proveedor.getProductosProveedor()){
                productos.add(producto);
            }
        }
        return new ArrayList<>(productos);
    }

    public static String [] obtenerListaNombreProveedores(String productoField) {
        ArrayList<String> nombreProveedores = new ArrayList<String>();
        ArrayList<Proveedor> proveedores = ArchivoProveedor.getAllProveedores();
        for(Proveedor proveedor : proveedores){
            if(proveedor.getProductosProveedor().contains(productoField)){
                nombreProveedores.add(proveedor.getNombre());
            }

        }
        return nombreProveedores.toArray(new String[nombreProveedores.size()]);
    }

    
}