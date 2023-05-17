package com.management.vista.Formularios.Proveedor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.management.Proveedor;
import com.management.Archivos.ArchivoProveedor;
import com.management.modelo.utils.UtilsProveedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;

public class FormularioModificarProveedor extends JFrame implements ActionListener {

    private Proveedor proveedor;
    JTextField nombre, telefono,proveedorProductos;
    JButton botonEnvio;
    JLabel nombreLabel, telefonoLabel,proveedorProductosLabel;
    String nombreField, telefonoField,proveedorProductosField ;



    public FormularioModificarProveedor(Proveedor proveedor){
        super("Modificar proveedor");
        this.proveedor = proveedor;
        setLayout(new FlowLayout());
        nombre = new JTextField(20);
        nombre.setText(proveedor.getNombre());
        nombreLabel = new JLabel("Nombre");
        add(nombreLabel);
        add(nombre);

        telefono = new JTextField(20);
        telefono.setText(proveedor.getTelefono());
        telefonoLabel = new JLabel("Telefono");
        add(telefonoLabel);
        add(telefono);


        proveedorProductos = new JTextField(20);
        proveedorProductos.setText(UtilsProveedor.obtenerListaProductos(proveedor.getProductosProveedor()));
        proveedorProductosLabel = new JLabel("Ingrese los productos con comas ','");
        add(proveedorProductosLabel);
        add(proveedorProductos);



        botonEnvio = new JButton();
        botonEnvio.setText("Modificar");
        botonEnvio.addActionListener(this);
        add(botonEnvio);

        this.setSize(250,350);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nombreField = nombre.getText();
        telefonoField = telefono.getText();
        proveedorProductosField = proveedorProductos.getText();

        if(nombreField.equals("") || telefonoField.equals("")){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");

        }else{
            Proveedor proveedor = new Proveedor(nombreField, telefonoField, UtilsProveedor.obtenerListaProductos(proveedorProductosField));
            proveedor.setId(this.proveedor.getId());
            ArchivoProveedor.postProveedor(proveedor);
            setVisible(false);
        }
    }

}
