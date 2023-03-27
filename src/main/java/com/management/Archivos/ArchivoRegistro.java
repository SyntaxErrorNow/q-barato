package com.management.Archivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.management.Fecha;
import com.management.Registro;

public class ArchivoRegistro {

    public static Registro getRegistro(String IDRegistro){
        try{
        Reader registro = Files.newBufferedReader(Paths.get("movimientos/"  + IDRegistro + ".json"));
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
        int FechaID = (fecha.getAnio() * 10000 + fecha.getMes() * 100 + fecha.getDia());
        while(!valido){
            if(getRegistro(FechaID + " " + aux) == null){
                valido = true;
            }else{
                aux++;
            }
        }
        return (FechaID + " " + aux);
    }
}
