package com.management;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

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

    public static void deleteUsario(int ci){
        try{
            Files.deleteIfExists(Paths.get("usuarios/" + ci + ".json"));
        }catch(Exception e){
        }
    }

    public static Producto getProducto(String id){
        try{
            char digitoInicial = id.charAt(0);
            Reader producto = Files.newBufferedReader(Paths.get("productos/"+digitoInicial+" "+getPathID(digitoInicial)+"/"+ id + ".json"));
            Gson gson = new Gson();
            Producto productoReader = gson.fromJson(producto, Producto.class);
            producto.close();
            return productoReader;
        }catch(Exception e){
        }
        return null;
    }
    public static ArrayList<Producto> getProductoPorCategoria(String categoria){
        ArrayList<Producto> pcategoria = new ArrayList<>();
        File[] fAuxiliar = new File("productos/"+getNumeroCategoria(categoria)+" "+categoria).listFiles();
        for(int i = 1; i<= fAuxiliar.length; i++){
            pcategoria.add(getProducto(((getNumeroCategoria(categoria) * 10000) + i) + ""));
        }
        return pcategoria;
    }

    public static ArrayList<Producto> getProductoPorNombre(String nombre){
        ArrayList<Producto> pNombre = new ArrayList<>();
        for(int i = 1; i <= 6; i++){
            File[] fAuxiliar = new File("productos/"+i+" "+getPathID(Integer.toString(i).charAt(0))).listFiles();
            for(int j = 1; j <= fAuxiliar.length; j++){
                int id = (i*10000) + j;
                Producto p = getProducto(id + "");
                if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())){
                    pNombre.add(p);
                }
            }
        }
        return pNombre;
    }

    public static ArrayList<Producto> getProductoPorSubcategoria(String subcategoria){
        ArrayList<Producto> listaProSub = new ArrayList<>();
        for(int i = 1; i <= 6; i++){
            File[] fAuxiliar = new File("productos/"+i+" "+getPathID(Integer.toString(i).charAt(0))).listFiles();
            for(int j = 1; j <= fAuxiliar.length; j++){
                int id = (i*10000) + j;
                Producto p = getProducto(id + "");
                if (p.getSubCategoria().toLowerCase().equals(subcategoria.toLowerCase())){
                    listaProSub.add(p);
                }
            }
        }
        return listaProSub;
    }



    public static int getNumeroCategoria(String tipo){
        if(tipo.equals("despensa")){
            return 1;
        }
        if(tipo.equals("comestibles")){
            return 2;
        }
        if(tipo.equals("bebidas")){
            return 3;
        }
        if(tipo.equals("aseo")){
            return 4;
        }
        if(tipo.equals("cuidado personal")){
            return 5;
        }else{
            return 6;
        }
    }

    public static String getPathID(char digito){
        if(digito=='1'){
            return "despensa";
        }
        if(digito=='2'){
            return "comestibles";
        }
        if(digito=='3'){
            return "bebidas";
        }
        if(digito=='4'){
            return "aseo";
        }
        if(digito=='5'){
            return "cuidado personal";
        }else{
            return "otros";
        }
    }
    public static ArrayList<Producto> ordenarListas(ArrayList<Producto> pr, String p){
        ArrayList<Producto> cj = new ArrayList<>();
        if(p.equals("Alfabeticamente")){
            cj = new ArrayList<> (Arrays.asList(ordenarAlfabeticamente(pr)));
        }else if(p.equals("Por precio de menor a mayor")){
            cj = new ArrayList<> (Arrays.asList(ordenarPrecio(pr)));
        }else if(p.equals("Por precio de mayor a menor")){
            cj = new ArrayList<> (Arrays.asList(ordenarPrecioInverso(pr)));
        }
        return cj;

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


    public static void deleteProducto(Producto producto){
        try{
            Files.deleteIfExists(Paths.get("productos/"+producto.getNumCategoria()+" "+producto.getCategoria()+"/"+ producto.getId() + ".json"));
        }catch(Exception e){
        }
    }

    public static void postProducto(Producto producto){
        try{
            producto.setId(""+generarID(producto.getNumCategoria()));
            BufferedWriter bw = new BufferedWriter(new FileWriter("productos/"+producto.getNumCategoria()+" "+
                                                                   producto.getCategoria()+"/"+
                                                                   producto.getId() + ".json"));
            Gson gson = new Gson();
            String json = gson.toJson(producto);
            bw.write(json);
            bw.close();
        }catch(Exception e){
        }
    }

    public static int generarID(int i){
        boolean valido = false;
        int idFormulado = (i*10000)+1;
        while(!valido){
            if(getProducto(idFormulado+"")==null){
                valido = true;
            }else{
                idFormulado++;
            }
        }
        System.out.println(idFormulado);
        return idFormulado;
    }

    public static void modifyProducto(Producto producto){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("productos/"+producto.getNumCategoria()+" "+producto.getCategoria()+"/"+ producto.getId() + ".json"));
            Gson gson = new Gson();
            String json = gson.toJson(producto);
            bw.write(json);
            bw.close();
        }catch(Exception e){
        }
    }

    public static String[] determinarSubcategorias(String tipo){
        if(tipo.equals("despensa")){
            String []subcategorias = {"verduras","condimentos","carne","lacteos","cereales","frutas"};
            return subcategorias;
        }
        if(tipo.equals("comestibles")){
            String []subcategorias = {"dulces","postres","derivados de cereales","helado","frituras"};
            return subcategorias;
        }
        if(tipo.equals("bebidas")){
            String []subcategorias = {"gaseosas","naturales","jugos","alcoholica","derivada de lacteo"};
            return subcategorias;
        }
        if(tipo.equals("aseo")){
            String []subcategorias = {"detergente","lavavajillas","utensilios","desinfectantes"};
            return subcategorias;
        }
        if(tipo.equals("cuidado personal")){
            String []subcategorias = {"jabones","shampoo","cremas","producto dentales","cuidado intimo"};
            return subcategorias;
        }else{
            String []subcategorias = {""};
            return subcategorias;
        }
    }
}


