package com.management.Formularios.Producto;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.management.Fecha;
import com.management.Producto;
import com.management.RegistroAbastecimientos;
import com.management.Archivos.ArchivoProducto;
import com.management.Archivos.ArchivoProveedor;
import com.management.Archivos.ArchivoRegistro;
import com.management.utils.Utils;
import com.management.utils.UtilsProveedor;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.awt.event.ActionEvent;
public class FormularioReabastecerProducto extends JFrame implements ActionListener, ItemListener{
    private Producto producto;
    JTextField cantidadPedido;
    String proveedorField;
    JLabel cantidadLabel, fechaLabel;
    JButton realisarPedido, botonEnvio;
    JComboBox<String> proveedor;
    JLabel  proveedorLabel;
    JComboBox<Integer> dias, mes, anio;
    Integer [] diasDisponibles = {0};
    Integer[] aniosDisponibles = {2023,2024,2025,2026,2027,2028,2029,2030};
    Integer[] mesesDisponibles = {1,2,3,4,5,6,7,8,9,10,11,12};

    public FormularioReabastecerProducto(Producto producto) {
        this.producto = producto;

        proveedorLabel = new JLabel("Proveedores");
        proveedor = new JComboBox<String>(UtilsProveedor.obtenerListaNombreProveedores(producto.getNombre()));

        cantidadLabel = new JLabel("cantidad");
        cantidadPedido = new JTextField(20);
        Utils.numInteger(cantidadPedido);

        fechaLabel = new JLabel("Fecha de compra");
        anio = new JComboBox<Integer>(aniosDisponibles);
        mes = new JComboBox<Integer>(mesesDisponibles);
        dias = new JComboBox<Integer>(diasDisponibles);
        mes.addItemListener(this);


        realisarPedido = new JButton("Pedido");
        realisarPedido.addActionListener(this);


        add(proveedorLabel);
        add(proveedor);
        add(cantidadLabel);
        add(cantidadPedido);
        add(fechaLabel);
        add(mes);
        add(dias);
        add(anio);
        add(realisarPedido);


        this.setSize(400,250);
        this.setLayout(new GridLayout(4,2));
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == mes) {
            Integer seleccionado = mes.getItemAt(mes.getSelectedIndex());
            DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>(Utils.generacionDeDias(seleccionado));
            dias.setModel(model);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String cantidadAdquiridaField = cantidadPedido.getText();
        proveedorField = (String)proveedor.getItemAt(proveedor.getSelectedIndex()) == null ? "" : (String)proveedor.getItemAt(proveedor.getSelectedIndex());
        Fecha fechaField = new Fecha((int)dias.getItemAt(dias.getSelectedIndex()),(int)mes.getItemAt(mes.getSelectedIndex()),(int)anio.getItemAt(anio.getSelectedIndex()));

        if(cantidadAdquiridaField.equals("") || fechaField.getDia() == 0){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");

        }else if(proveedorField.equals("")){
            JOptionPane.showMessageDialog(null, "No hay proveedores para este producto");

        }else{
            this.producto.setProveedor(ArchivoProveedor.getProveedorByNombre(proveedorField));
            this.producto.abastecerProducto(Integer.parseInt(cantidadAdquiridaField));
            RegistroAbastecimientos registro = new RegistroAbastecimientos(producto, Integer.parseInt(cantidadAdquiridaField), fechaField, ArchivoProveedor.getProveedorByNombre(proveedorField));
            ArchivoRegistro.postRegistro(registro);
            ArchivoProducto.modifyProducto(this.producto);
            setVisible(false);
            dispose();
        }


    }



}
