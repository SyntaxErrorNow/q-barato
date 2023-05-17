package com.management.modelo.schema;


import org.bson.codecs.pojo.annotations.BsonProperty;

public class Usuario {
    @BsonProperty("nombre")
    private String nombre;

    @BsonProperty("cargo")
    private String cargo;

    @BsonProperty("contrasena")
    private String contrasena;

    @BsonProperty("edad")
    private int edad;

    @BsonProperty("ci")
    private int ci;

    public Usuario(String nombre, int edad, int ci,String contrasena, String cargo){
        this.nombre = nombre;
        this.edad = edad;
        this.ci = ci;
        this.contrasena = contrasena;
        this.cargo = cargo;
    }

    public Usuario(){

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


    @Override
    public String toString() {
        return "\nNombre: " + nombre + "\nEdad: " + edad + "\nCi: " + ci + "\nCargo: " + cargo + "\nContraseña: " + contrasena;
    }
}
