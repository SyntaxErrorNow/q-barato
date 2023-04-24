package com.management;
import com.management.Formularios.Producto.FormularioBuscarProducto;
import com.management.Formularios.Producto.FormularioComprobarExistenciaProducto;
import com.management.Formularios.Producto.FormularioElegirCategoriaReabastecer;
import com.management.Formularios.Producto.FormularioImprimirEtiqueta;
import com.management.Formularios.Producto.FormularioMostrarProducto;
import com.management.Formularios.Producto.FormularioRegistrarMovimientos;
import com.management.Formularios.Producto.FormularioVerificarEstadoProducto;

public class Usuario {
    protected String nombre;
    protected String cargo;
    protected String contrasena;
    protected int edad;
    protected int ci;

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


    protected void mostrarInformacionProducto(){
        new FormularioMostrarProducto();

    }

    protected void buscarProducto(){
        new FormularioBuscarProducto();
    }

    protected void verificarEstadoProducto(){
        new FormularioVerificarEstadoProducto();
    }

    protected void registrarMovimientos(){
        new FormularioRegistrarMovimientos();
    }


    public void comprobarExistenciaProducto(){
        new FormularioComprobarExistenciaProducto();
    }

    protected void imprimirEtiqueta(){
        new FormularioImprimirEtiqueta();
    }

    protected void reabasteserProducto(){
        new FormularioElegirCategoriaReabastecer();
    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre + "\nEdad: " + edad + "\nCi: " + ci + "\nCargo: " + cargo + "\nContraseña: " + contrasena;
    }
}
