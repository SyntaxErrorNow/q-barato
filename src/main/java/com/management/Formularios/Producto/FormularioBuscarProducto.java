package com.management.Formularios.Producto;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Color;

public class FormularioBuscarProducto extends JFrame implements ActionListener {
    JTextField nombre;
    JLabel texto;
    JButton buscarNombre, buscarID, buscarCategoria, buscarSubCategoria;

    public FormularioBuscarProducto(){
        setLayout(new FlowLayout());
        buscarNombre = new JButton("Buscar por nombre ");
        buscarNombre.addActionListener(this);

        buscarID = new JButton("Buscar por ID");
        buscarID.addActionListener(this);

        buscarCategoria = new JButton("Buscar por categoria");
        buscarCategoria.addActionListener(this);

        buscarSubCategoria = new JButton("Buscar por subcategoria");
        buscarSubCategoria.addActionListener(this);

        add(buscarNombre);
        add(buscarID);
        add(buscarCategoria);
        add(buscarSubCategoria);

        this.setSize(700,250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buscarNombre){
            FormularioBuscarNombre form = new FormularioBuscarNombre();
            form.setSize(250,250);
            form.setResizable(false);
            form.setLocationRelativeTo(null);
            form.getContentPane().setBackground(Color.WHITE);
            form.setVisible(true);
        }
        if(e.getSource() == buscarID){
            FormularioBuscarID form = new FormularioBuscarID();
            form.setSize(250,250);
            form.setResizable(false);
            form.setLocationRelativeTo(null);
            form.getContentPane().setBackground(Color.WHITE);
            form.setVisible(true);
        }

        if(e.getSource() == buscarCategoria){
            FormularioBuscarCategoria form = new FormularioBuscarCategoria();
            form.setSize(250,250);
            form.setResizable(false);
            form.setLocationRelativeTo(null);
            form.getContentPane().setBackground(Color.WHITE);
            form.setVisible(true);
        }
        if(e.getSource() == buscarSubCategoria){
            FormularioBuscarSubcategoria form = new FormularioBuscarSubcategoria();
            form.setSize(250,250);
            form.setResizable(false);
            form.setLocationRelativeTo(null);
            form.getContentPane().setBackground(Color.WHITE);
            form.setVisible(true);
        }
    }

}
