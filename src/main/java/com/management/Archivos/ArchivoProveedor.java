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
import com.management.Proveedor;


public class ArchivoProveedor {

    public static Proveedor getProveedor(String id){
        try{
            Reader proveedor = Files.newBufferedReader(Paths.get("proveedores/" + id + ".json"));
            Gson gson = new Gson();
            Proveedor proveedorReader = gson.fromJson(proveedor, Proveedor.class);
            proveedor.close();
            return proveedorReader;
        }catch(Exception e){
        }
        return null;
    }

    public static void postProveedor(Proveedor proveedor){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("proveedores/"+ proveedor.getId() + ".json"));
            Gson gson = new Gson();
            String json = gson.toJson(proveedor);
            bw.write(json);
            bw.close();
        }catch(Exception e){
        }
    }

    public static void deleteProveedor(String id){
        try{
            Files.deleteIfExists(Paths.get("proveedores/" + id + ".json"));
        }catch(Exception e){
        }
    }

    public static ArrayList<Proveedor> getAllProveedores(){
        try {
            ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
            File carpeta1 = new File("proveedores/");
            java.util.List<String> proveedores = Arrays.asList(carpeta1.list());
            for (String proveedorId : proveedores) {
                Proveedor proveedor = ArchivoProveedor.getProveedor(obtenerId(proveedorId));
                listaProveedores.add(proveedor);
            }
            return listaProveedores;
        } catch (Exception e) {
            return null;
        }
    }

    public static Proveedor getProveedorByNombre(String nombre){
        try{
            File carpeta1 = new File("proveedores/");
            java.util.List<String> proveedores = Arrays.asList(carpeta1.list());
            for (String proveedorId : proveedores) {
                Proveedor proveedor = ArchivoProveedor.getProveedor(obtenerId(proveedorId));
                if(proveedor.getNombre().equals(nombre)){
                    return proveedor;
                }
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }

    public static Object[][] getAllDatosProveedores(){
        try {
            ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
            File carpeta1 = new File("proveedores/");
            java.util.List<String> proveedoresId = Arrays.asList(carpeta1.list());
            for (String proveedoreId : proveedoresId) {
                Proveedor proveedor = getProveedor(obtenerId(proveedoreId));
                    proveedores.add(proveedor);
            }

            Object[][] datosProveedores = new Object[proveedores.size()][6];
            for (int i = 0; i < proveedores.size(); i++) {
                Proveedor proveedor = proveedores.get(i);
                datosProveedores[i][0] = proveedor.getId();
                datosProveedores[i][1] = proveedor.getNombre() ;
                datosProveedores[i][2] = proveedor.getTelefono();
                datosProveedores[i][3] = proveedor.getProductosProveedor().toString().replace("[", "").replace("]", "");
                datosProveedores[i][4] = ":";
                datosProveedores[i][5] = "-";
            }

            return datosProveedores;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static String obtenerId(String archivoJSON){
        return archivoJSON.substring(0, archivoJSON.length() - 5);
    };
}
