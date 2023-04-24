package com.management.data;
import java.util.HashMap;

public class DataProducto {


    public static String [] opcionesSubCategoria(String categoria){
        String [] bebidas = {"jugos", "gaseosas", "alcoholica", "naturales", "derivado de lacteos"};
        String [] comestibles = {"dulces", "postres", "helados", "frituras", "derivados de cereales"};
        String [] despensas = {"verduras", "frutas", "condimentos", "carne", "lacteos", "cereales"};
        String [] aseo = {"detergentes", "lavavajillas", "utensilios", "desinfectantes"};
        String [] cuidadoPersonal = {"jabones", "shampoo", "cremas", "productos dentales", "cuidado intimo"};
        String [] otros = {"otros"};

        HashMap<String, String []> opciones = new HashMap<>();
        opciones.put("despensa", despensas);
        opciones.put("comestibles", comestibles);
        opciones.put("bebidas", bebidas);
        opciones.put("aseo", aseo);
        opciones.put("cuidado personal", cuidadoPersonal);
        opciones.put("otros", otros);
        return opciones.get(categoria);
    }

    public static String [] obtenerCategorias(){
        String [] categorias = { "despensa", "comestibles", "bebidas", "aseo", "cuidado personal", "otros" };
        return categorias;
    }

    public static String [] obtenerSubCategorias(){
        String [] subCategorias = {
            "jugos", "gaseosas", "alcoholica", "naturales", "derivado de lacteos",
            "dulces", "postres", "helados", "frituras", "derivados de cereales",
            "verduras", "frutas", "condimentos", "carne", "lacteos", "cereales",
            "detergentes", "lavavajillas", "utensilios", "desinfectantes",
            "jabones", "shampoo", "cremas", "productos dentales", "cuidado intimo",
            "otros"};
        return subCategorias;
    }


    public static String [] obtenerTemporadas(){
        String [] temporadas = { "1 Enero - Escolar", "2 Febrero - Carnaval", "3 Marzo",
                                "4 Abril - Pascua", "5 Mayo", "6 Junio", "7 Julio", "8 Agosto", "9 Septiembre - Primavera",
                                "10 Octubre ", "11 Noviembre - Halloween", "12 Diciembre - Navidad y fin de anio"
        };

        return temporadas;
    }


    public static String obtenerDescuento(String temporada){
        HashMap<String, String> descuentos = new HashMap<>();
        descuentos.put("1 Enero - Escolar", "15");
        descuentos.put("2 Febrero - Carnaval", "20");
        descuentos.put("3 Marzo", "5");
        descuentos.put("4 Abril - Pascua", "17");
        descuentos.put("5 Mayo", "30");
        descuentos.put("6 Junio", "10");
        descuentos.put("7 Julio", "10");
        descuentos.put("8 Agosto", "25");
        descuentos.put("9 Septiembre - Primavera", "30");
        descuentos.put("10 Octubre ", "10");
        descuentos.put("11 Noviembre - Halloween", "25");
        descuentos.put("12 Diciembre - Navidad y fin de anio", "40");
        return descuentos.get(temporada);
    }

}
