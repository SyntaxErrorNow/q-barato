package com.management;


import com.management.Formularios.Producto.FormularioBorrarProducto;
import com.management.Formularios.Producto.FormularioBorrarProductosDeUnaCategoria;
import com.management.Formularios.Producto.FormularioDescuento;
import com.management.Formularios.Producto.FormularioModificarProducto;
import com.management.Formularios.Producto.FormularioRegistrarProducto;
import com.management.Formularios.Producto.FormularioRegistrarProductoTemporada;
import com.management.Formularios.Proveedor.FormularioEliminarProveedor;
import com.management.Formularios.Proveedor.FormularioPedirIDProveedor;
import com.management.Formularios.Proveedor.FormularioRegistrarProveedor;
import com.management.Formularios.Usuario.FormularioBorrarUsuario;
import com.management.Formularios.Usuario.FormularioModificarUsuario;
import com.management.Formularios.Usuario.FormularioRegistrarUsuario;


public class Encargado extends Usuario{


    public Encargado(String nombre, int edad, int ci,String contrasena, String cargo){
        super(nombre, edad, ci, contrasena, cargo);
    }

    public void registrarEmpleado(){
       new FormularioRegistrarUsuario();

    }

    public void modificarEmpleado(){
        new FormularioModificarUsuario();
    }

    public void eliminarEmpleado(){
        new FormularioBorrarUsuario();

    }

    public void registrarProducto(){
        new FormularioRegistrarProducto();
    }

    public void registrarProductoPorTemporada(){
       new FormularioRegistrarProductoTemporada();
    }

    public void modificarProducto(){
        new FormularioModificarProducto();
    }

    public void eliminarProducto(){
        new FormularioBorrarProducto();
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
        new FormularioPedirIDProveedor();
    }

    public void eliminarProveedor(){
        new FormularioEliminarProveedor();
    }
}
