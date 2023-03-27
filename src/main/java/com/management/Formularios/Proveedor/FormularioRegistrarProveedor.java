package com.management.Formularios.Proveedor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.management.Proveedor;
import com.management.Archivos.ArchivoProveedor;
import com.management.utils.UtilsProveedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;

public class FormularioRegistrarProveedor extends JFrame implements ActionListener {

    JTextField nombre,telefono,listaProductosProveedor;    ;
    JButton botonEnvio;
    JLabel nombreLabel, telefonoLabel,listaProductosProveedorLabel;
    static String nombreField ,telefonoField, listaProductosProveedorField;

    public FormularioRegistrarProveedor(){
        super("Registrar Proveedor");
        setLayout(new FlowLayout());

        nombre = new JTextField(20);
        nombreLabel = new JLabel("Nombre");
        add(nombreLabel);
        add(nombre);


        listaProductosProveedor = new JTextField(20);
        listaProductosProveedorLabel = new JLabel("Ingresa los productos separados por comas ','");
        add(listaProductosProveedorLabel);
        add(listaProductosProveedor);

        telefono = new JTextField(20);
        telefonoLabel = new JLabel("Telefono");
        add(telefonoLabel);
        add(telefono);



        botonEnvio = new JButton();
        botonEnvio.setText("Registrar");
        botonEnvio.addActionListener(this);
        add(botonEnvio);

        this.setSize(250,350);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nombreField = nombre.getText();
        listaProductosProveedorField = listaProductosProveedor.getText();

        if(nombreField.equals("")){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");

        }else{

            Proveedor proveedor = new Proveedor(nombreField, telefonoField, UtilsProveedor.obtenerListaProductos(listaProductosProveedorField));
            ArchivoProveedor.postProveedor(proveedor);
            setVisible(false);
        }
    }

}
