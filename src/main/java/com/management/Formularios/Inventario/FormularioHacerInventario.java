package com.management.Formularios.Inventario;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.management.Inventario;
import com.management.Archivos.ArchivoInventario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioHacerInventario extends JFrame implements ActionListener{
    JLabel fechaLabel;
    JButton botonEnvio;
    JComboBox<Integer> mes, anio;

    Integer[] aniosDisponibles = {2023,2024,2025,2026,2027,2028,2029,2030};
    Integer[] mesesDisponibles = {1,2,3,4,5,6,7,8,9,10,11,12};

    public FormularioHacerInventario(){
        setLayout(new FlowLayout());
        fechaLabel = new JLabel("Fecha del inventario: ");
        anio = new JComboBox<Integer>(aniosDisponibles);
        mes = new JComboBox<Integer>(mesesDisponibles);
        botonEnvio = new JButton("Hacer inventario");
        botonEnvio.addActionListener(this);

        add(fechaLabel);
        add(mes);
        add(anio);
        add(botonEnvio);

        this.setSize(250,250);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.getContentPane().setBackground(Color.WHITE);
            this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Inventario inv = new Inventario((int)mes.getItemAt(mes.getSelectedIndex()), (int)anio.getItemAt(anio.getSelectedIndex()));
        ArchivoInventario.postInventario(inv);
        inv.imprimirRegistros();
    }
}