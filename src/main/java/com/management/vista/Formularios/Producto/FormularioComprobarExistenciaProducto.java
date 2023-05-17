package com.management.vista.Formularios.Producto;


import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.management.Producto;
import com.management.Archivos.ArchivoProducto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class FormularioComprobarExistenciaProducto extends JFrame implements ActionListener {
    JTextField id;
    JLabel idLabel;
    JButton botonEnvio;
    String idField;

    public FormularioComprobarExistenciaProducto(){
        setLayout(new FlowLayout());

        idLabel = new JLabel("Ingrese el id del producto");
        id = new JTextField(20);

        botonEnvio = new JButton("Buscar");
        botonEnvio.addActionListener(this);


        add(idLabel);
        add(id);
        add(botonEnvio);

        this.setSize(250,200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        idField = id.getText();

        if( idField.equals("")){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");

        }else{
            Producto producto = ArchivoProducto.getProducto(idField);
            if(producto.getId().equals(idField)){
                System.out.println("\n\nQuedan: " + producto.getCantidadDisponible() + " unidades del producto " + producto.getNombre() + "\n\n");
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "El producto no existe");
            }
        }
    }

}
