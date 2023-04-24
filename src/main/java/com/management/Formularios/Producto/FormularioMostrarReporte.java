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
            BufferedWriter archivo = new BufferedWriter(new FileWriter("reporteProducto/" + IDField+".txt"));
            archivo.write( "\n---------- REPORTE PRODUCTO" + IDField + " ----------" +
                           "\n-> NOMBRE DEL PRODUCTO " + producto.getNombre() +
                           "\n-> MARCA DEL PRODUCTO " + producto.getMarca() +
                           "\n-> CATEGORIA DEL PRODUCTO " + producto.getCategoria() +
                           "\n-> PRECIO DEL PRODUCTO " + producto.getPrecio() +
                           "\n-> PROVEEDOR DEL PRODUCTO " + producto.getProveedor() +
                           "\n-> CANTIDAD ADQUIRIDA " + producto.getCantidadAdquirida() +
                           "\n-> CANTIDAD VENDIDA " + producto.getCantidadVendida() +
                           "\n-> GANANCIAS DEL PRODUCTO " + (producto.getCantidadVendida() * producto.getPrecio()) +
                           "\n-> CANTIDAD DISPONIBLE " + producto.getCantidadDisponible() 
            );
        
            archivo.close();
        }catch (Exception e1){
            System.out.println("Error " + e1.getMessage());
        }finally{
            try{
            }catch(Exception e2){
                System.out.println("Error " + e2.getMessage());
            }
        }
    }
}

