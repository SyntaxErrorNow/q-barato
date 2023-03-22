package com.management;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.awt.Color;

import com.management.Formularios.FormularioBuscarProducto;
import com.management.Formularios.FormularioMostrarProducto;

public class Usuario {
    private String nombre;
    private String cargo;
    private String contrasena;
    private int edad;
    private int ci;

    public Usuario(){
    }

    public Usuario(String nombre, int edad, int ci,String contrasena, String cargo){
        this.nombre = nombre;
        this.edad = edad;
        this.ci = ci;
        this.contrasena = contrasena;
        this.cargo = cargo;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getCi() {
        return ci;
    }
    public void setCi(int ci) {
        this.ci = ci;
    }


    public void mostrarInformacionTodosProductos(){
        File carpeta = new File("productos/");
        List<String> archivos = Arrays.asList(carpeta.list());
        for (String archivo : archivos) {
            int tam = archivo.length();
            Producto producto = Archivo.getProducto(archivo.substring(0, tam - 5));
            System.out.println(producto);
        }
    }
    
    protected void mostrarInformacionProducto(){
        FormularioMostrarProducto form = new FormularioMostrarProducto();
        form.setSize(250,250);
        form.setResizable(false);
        form.setLocationRelativeTo(null);
        form.getContentPane().setBackground(Color.WHITE);
        form.setVisible(true);
    }

    protected void buscarProducto(){
        FormularioBuscarProducto form = new FormularioBuscarProducto();
        form.setSize(700,250);
        form.setResizable(false);
        form.setLocationRelativeTo(null);
        form.getContentPane().setBackground(Color.WHITE);
        form.setVisible(true);
    }


    @Override
    public String toString() {
        return "\nNombre: " + nombre + "\nEdad: " + edad + "\nCi: " + ci + "\nCargo: " + cargo + "\nContraseña: " + contrasena;
    }
}
