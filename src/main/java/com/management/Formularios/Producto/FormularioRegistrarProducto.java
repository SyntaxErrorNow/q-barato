package com.management.Formularios.Producto;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import com.management.Producto;
import com.management.Archivos.ArchivoProducto;
import com.management.Archivos.ArchivoProveedor;
import com.management.data.DataProducto;
import com.management.utils.Utils;
import com.management.utils.UtilsProveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Color;
import java.awt.FlowLayout;


public class FormularioRegistrarProducto extends JFrame implements ActionListener, ItemListener{
    JButton botonEnvio;
    JFormattedTextField name;
    JTextField nombre, precio, capacidad, descripcion, cualidad, marca, cantidadAdquirida;
    JComboBox<String> categoria, subcategoria, proveedores;
    JComboBox<Integer> diasCompra, mesCompra, anioCompra, diasCaducidad, mesCaducidad, anioCaducidad;
    JLabel nombreLabel, precioLabel, capacidadLabel, cualidadLabel, descripcionLabel, marcaLabel, categoriaLabel, subcategoriaLabel, proveedorLabel, cantidadAdquiridaLabel, fechaCompraLabel, fechaCaducidadLabel;
    static String nombreField, precioField, capacidadField, cualidadField, descripcionField, marcaField, categoriaField, subcategoriaField, proveedorField;
    static int cantidadAdquiridaField, diaCompraField, mesCompraField, anioCompraField, diaCaducidadField, mesCaducidadField, anioCaducidadField;
    String [] categorias = DataProducto.obtenerCategorias();
    String [] subCategorias = {"-"};
    Integer [] diasDisponibles = {0};
    Integer[] aniosDisponibles = {2023,2024,2025,2026,2027,2028,2029,2030};
    Integer[] mesesDisponibles = {1,2,3,4,5,6,7,8,9,10,11,12};
    String [] proveedoresProductos = {"1", "2", "3", "4", "5"};
    String [] vacio = {"-"};
    public FormularioRegistrarProducto(){
        super("Registrar Producto");
        setLayout(new FlowLayout());

        nombre = new JTextField(20);
        nombreLabel = new JLabel("Nombre del producto");
        nombre.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
              mostrarProveedores();
            }
            public void removeUpdate(DocumentEvent e) {
              mostrarProveedores();
            }
            public void insertUpdate(DocumentEvent e) {
              mostrarProveedores();
            }

