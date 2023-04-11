package com.management.Archivos;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

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

    public static Object[][] getAllEmpleados(){
        try {
            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
            File carpeta1 = new File("usuarios/");
            java.util.List<String> usuariosCi = Arrays.asList(carpeta1.list());
            for (String usuarioId : usuariosCi) {
                Usuario usuario = getUser(Integer.parseInt(obtenerId(usuarioId)));
                if(usuario.getCargo().equals("empleado")){
                    usuarios.add(usuario);
                }
            }

            Object[][] datosEmpleados = new Object[usuarios.size()][6];
            for (int i = 0; i < usuarios.size(); i++) {
                Usuario usuario = usuarios.get(i);
                datosEmpleados[i][0] = "" + usuario.getCi();
                datosEmpleados[i][1] = usuario.getNombre();
                datosEmpleados[i][2] = usuario.getCargo();
                datosEmpleados[i][3] = "" + usuario.getEdad();
                datosEmpleados[i][4] = ":";
                datosEmpleados[i][5] = "-";
            }

            return datosEmpleados;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static String obtenerId(String archivoJSON){
        return archivoJSON.substring(0, archivoJSON.length() - 5);
    };


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
