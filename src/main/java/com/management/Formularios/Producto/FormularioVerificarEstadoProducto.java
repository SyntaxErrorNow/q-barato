package com.management.Formularios.Producto;
import javax.swing.*;
import com.management.Producto;
import com.management.Fecha;
import com.management.Archivos.ArchivoProducto;
import com.management.utils.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import java.awt.FlowLayout;
public class FormularioVerificarEstadoProducto extends JFrame implements ActionListener, ItemListener {
    JTextField ID;
    JLabel texto, fechaLabel;
    JButton botonEnvio;
    JComboBox<Integer> dias, mes, anio;
    Integer [] diasDisponibles = {0};
    Integer[] aniosDisponibles = {2023,2024,2025,2026,2027,2028,2029,2030};
    Integer[] mesesDisponibles = {1,2,3,4,5,6,7,8,9,10,11,12};

    public FormularioVerificarEstadoProducto(){
        setLayout(new FlowLayout());
        texto = new JLabel("ID del producto");
        ID = new JTextField(20);

        anio = new JComboBox<Integer>(aniosDisponibles);
        mes = new JComboBox<Integer>(mesesDisponibles);
        mes.addItemListener(this);
        dias = new JComboBox<Integer>(diasDisponibles);
        fechaLabel = new JLabel("Fecha de compra");
        botonEnvio = new JButton("Verificar");
        botonEnvio.addActionListener(this);

        add(texto);
        add(ID);
        add(fechaLabel);
        add(mes);
        add(dias);
        add(anio);
        add(botonEnvio);

        this.setSize(250,250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
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
        String IDField = ID.getText();
        Fecha fechaField = new Fecha((int)dias.getItemAt(dias.getSelectedIndex()),(int)mes.getItemAt(mes.getSelectedIndex()),(int)anio.getItemAt(anio.getSelectedIndex()));
        if(IDField.equals("") || fechaField.getDia()==0 || fechaField.getMes()==0 || fechaField.getAnio()==0){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");
        }else{
            Producto producto = ArchivoProducto.getProducto(IDField);
            if(!fechaField.compararSiOtraFechaEsMayor(producto.getFechaCaducidad())){
                System.out.println("El producto : "+producto.getNombre()+" ("+producto.getId()+") esta caducado \n "+
                fechaField.toString() +" - "+producto.getFechaCaducidad().toString());
            }else{
                System.out.println("El producto : "+producto.getNombre()+" ("+producto.getId()+") esta en buen estado");
            }
            setVisible(false);
        }
    }

}
