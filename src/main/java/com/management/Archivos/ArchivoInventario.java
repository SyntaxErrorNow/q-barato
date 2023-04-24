package com.management.Archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.management.Inventario;
import com.management.Producto;
import com.management.Registro;
import com.management.utils.UtilsCategoria;


public class ArchivoInventario  {

    public static Inventario getInventario(String IDInventario){
        try{
        Reader registros = Files.newBufferedReader(Paths.get("inventarios/"  + IDInventario + ".json"));
        Gson gson = new Gson();
        Inventario registroReader = gson.fromJson(registros, Inventario.class);
        registros.close();
        return registroReader;
    }catch(Exception e){
        }
        return null;
    }

    public static void postInventario(Inventario inventario){
        try{
            inventario.setIDInventario(generarIDInventario(inventario.getPeriodo(), inventario.getAnio()));
            BufferedWriter bw = new BufferedWriter(new FileWriter("inventarios/"+inventario.getIDInventario() + ".json"));
            Gson gson = new Gson();
            String json = gson.toJson(inventario);
            bw.write(json);
            bw.close();
        }catch(Exception e){
        }
    }




    private static String generarIDInventario(int periodo, int anio){
        int aux = 1;
        boolean valido = false;
        String IDInventario = anio+"-"+periodo;
        while(!valido){
            if(getInventario(IDInventario+" "+aux) == null){
                valido = true;
            }else{
                aux++;
            }
        }
        return (IDInventario + " " + aux);
    }

    public static void modifyInventario(Inventario inventario){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("inventarios/"+ inventario.getIDInventario() + ".json"));
            Gson gson = new Gson();
            String json = gson.toJson(inventario);
            bw.write(json);
            bw.close();
        }catch(Exception e){
        }
    }
    public static List<Entry<String, Integer>> getProductosMasVendidos(ArrayList<Registro> registros){
        Map<String, Integer> mapaProductos = new HashMap<>();
        registros.sort(Comparator.comparing(Registro::getCantidad).reversed());
        for (Registro registro : registros) {
            String nombre = registro.getProducto().getNombre();
            int cantidad = registro.getCantidad();
            if (mapaProductos.containsKey(nombre)) {
                int cantidadAcumulada = mapaProductos.get(nombre);
                cantidadAcumulada += cantidad;
                mapaProductos.put(nombre, cantidadAcumulada);
            } else {
                mapaProductos.put(nombre, cantidad);
            }
        }
        List<Entry<String, Integer>> list = new ArrayList<>(mapaProductos.entrySet());
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return list;
    }

    public static ArrayList<Producto> recopilarProductosDelMomento(){
        ArrayList<Producto> productos = new ArrayList<>();
        for(int i = 1; i <= 6; i++){
            productos.addAll(ArchivoProducto.getProductoPorCategoria(UtilsCategoria.obtenerPathId(i + "")));
        }
        productos.addAll(ArchivoProducto.getProductoTemporales());
        return productos;
    }

    public static void deleteProducto(Inventario inventario){
        try{
            Files.deleteIfExists(Paths.get("inventarios/"+ inventario.getIDInventario()+ ".json"));
        }catch(Exception e){
        }
    }

    public static ArrayList<Registro> recopilarRegistros(int periodo, int anio){
        ArrayList<Registro> registros = new ArrayList<>();
        File[] fAuxiliar = new File("movimientos").listFiles();
        int hallados = 0;
        for(int d = 1; d <= 31; d++){
            for(int i = 1; i <= 10; i++){
                if(hallados<fAuxiliar.length){
                    Registro r = ArchivoRegistro.getRegistro(anio+"-"+periodo+"-"+d+" "+i);
                    if(r != null){
                        registros.add(r);
                        hallados++;
                    }
                }else{
                    break;
                }
            }
        }
        return registros;
    }

    public static ArrayList<Inventario> recopilarInventarios(){
        ArrayList<Inventario> inventarios = new ArrayList<>();
        File[] fAuxiliar = new File("inventarios").listFiles();
        int hallados = 0;
        for(int anio = 2023; anio<=2030; anio++){
            for(int mes = 1; mes<= 12; mes++){
                for(int i = 1; i<= 99; i++){
                    if(hallados<fAuxiliar.length){
                        Inventario inv = getInventario(anio+"-"+mes+" "+i);
                        if(inv != null){
                            inventarios.add(inv);
                            hallados++;
                        }
                    }else{
                        break;
                    }
                }
            }
        }
        return inventarios;
    }

    public static Object [][] getAllDatosInventarios(){
        ArrayList<Inventario> inventarios = new ArrayList<>();
        inventarios = recopilarInventarios();


        Object[][] datosInventarios = new Object[inventarios.size()][12];
            for (int i = 0; i < inventarios.size(); i++) {
                Inventario inventario = inventarios.get(i);

                datosInventarios[i][0] = inventario.getAnio();
                datosInventarios[i][1] = inventario.getPeriodo();
                datosInventarios[i][2] = inventario.getIDInventario();
                datosInventarios[i][3] = inventario.getGanancias();
                datosInventarios[i][4] = inventario.getPerdida();
                datosInventarios[i][5] = inventario.getGanancias() - inventario.getPerdida();
                datosInventarios[i][6] = inventario.getCantidadVendida();
                datosInventarios[i][7] = inventario.getCantidadPerdida();
                datosInventarios[i][8] = inventario.getCantidadAdquirida();
                datosInventarios[i][9] = inventario.getCapitalInvertido();
                datosInventarios[i][10] = "Ver mas";
                datosInventarios[i][11] = "📄";
              
            }
        return datosInventarios;
    }


}
