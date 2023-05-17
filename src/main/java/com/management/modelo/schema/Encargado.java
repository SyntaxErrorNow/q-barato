package com.management.modelo.schema;


import com.management.vista.Formularios.Producto.FormularioBorrarProductosDeUnaCategoria;
import com.management.vista.Formularios.Producto.FormularioDescuento;
import com.management.vista.Formularios.Producto.FormularioRegistrarProducto;
import com.management.vista.Formularios.Producto.FormularioRegistrarProductoTemporada;
import com.management.vista.Formularios.Proveedor.FormularioRegistrarProveedor;
import com.management.vista.Formularios.Usuario.FormularioRegistrarUsuario;


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
