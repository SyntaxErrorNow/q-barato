package com.management.Formularios;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.management.Archivo;
import com.management.Producto;
import com.management.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.FlowLayout;

public class FormularioRegistrarProducto extends JFrame implements ActionListener, ItemListener {
    JButton botonEnvio;
    JTextField nombre, precio, descripcion, marca, proveedor, cantidadAdquirida, fechaCompra, fechaCaducidad;
    JComboBox<String> categoria, subcategoria;
    JLabel nombreLabel, precioLabel, descripcionLabel, marcaLabel, categoriaLabel, subcategoriaLabel, proveedorLabel, cantidadAdquiridaLabel, fechaCompraLabel, fechaCaducidadLabel;
    static String nombreField, precioField, descripcionField, marcaField, categoriaField, subcategoriaField, proveedorField, cantidadAdquiridaField, fechaCompraField, fechaCaducidadField;
    String [] categorias = { "despensas", "comestibles", "bebidas", "aseo", "cuidado personal", "otros" };
    String [] subCategorias = {"gaseosas", "jugos", "frutas", "verduras", "shampoo", "otros"};


    public FormularioRegistrarProducto(){
        super("Registrar Producto");
        setLayout(new FlowLayout());

        nombre = new JTextField(20);
        nombreLabel = new JLabel("Nombre del producto");

        precio = new JTextField(20);
        precioLabel = new JLabel("Precio");
        Utils.numDouble(precio);

        descripcion = new JTextField(20);
        descripcionLabel = new JLabel("Descripcion");

        marca = new JTextField(20);
        marcaLabel = new JLabel("Marca");

        categoria = new JComboBox<String>(categorias);
        categoriaLabel = new JLabel("Categoria");
        categoria.addItemListener(this);

        subcategoria = new JComboBox<String>(subCategorias);
        subcategoriaLabel = new JLabel("Subcategoria");


        proveedor = new JTextField(25);
        proveedorLabel = new JLabel("Proveedor");

        cantidadAdquirida = new JTextField(20);
        cantidadAdquiridaLabel = new JLabel("Cantidad adquirida");
        Utils.numInteger(cantidadAdquirida);

        fechaCompra = new JTextField(20);
        fechaCompraLabel = new JLabel("Fecha de compra");

        fechaCaducidad = new JTextField(20);
        fechaCaducidadLabel = new JLabel("Fecha de caducidad");

        botonEnvio = new JButton();
        botonEnvio.setText("Buscar");
        botonEnvio.addActionListener(this);

        add(nombreLabel);
        add(nombre);
        add(precioLabel);
        add(precio);
        add(descripcionLabel);
        add(descripcion);
        add(marcaLabel);
        add(marca);
        add(categoriaLabel);
        add(categoria);
        add(subcategoriaLabel);
        add(subcategoria);
        add(proveedorLabel);
        add(proveedor);
        add(cantidadAdquiridaLabel);
        add(cantidadAdquirida);
        add(fechaCompraLabel);
        add(fechaCompra);
        add(fechaCaducidadLabel);
        add(fechaCaducidad);
        add(botonEnvio);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == categoria) {
            String seleccionado = (String)categoria.getItemAt(categoria.getSelectedIndex());
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(Utils.opciones(seleccionado));
            subcategoria.setModel(model);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        nombreField = nombre.getText();
        precioField = precio.getText();
        descripcionField = descripcion.getText();
        marcaField = marca.getText();
        categoriaField = (String)categoria.getItemAt(categoria.getSelectedIndex());
        subcategoriaField = (String)subcategoria.getItemAt(subcategoria.getSelectedIndex());
        proveedorField = proveedor.getText();
        int cantidadAdquiridaField = Integer.parseInt(cantidadAdquirida.getText());
        fechaCompraField = fechaCompra.getText();
        fechaCaducidadField = fechaCaducidad.getText();


        if( nombreField.equals("") || precioField.equals("") || descripcionField.equals("") || marcaField.equals("") ||
            categoriaField.equals("") || subcategoriaField.equals("") || proveedorField.equals("") ||
            cantidadAdquiridaField <= 0 || fechaCompraField.equals("") || fechaCaducidadField.equals("")
        ){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");

        }else{
            ArrayList<String> subtipos = new ArrayList<>();
            subtipos = new ArrayList<>(Arrays.asList(Archivo.determinarSubcategorias(categoriaField)));
            if(subtipos.contains(subcategoriaField)){
                Producto producto = new Producto(nombreField, descripcionField, marcaField, categoriaField, subcategoriaField, Double.parseDouble(precioField), proveedorField, cantidadAdquiridaField, fechaCompraField, fechaCaducidadField);
                Archivo.postProducto(producto);
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Subcategoria inexistente");
            }
        }
    }
}
