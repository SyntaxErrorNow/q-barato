package com.management.utils;

public class UtilsCategoria {


    public static int obtenerNumeroCategoria(String categoria){
        if(categoria.equals("despensa")){
            return 1;
        }
        if(categoria.equals("comestibles")){
            return 2;
        }
        if(categoria.equals("bebidas")){
            return 3;
        }
        if(categoria.equals("aseo")){
            return 4;
        }
        if(categoria.equals("cuidado personal")){
            return 5;
        }if(categoria.equals("temporada")){
            return 7;
        }else{
            return 6;
        }
    }

    public static String validarCategoria(String categoriaIngresada){
        String categoria = categoriaIngresada.toLowerCase();
        if(categoria.equals("despensa") || categoria.equals("comestibles") || categoria.equals("bebidas") ||
           categoria.equals("aseo") || categoria.equals("cuidado personal")){
            return categoria;
        }else{
            return "otros";
        }
    }

    public static String obtenerPathId(String digito){
        if(digito.equals("1")){
            return "despensa";
        }
        if(digito.equals("2")){
            return "comestibles";
        }
        if(digito.equals("3")){
            return "bebidas";
        }
        if(digito.equals("4")){
            return "aseo";
        }
        if(digito.equals("5")){
            return "cuidado personal";
        }if(digito.equals("7")){
            return "temporada";
        }

        return "otros";

    }

}
