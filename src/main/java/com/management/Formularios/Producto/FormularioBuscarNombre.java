package com.management.Formularios.Producto;

import javax.swing.*;
import com.management.Producto;
import com.management.Archivos.ArchivoProducto;
import com.management.utils.UtilsProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.FlowLayout;

public class FormularioBuscarNombre extends JFrame implements ActionListener {
    JTextField nombre;
    JLabel texto, ordenLabel;
    JComboBox<String> orden;
    JButton botonEnvio;

    String[] ordenamientos = {"Alfabeticamente","Por categoria","Por precio de menor a mayor", "Por precio de mayor a menor"};
    static String categoriaField;

    public FormularioBuscarNombre(){
        setLayout(new FlowLayout());
        texto = new JLabel("Nombre del producto");
        nombre = new JTextField(20);

        orden = new JComboBox<>(ordenamientos);
        orden.addActionListener(this);
        ordenLabel = new JLabel("Ordernar: ");
        botonEnvio = new JButton();
        botonEnvio.setText("Buscar");
        botonEnvio.addActionListener(this);
        add(texto);
        add(nombre);
        add(ordenLabel);
        add(orden);
        add(botonEnvio);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String nombreField = nombre.getText();
        String ordenField = (String)orden.getItemAt(orden.getSelectedIndex());
        nombreField.toLowerCase();
        if(nombreField.equals("")){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");
        }else{
            ArrayList<Producto> productosNombre = ArchivoProducto.getProductoPorNombre(nombreField);
            ArrayList<Producto> Ordenados = UtilsProducto.ordenarListas(productosNombre, ordenField);
            for(int i = 0; i<Ordenados.size(); i++){
                System.out.println(Ordenados.get(i).toString());
            }
            setVisible(false);
        }
    }
}