            public void mostrarProveedores() {
                if(UtilsProveedor.obtenerListaNombreProductosProveedores().contains(nombre.getText())){
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(UtilsProveedor.obtenerListaNombreProveedores(nombre.getText()));
                    proveedores.setModel(model);
                }
            }
          });


        precio = new JTextField(20);
        precioLabel = new JLabel("Precio");
        Utils.numDouble(precio);

        capacidad = new JTextField(20);
        capacidadLabel = new JLabel("Capacidad (Litros/Kilos)");
        Utils.numDouble(capacidad);

        cualidad = new JTextField(20);
        cualidadLabel = new JLabel("Caracteristicas");

        descripcion = new JTextField(20);
        descripcionLabel = new JLabel("Descripcion");

        marca = new JTextField(20);
        marcaLabel = new JLabel("Marca");

        categoria = new JComboBox<String>(categorias);
        categoriaLabel = new JLabel("Categoria");
        categoria.addItemListener(this);

        subcategoria = new JComboBox<String>(subCategorias);
        subcategoriaLabel = new JLabel("Subcategoria");

        proveedores = new JComboBox<String>(vacio);
        proveedorLabel = new JLabel("Proveedores para el producto");

        cantidadAdquirida = new JTextField(20);
        cantidadAdquiridaLabel = new JLabel("Cantidad adquirida");
        Utils.numInteger(cantidadAdquirida);

        anioCompra = new JComboBox<Integer>(aniosDisponibles);
        mesCompra = new JComboBox<Integer>(mesesDisponibles);
        mesCompra.addItemListener(this);
        diasCompra = new JComboBox<Integer>(diasDisponibles);
        fechaCompraLabel = new JLabel("Fecha de compra");

        anioCaducidad = new JComboBox<Integer>(aniosDisponibles);
        mesCaducidad = new JComboBox<Integer>(mesesDisponibles);
        mesCaducidad.addItemListener(this);
        diasCaducidad = new JComboBox<Integer>(diasDisponibles);
        fechaCaducidadLabel = new JLabel("Fecha de caducidad");

        botonEnvio = new JButton();
        botonEnvio.setText("Registrar");
        botonEnvio.addActionListener(this);

        add(nombreLabel);
        add(nombre);
        add(precioLabel);
        add(precio);
        add(capacidadLabel);
        add(capacidad);
        add(cualidadLabel);
        add(cualidad);
        add(descripcionLabel);
        add(descripcion);
        add(marcaLabel);
        add(marca);
        add(categoriaLabel);
        add(categoria);
        add(subcategoriaLabel);
        add(subcategoria);
        add(proveedorLabel);
        add(proveedores);
        add(cantidadAdquiridaLabel);
        add(cantidadAdquirida);
        add(fechaCompraLabel);
        add(mesCompra);
        add(diasCompra);
        add(anioCompra);
        add(fechaCaducidadLabel);
        add(mesCaducidad);
        add(diasCaducidad);
        add(anioCaducidad);
        add(botonEnvio);

        this.setSize(300,600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
    }




    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == categoria) {
            String seleccionado = (String)categoria.getItemAt(categoria.getSelectedIndex());
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(DataProducto.opcionesSubCategoria(seleccionado));
            subcategoria.setModel(model);
        }
        if (e.getSource() == mesCompra) {
            Integer seleccionado = mesCompra.getItemAt(mesCompra.getSelectedIndex());
            DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>(Utils.generacionDeDias(seleccionado));
            diasCompra.setModel(model);
        }
        if (e.getSource() == mesCaducidad) {
            Integer seleccionado = mesCaducidad.getItemAt(mesCaducidad.getSelectedIndex());
            DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>(Utils.generacionDeDias(seleccionado));
            diasCaducidad.setModel(model);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        nombreField = nombre.getText();
        precioField = precio.getText();
        capacidadField = capacidad.getText();
        cualidadField = cualidad.getText();
        descripcionField = descripcion.getText();
        marcaField = marca.getText();
        categoriaField = (String)categoria.getItemAt(categoria.getSelectedIndex());
        subcategoriaField = (String)subcategoria.getItemAt(subcategoria.getSelectedIndex());
        proveedorField = (String)proveedores.getItemAt(proveedores.getSelectedIndex());
        cantidadAdquiridaField = Integer.parseInt(cantidadAdquirida.getText());
        diaCompraField = (int)diasCompra.getItemAt(diasCompra.getSelectedIndex());
        mesCompraField = (int)mesCompra.getItemAt(mesCompra.getSelectedIndex());
        anioCompraField = (int)anioCompra.getItemAt(anioCompra.getSelectedIndex());
        diaCaducidadField = (int)diasCaducidad.getItemAt(diasCaducidad.getSelectedIndex());
        mesCaducidadField = (int)mesCaducidad.getItemAt(mesCaducidad.getSelectedIndex());
        anioCaducidadField = (int)anioCaducidad.getItemAt(anioCaducidad.getSelectedIndex());

        if( nombreField.equals("") || precioField.equals("") || descripcionField.equals("") || marcaField.equals("") ||
            categoriaField.equals("") || subcategoriaField.equals("") ||
            cantidadAdquiridaField <= 0 || diaCompraField==0 || mesCompraField==0 || anioCompraField==0 ||
            diaCaducidadField==0 || mesCaducidadField==0 || anioCaducidadField==0
        ){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");

        }else if(proveedorField.equals("")){
            JOptionPane.showMessageDialog(null, "No hay proveedores para este producto");

        }else{
            ArrayList<String> subtipos = new ArrayList<>();
            subtipos = new ArrayList<>(Arrays.asList(DataProducto.opcionesSubCategoria(categoriaField)));
            if(subtipos.contains(subcategoriaField)){
                Producto producto = new Producto(nombreField, cualidadField+" - "+descripcionField, marcaField, categoriaField, subcategoriaField, Double.parseDouble(precioField), ArchivoProveedor.getProveedorByNombre(proveedorField), cantidadAdquiridaField, diaCompraField, mesCompraField, anioCompraField, diaCaducidadField, mesCaducidadField, anioCaducidadField,Double.parseDouble(capacidadField));
                if(producto.getFechaCompra().compararSiOtraFechaEsMayor(producto.getFechaCaducidad())){
                    ArchivoProducto.postProducto(producto);
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "La fecha de caducidad debe ser mayor a la fecha de compra");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Subcategoria inexistente");
            }
        }
    }
}