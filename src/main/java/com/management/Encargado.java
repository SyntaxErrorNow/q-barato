package com.management;


import com.management.Formularios.Producto.FormularioBorrarProductosDeUnaCategoria;
import com.management.Formularios.Producto.FormularioDescuento;
import com.management.Formularios.Producto.FormularioRegistrarProducto;
import com.management.Formularios.Producto.FormularioRegistrarProductoTemporada;
import com.management.Formularios.Proveedor.FormularioRegistrarProveedor;
import com.management.Formularios.Usuario.FormularioRegistrarUsuario;


public class Encargado extends Usuario{


    public Encargado(String nombre, int edad, int ci,String contrasena, String cargo){
        super(nombre, edad, ci, contrasena, cargo);
    }

    public void registrarEmpleado(){
       new FormularioRegistrarUsuario();

    }

    public void modificarEmpleado(){
    }

    public void eliminarEmpleado(){

    }

    public void registrarProducto(){
        new FormularioRegistrarProducto();
    }

    public void registrarProductoPorTemporada(){
       new FormularioRegistrarProductoTemporada();
    }

    public void modificarProducto(){
    }

    public void eliminarProducto(){
    }

    public void eliminarProductosPorCategoria(){
        new FormularioBorrarProductosDeUnaCategoria();
    }

    public void sugerirDescuento(){
        new FormularioDescuento();
    }

    public void registrarProveedor(){
        new FormularioRegistrarProveedor();
    }

    public void modificarProveedor(){
    }

    public void eliminarProveedor(){
    }
}
