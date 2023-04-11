package com.management.Archivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.management.Fecha;
import com.management.Registro;

public class ArchivoRegistro {

    public static Registro getRegistro(String IDRegistro){
        try{
        Reader registro = Files.newBufferedReader(Paths.get("movimientos/"+IDRegistro+".json"));
        Gson gson = new Gson();
        Registro registroReader = gson.fromJson(registro, Registro.class);
        registro.close();
        return registroReader;
    }catch(Exception e){
        }
        return null;
    }

    public static void postRegistro(Registro registros){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("movimientos/"+generarIDRegistro(registros.getFecha()) + ".json"));
            Gson gson = new Gson();
            String json = gson.toJson(registros);
            bw.write(json);
            bw.close();
        }catch(Exception e){
        }
    }


    private static String generarIDRegistro(Fecha fecha){
        int aux = 1;
        boolean valido = false;
        String FechaID = (fecha.getAnio() + "-" + fecha.getMes() + "-" + fecha.getDia());
        while(!valido){
            if(getRegistro(FechaID + " " + aux) == null){
                valido = true;
            }else{
                aux++;
            }
        }
        return (FechaID + " " + aux);
    }

    public static Object [][] getAllDatosRegistros(){
        ArrayList<Registro> registros = new ArrayList<>();
        for(int i = 1; i <= 12; i++){
            for(int j = 2022; j < 2030; j++){
               registros.addAll(ArchivoInventario.recopilarRegistros(i, j));
            }
        }
        Object[][] datosRegistros = new Object[registros.size()][8];
            for (int i = 0; i < registros.size(); i++) {
                Registro registro = registros.get(i);

                datosRegistros[i][0] = registro.getFecha().getAnio();
                datosRegistros[i][1] = registro.getFecha().getMes();
                datosRegistros[i][2] = registro.getFecha().getDia();
                datosRegistros[i][3] = registro.getGanancia();
                datosRegistros[i][4] = registro.getMotivo();
                datosRegistros[i][5] = registro.getProducto().getNombre();
                datosRegistros[i][6] = registro.getProducto().getCategoria();
                datosRegistros[i][7] = registro.getCantidad();
            }
        return datosRegistros;
    }
}
