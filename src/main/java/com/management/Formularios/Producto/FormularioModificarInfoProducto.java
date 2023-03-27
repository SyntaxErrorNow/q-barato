package com.management.Formularios.Producto;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.management.Producto;
import com.management.Archivos.ArchivoProducto;
import com.management.Archivos.ArchivoProveedor;
import com.management.data.DataProducto;
import com.management.utils.Utils;

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
    JTextField nombre, precio, descripcion, marca, proveedor, cantidadAdquirida;
    JComboBox<String> categoria, subCategoria;
    JComboBox<Integer> diasCompra, mesCompra, anioCompra, diasCaducidad, mesCaducidad, anioCaducidad;
    JLabel idLabel, nombreLabel, precioLabel, descripcionLabel, marcaLabel, categoriaLabel, subCategoriaLabel, proveedorLabel, cantidadAdquiridaLabel, fechaCompraLabel, fechaCaducidadLabel;
    static String nombreField, precioField, descripcionField, marcaField, categoriaField, subCategoriaField, proveedorField, fechaCompraField, fechaCaducidadField;
    static int cantidadAdquiridaField, diaCompraField, mesCompraField, anioCompraField, diaCaducidadField, mesCaducidadField, anioCaducidadField;
    String [] categorias = DataProducto.obtenerCategorias();
    String [] subCategorias = {"-"};
    Integer [] diasDisponibles = {0};
    Integer[] aniosDisponibles = {2023,2024,2025,2026,2027,2028,2029,2030};
    Integer[] mesesDisponibles = {1,2,3,4,5,6,7,8,9,10,11,12};



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
        proveedor.setText(producto.getProveedor().getNombre());
        proveedorLabel = new JLabel("Proveedor");

        cantidadAdquirida = new JTextField(20);
        cantidadAdquirida.setText(String.valueOf(producto.getCantidadDisponible()));
        cantidadAdquiridaLabel = new JLabel("Cantidad Adquirida");
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
        add(mesCompra);
        add(diasCompra);
        add(anioCompra);
        add(fechaCaducidadLabel);
        add(mesCaducidad);
        add(diasCaducidad);
        add(anioCaducidad);
        add(botonEnvio);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == categoria) {
            String seleccionado = (String)categoria.getItemAt(categoria.getSelectedIndex());
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(DataProducto.opcionesSubCategoria(seleccionado));
            subCategoria.setModel(model);
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
        descripcionField = descripcion.getText();
        marcaField = marca.getText();
        categoriaField = (String)categoria.getItemAt(categoria.getSelectedIndex());
        subCategoriaField = (String)subCategoria.getItemAt(subCategoria.getSelectedIndex());
        proveedorField = proveedor.getText();
        cantidadAdquiridaField = Integer.parseInt(cantidadAdquirida.getText());
        diaCompraField = (int)diasCompra.getItemAt(diasCompra.getSelectedIndex());
        mesCompraField = (int)mesCompra.getItemAt(mesCompra.getSelectedIndex());
        anioCompraField = (int)anioCompra.getItemAt(anioCompra.getSelectedIndex());
        diaCaducidadField = (int)diasCaducidad.getItemAt(diasCaducidad.getSelectedIndex());
        mesCaducidadField = (int)mesCaducidad.getItemAt(mesCaducidad.getSelectedIndex());
        anioCaducidadField = (int)anioCaducidad.getItemAt(anioCaducidad.getSelectedIndex());


        if( nombreField.equals("") || precioField.equals("") || descripcionField.equals("") || marcaField.equals("") ||
            categoriaField.equals("") || subCategoriaField.equals("") || proveedorField.equals("") ||
            cantidadAdquiridaField <= 0 || diaCompraField==0 || mesCompraField==0 || anioCompraField==0 ||
            diaCaducidadField==0 || mesCaducidadField==0 || anioCaducidadField==0
        ){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");

        }else{
            ArrayList<String> subtipos = new ArrayList<>();
            subtipos = new ArrayList<>(Arrays.asList(DataProducto.opcionesSubCategoria(categoriaField)));
            if(subtipos.contains(subCategoriaField)){
                Producto producto = new Producto(nombreField, descripcionField, marcaField, categoriaField, subCategoriaField, Double.parseDouble(precioField), ArchivoProveedor.getProveedorByNombre(proveedorField), cantidadAdquiridaField, diaCompraField, mesCompraField, anioCompraField, diaCaducidadField, mesCaducidadField, anioCaducidadField);
                producto.setId(idProducto);
                if(producto.getFechaCompra().compararSiOtraFechaEsMayor(producto.getFechaCaducidad())){
                    ArchivoProducto.modifyProducto(producto);
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
