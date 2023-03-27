package com.management.Archivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.management.Encargado;
import com.management.Usuario;

public class ArchivoUsuario {

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
}
