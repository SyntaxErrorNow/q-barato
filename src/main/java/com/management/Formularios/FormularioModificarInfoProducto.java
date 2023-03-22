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

public class FormularioModificarInfoProducto extends JFrame implements ActionListener , ItemListener{
    private String idProducto;
    JButton botonEnvio;
    JTextField nombre, precio, descripcion, marca, proveedor, cantidadAdquirida, fechaCompra, fechaCaducidad;
    JComboBox<String> categoria, subCategoria;
    JLabel idLabel, nombreLabel, precioLabel, descripcionLabel, marcaLabel, categoriaLabel, subCategoriaLabel, proveedorLabel, cantidadAdquiridaLabel, fechaCompraLabel, fechaCaducidadLabel;
    static String nombreField, precioField, descripcionField, marcaField, categoriaField, subCategoriaField, proveedorField, cantidadAdquiridaField, fechaCompraField, fechaCaducidadField;
    String [] categorias = { "despensas", "comestibles", "bebidas", "aseo", "cuidado personal", "otros" };
    String [] subCategorias = {"gaseosas", "jugos", "frutas", "verduras", "shampoo", "otros"};


    public FormularioModificarInfoProducto(Producto producto){
        super("Datos de Producto");
        this.idProducto = producto.getId();
        setLayout(new FlowLayout());


        idLabel = new JLabel("ID DEL PRODUCTO:" + idProducto);

        nombre = new JTextField(20);
        nombre.setText(producto.getNombre());
        nombreLabel = new JLabel("Nombre del producto");

        precio = new JTextField(20);
        precio.setText(String.valueOf(producto.getPrecio()));
        precioLabel = new JLabel("Precio Unitario");
        Utils.numDouble(precio);

        descripcion = new JTextField(20);
        descripcion.setText(producto.getDescripcion());
        descripcionLabel = new JLabel("Descripcion");

        marca = new JTextField(20);
        marca.setText(producto.getMarca());
        marcaLabel = new JLabel("Marca");

        categoria = new JComboBox<String>(categorias);
        categoria.setSelectedItem(producto.getCategoria());
        categoriaLabel = new JLabel("Categoria");
        categoria.addItemListener(this);

        subCategoria = new JComboBox<String>(subCategorias);
        subCategoria.setSelectedItem(producto.getSubCategoria());
        subCategoriaLabel = new JLabel("Subcategoria");

        proveedor = new JTextField(20);
        proveedor.setText(producto.getProveedor());
        proveedorLabel = new JLabel("Proveedor");

        cantidadAdquirida = new JTextField(20);
        cantidadAdquirida.setText(String.valueOf(producto.getCantidadDisponible()));
        cantidadAdquiridaLabel = new JLabel("Cantidad Adquirida");
        Utils.numInteger(cantidadAdquirida);

        fechaCompra = new JTextField(20);
        fechaCompra.setText(String.valueOf(producto.getFechaCompra()));
        fechaCompraLabel = new JLabel("Fecha Compra");

        fechaCaducidad = new JTextField(20);
        fechaCaducidad.setText(String.valueOf(producto.getFechaCaducidad()));
        fechaCaducidadLabel = new JLabel("Fecha Caducidad");

        botonEnvio = new JButton();
        botonEnvio.setText("Modificar");
        botonEnvio.addActionListener(this);

        add(idLabel);
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
        add(subCategoriaLabel);
        add(subCategoria);
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
            subCategoria.setModel(model);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nombreField = nombre.getText();
        precioField = precio.getText();
        descripcionField = descripcion.getText();
        marcaField = marca.getText();
        categoriaField = (String)categoria.getItemAt(categoria.getSelectedIndex());
        subCategoriaField = (String)subCategoria.getItemAt(subCategoria.getSelectedIndex());
        proveedorField = proveedor.getText();
        int cantidadAdquiridaField = Integer.parseInt(cantidadAdquirida.getText());
        fechaCompraField = fechaCompra.getText();
        fechaCaducidadField = fechaCaducidad.getText();


        if( nombreField.equals("") || precioField.equals("") || descripcionField.equals("") || marcaField.equals("") ||
            categoriaField.equals("") || subCategoriaField.equals("") || proveedorField.equals("") ||
            cantidadAdquiridaField <= 0 || fechaCompraField.equals("") || fechaCaducidadField.equals("")
        ){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");

        }else{
            ArrayList<String> subtipos = new ArrayList<>();
            subtipos = new ArrayList<>(Arrays.asList(Archivo.determinarSubcategorias(categoriaField)));
            if(subtipos.contains(subCategoriaField)){
                Producto producto = new Producto(nombreField, descripcionField, marcaField, categoriaField, subCategoriaField, Double.parseDouble(precioField), proveedorField, cantidadAdquiridaField, fechaCompraField, fechaCaducidadField);
                producto.setId(idProducto);
                Archivo.modifyProducto(producto);
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Subcategoria inexistente");
            }
        }
    }
}
