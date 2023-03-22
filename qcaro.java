package com.management;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;


public class Archivo {

    public static Usuario getUser(int ci){
        try{
            Reader user = Files.newBufferedReader(Paths.get("usuarios/" + ci + ".json"));
            Gson gson = new Gson();
            Usuario userReader = gson.fromJson(user, Usuario.class);
            user.close();
            return userReader;
        }catch(Exception e){
        }
        return null;
    }

    public static Encargado getEncargado(int ci){
        try{
            Reader encargado = Files.newBufferedReader(Paths.get("usuarios/" + ci + ".json"));
            Gson gson = new Gson();
            Encargado encargadoReader = gson.fromJson(encargado, Encargado.class);
            encargado.close();
            return encargadoReader;
        }catch(Exception e){
        }
        return null;
    }


    public static void postUser(Usuario user){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios/"+ user.getCi() + ".json"));
            Gson gson = new Gson();
            String json = gson.toJson(user);
            bw.write(json);
            bw.close();
        }catch(Exception e){

        }

    }

    public static Producto getProducto(String nombre){
        try{
            Reader producto = Files.newBufferedReader(Paths.get("productos/" + nombre + ".json"));
            Gson gson = new Gson();
            Producto productoReader = gson.fromJson(producto, Producto.class);
            producto.close();
            return productoReader;
        }catch(Exception e){
        }
        return null;
    }
    public static Producto getID(String ID){
        try{
            Reader producto = Files.newBufferedReader(Paths.get("productos/" + ID + ".json"));
            Gson gson = new Gson();
            Producto productoReader = gson.fromJson(producto, Producto.class);
            producto.close();
            return productoReader;
        }catch(Exception e){
        }
        return null;
    }
    public static Producto getCategoria(String categoria){
        try{
            Reader producto = Files.newBufferedReader(Paths.get("productos/" + categoria + ".json"));
            Gson gson = new Gson();
            Producto productoReader = gson.fromJson(producto, Producto.class);
            producto.close();
            return productoReader;
        }catch(Exception e){
        }
        return null;
    }
    public static Producto getSubcategoria(String Subcategoria){
        try{
            Reader producto = Files.newBufferedReader(Paths.get("productos/" + Subcategoria + ".json"));
            Gson gson = new Gson();
            Producto productoReader = gson.fromJson(producto, Producto.class);
            producto.close();
            return productoReader;
        }catch(Exception e){
        }
        return null;
    }


    public static void postProducto(Producto producto){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("productos/"+ producto.getNombre() + ".json"));
            Gson gson = new Gson();
            String json = gson.toJson(producto);
            bw.write(json);
            bw.close();
        }catch(Exception e){

        }

    }
}


