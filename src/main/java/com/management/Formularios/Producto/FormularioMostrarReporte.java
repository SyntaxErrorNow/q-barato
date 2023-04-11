package com.management.Formularios.Producto;

import java.io.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.management.Producto;
import com.management.Archivos.ArchivoProducto;

public class FormularioMostrarReporte  extends JFrame implements ActionListener {
    JLabel texto;
    JButton botonEnvio;
    FileWriter archivo = null;
    PrintWriter escritor = null;
    JTextField ID;
    
    public FormularioMostrarReporte(){
        setLayout(new FlowLayout());
        texto = new JLabel("ID del producto");
        ID = new JTextField(20);
        ID.addActionListener(this);
        botonEnvio = new JButton("Crear Reporte");
        botonEnvio.addActionListener(this);

        add(texto);
        add(ID);
        add(botonEnvio);
        this.setSize(250,250);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.getContentPane().setBackground(Color.WHITE);
            this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){String IDField = ID.getText();
        Producto producto = ArchivoProducto.getProducto(IDField);
        try{
            archivo = new FileWriter("D:\\pruebas\\producto" + IDField+".txt");
            escritor = new PrintWriter(archivo);
            escritor.println("---------- REPORTE PRODUCTO" + IDField + " ----------");
            escritor.println("");
            escritor.println("-> NOMBRE DEL PRODUCTO " + producto.getNombre());
            escritor.println("-> MARCA DEL PRODUCTO " + producto.getMarca());
            escritor.println("-> CATEGORIA DEL PRODUCTO " + producto.getCategoria());
            escritor.println("-> PRECIO DEL PRODUCTO " + producto.getPrecio());
            escritor.println("-> PROVEEDOR DEL PRODUCTO " + producto.getProveedor());
            escritor.println("-> CANTIDAD ADQUIRIDA " + producto.getCantidadAdquirida());
            escritor.println("-> CANTIDAD VENDIDA " + producto.getCantidadVendida());
            escritor.println("-> GANANCIAS DEL PRODUCTO " + (producto.getCantidadVendida() * producto.getPrecio()));
            escritor.println("-> CANTIDAD DISPONIBLE " + producto.getCantidadDisponible());
        }catch (Exception e1){
            System.out.println("Error " + e1.getMessage());
        }finally{
            try{
                archivo.close();
            }catch(Exception e2){
                System.out.println("Error " + e2.getMessage());
            }
        }
    }
}

