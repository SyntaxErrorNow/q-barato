package com.management;
import java.awt.Color;

import com.management.Formularios.FormularioModificarUsuario;
import com.management.Formularios.FormularioBorrarProducto;
import com.management.Formularios.FormularioBorrarUsuario;
import com.management.Formularios.FormularioModificarProducto;
import com.management.Formularios.FormularioRegistrarProducto;
import com.management.Formularios.FormularioRegistrarUsuario;


public class Encargado extends Usuario{


    public Encargado(String nombre, int edad, int ci,String contrasena, String cargo){
        super(nombre, edad, ci, contrasena, cargo);
    }

    public void registrarEmpleado(){
        FormularioRegistrarUsuario form = new FormularioRegistrarUsuario();
        form.setSize(250,350);
        form.setResizable(false);
        form.setLocationRelativeTo(null);
        form.getContentPane().setBackground(Color.WHITE);
        form.setVisible(true);
    }

    public void modificarEmpleado(){
        FormularioModificarUsuario form = new FormularioModificarUsuario();
        form.setSize(250,200);
        form.setResizable(false);
        form.setLocationRelativeTo(null);
        form.getContentPane().setBackground(Color.WHITE);
        form.setVisible(true);
    }

    public void eliminarEmpleado(){
        FormularioBorrarUsuario form = new FormularioBorrarUsuario();
        form.setSize(250,250);
        form.setResizable(false);
        form.setLocationRelativeTo(null);
        form.getContentPane().setBackground(Color.WHITE);
        form.setVisible(true);
    }

    public void registrarProducto(){
        FormularioRegistrarProducto form = new FormularioRegistrarProducto();
        form.setSize(250,600);
        form.setResizable(false);
        form.setLocationRelativeTo(null);
        form.getContentPane().setBackground(Color.WHITE);
        form.setVisible(true);
    }

    public void modificarProducto(){
        FormularioModificarProducto form = new FormularioModificarProducto();
        form.setSize(250,200);
        form.setResizable(false);
        form.setLocationRelativeTo(null);
        form.getContentPane().setBackground(Color.WHITE);
        form.setVisible(true);
    }

    public void eliminarProducto(){
        FormularioBorrarProducto form = new FormularioBorrarProducto();
        form.setSize(250,200);
        form.setResizable(false);
        form.setLocationRelativeTo(null);
        form.getContentPane().setBackground(Color.WHITE);
        form.setVisible(true);
    }
}
