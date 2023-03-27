package com.management.Archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.management.Producto;
import com.management.utils.UtilsCategoria;

public class ArchivoProducto {


    public static Producto getProducto(String id){
        try{
            char digitoInicial = id.charAt(0);
            Reader producto = Files.newBufferedReader(Paths.get("productos/"+digitoInicial+ " "+ UtilsCategoria.obtenerPathId(digitoInicial) +"/"+ id + ".json"));
            Gson gson = new Gson();
            Producto productoReader = gson.fromJson(producto, Producto.class);
            producto.close();
            return productoReader;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ArrayList<Producto> getProductoPorCategoria(String categoria){
        ArrayList<Producto> pcategoria = new ArrayList<>();
        File[] fAuxiliar = new File("productos/"+ UtilsCategoria.obtenerNumeroCategoria(categoria)+" "+categoria).listFiles();
        int hallados = 0;
            for(int i = 1; i<= 9999; i++){
                if(hallados<fAuxiliar.length){
                    Producto p = getProducto((( UtilsCategoria.obtenerNumeroCategoria(categoria) * 10000) + i) + "");
                    if(p!=null){
                        pcategoria.add(p);
                        hallados++;
                    }
                }else{
                    break;
                }


            }
        return pcategoria;
    }

    public static ArrayList<Producto> getProductoTemporales(){
        ArrayList<Producto> pTemporada = new ArrayList<>();
        File[] fAuxiliar = new File("productos/7 temporada").listFiles();
        int hallados = 0;
            for(int t = 1; t <=12 ;t++){
                for(int i = 1; i<=99;i++){
                    if(hallados<fAuxiliar.length){
                        Producto p = getProducto((70000+(t*100)+i) + "");
                        if(p!=null){
                            pTemporada.add(p);
                            hallados++;
                        }else{
                            break;
                        }
                    }
                }
            }
        return pTemporada;
    }

    public static ArrayList<Producto> getProductoPorNombre(String nombre){
        ArrayList<Producto> pNombre = new ArrayList<>();
        for(int i = 1; i <= 7; i++){
            ArrayList<Producto> pCategoria = (i==7)?getProductoTemporales():getProductoPorCategoria(UtilsCategoria.obtenerPathId((char)i));
            for(int j = 0; j<pCategoria.size();j++){
                Producto p = pCategoria.get(j);
                if(p != null){
                    if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())){
                        pNombre.add(p);
                    }
                }
            }
        }
        return pNombre;
    }

    public static ArrayList<Producto> getProductoPorSubcategoria(String subcategoria){
        ArrayList<Producto> listaProSub = new ArrayList<>();
        for(int i = 1; i <= 7; i++){
            ArrayList<Producto> pCategoria = (i==7)?getProductoTemporales():getProductoPorCategoria(UtilsCategoria.obtenerPathId((char)i));
            for(int j = 0; j<pCategoria.size();j++){
                Producto p = pCategoria.get(j);
                if(p != null){
                    if (p.getSubCategoria().toLowerCase().contains(subcategoria.toLowerCase())){
                        listaProSub.add(p);
                    }
                }
            }
        }
        return listaProSub;
    }


    public static void postProducto(Producto producto){
        try{
            producto.setId(""+generarID( UtilsCategoria.obtenerNumeroCategoria(producto.getCategoria()) ));
            BufferedWriter bw = new BufferedWriter(new FileWriter("productos/"+ UtilsCategoria.obtenerNumeroCategoria(producto.getCategoria()) +" "+
                                                                   producto.getCategoria()+"/"+
                                                                   producto.getId() + ".json"));
            Gson gson = new Gson();
            String json = gson.toJson(producto);
            bw.write(json);
            bw.close();
        }catch(Exception e){
        }
    }

    public static void postProductoTemporada(Producto producto, int temporada){
        try{
            producto.setId(""+generarIDTemporada(temporada));
            BufferedWriter bw = new BufferedWriter(new FileWriter("productos/7 temporada/"+
                                                                   producto.getId() + ".json"));
            Gson gson = new Gson();
            String json = gson.toJson(producto);
            bw.write(json);
            bw.close();
        }catch(Exception e){
        }
    }

    public static void modifyProducto(Producto producto){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("productos/"+ UtilsCategoria.obtenerNumeroCategoria(producto.getCategoria()) +" "+producto.getCategoria()+"/"+ producto.getId() + ".json"));
            Gson gson = new Gson();
            String json = gson.toJson(producto);
            bw.write(json);
            bw.close();
        }catch(Exception e){
        }
    }

    public static void deleteProducto(Producto producto){
        try{
            Files.deleteIfExists(Paths.get("productos/"+ UtilsCategoria.obtenerNumeroCategoria(producto.getCategoria()) +" "+producto.getCategoria()+"/"+ producto.getId() + ".json"));
        }catch(Exception e){
        }
    }

    public static void deleteProductosDeUnaCategoria(String categoria){
        try{
            if(categoria.equals("temporada")){
                deleteProductosTemporadas();
            }else{
                File[] fAuxiliar = new File("productos/"+ UtilsCategoria.obtenerNumeroCategoria(categoria)+" "+categoria).listFiles();
               int hallados = 0;
                for(int i = 1; i<= 9999; i++){
                    if(hallados<fAuxiliar.length){
                        Producto p = getProducto((( UtilsCategoria.obtenerNumeroCategoria(categoria) * 10000) + i) + "");
                        if(p!=null){
                            Files.deleteIfExists(Paths.get("productos/"+ UtilsCategoria.obtenerNumeroCategoria(p.getCategoria()) +" "+ p.getCategoria()+"/"+ p.getId() + ".json"));
                            hallados++;
                        }
                    }else{
                        break;
                    }
                }
            }
        }catch(Exception e){
        }
    }

    public static void deleteProductosTemporadas(){
        try{
            File[] fAuxiliar = new File("productos/7 temporada").listFiles();
            int hallados = 0;
            for(int t = 1; t <=12 ;t++){
                for(int i = 1; i<=99;i++){
                    if(hallados<fAuxiliar.length){
                        Producto p = getProducto((70000+(t*100)+i) + "");
                        if(p!=null){
                            Files.deleteIfExists(Paths.get("productos/7 temporada/"+ p.getId() + ".json"));
                            hallados++;
                        }else{
                            break;
                        }
                    }
                }
            }
        }catch(Exception e){
        }

    }

    private static int generarID(int i){
        boolean valido = false;
        int idFormulado = (i*10000)+1;
        while(!valido){
            if(getProducto(idFormulado+"")==null){
                valido = true;
            }else{
                idFormulado++;
            }
        }
        return idFormulado;
    }

    private static int generarIDTemporada(int t){
        boolean valido = false;
        int idFormulado = 70000+(t*100)+1;
        while(!valido){
            if(getProducto(idFormulado+"")==null){
                valido = true;
            }else{
                idFormulado++;
            }
        }
        return idFormulado;
    }



}
