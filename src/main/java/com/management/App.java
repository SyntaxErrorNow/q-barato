package com.management;

import java.awt.Color;
import java.io.IOException;

import com.management.Formularios.FormularioSesion;


public class App{

    public static void main( String[] args ) throws IOException{

        FormularioSesion form = new FormularioSesion();
        form.setSize(250,300);
        form.setResizable(false);
        form.setLocationRelativeTo(null);
        form.getContentPane().setBackground(Color.WHITE);
        form.setVisible(true);

        //brilla el sol de septiembre radiante


    }


}
