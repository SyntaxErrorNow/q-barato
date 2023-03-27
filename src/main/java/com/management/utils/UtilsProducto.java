package com.management.utils;
import java.util.ArrayList;
import java.util.Arrays;
import com.management.Producto;

public class UtilsProducto {



    public static ArrayList<Producto> ordenarListas(ArrayList<Producto> pr, String p){
        ArrayList<Producto> cj;
        if(p.equals("Alfabeticamente")){
            cj = new ArrayList<> (Arrays.asList(ordenarAlfabeticamente(pr)));
        }else if(p.equals("Por precio de menor a mayor")){
            cj = new ArrayList<> (Arrays.asList(ordenarPrecio(pr)));
        }else if(p.equals("Por precio de mayor a menor")){
            cj = new ArrayList<> (Arrays.asList(ordenarPrecioInverso(pr)));
        }
        return pr;

    }


    public static Producto[] ordenarAlfabeticamente(ArrayList<Producto> productos){
        Producto[] prod = new Producto[productos.size()];
        String[] prods = new String[productos.size()];
        for(int i =0; i<prods.length; i++){
            prods[i] = productos.get(i).getNombre().toLowerCase();
        }
        Arrays.sort(prods);
        for(int i = 0; i<prod.length; i++){
            for(int j = 0; j<prod.length; j++){
                if(productos.get(j).getNombre().toLowerCase().equals(prods[i])){
                    prod[i] = productos.get(j);
                }
            }
        }
        return prod;
    }
    public static Producto[] ordenarPrecio(ArrayList<Producto> productos){
        Producto[] prod = new Producto[productos.size()];
        for(int z = 0; z<prod.length; z++){
            prod[z] = productos.get(z);
        }
        for(int i = 0; i < prod.length; i++){
            for(int j = i+1; j < prod.length; j++){
                if(prod[i].getPrecio() > prod[j].getPrecio()){
                    Producto aux = prod[i];
                    prod[i] = prod[j];
                    prod[j] = aux;
                }
            }
        }
        return prod;
    }

    public static Producto[] ordenarPrecioInverso(ArrayList<Producto> productos){
        Producto[] prod = new Producto[productos.size()];
        for(int z = 0; z<prod.length; z++){
            prod[z] = productos.get(z);
        }
        for(int i = 0; i < prod.length; i++){
            for(int j = i+1; j < prod.length; j++){
                if(prod[i].getPrecio() < prod[j].getPrecio()){
                    Producto aux = prod[i];
                    prod[i] = prod[j];
                    prod[j] = aux;
                }
            }
        }
        for(int h = 0; h<prod.length; h++){
            System.out.println(prod[h].getPrecio());
        }
        return prod;
    }


}
