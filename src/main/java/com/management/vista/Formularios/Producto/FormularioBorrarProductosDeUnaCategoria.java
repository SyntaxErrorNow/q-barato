package com.management.vista.Formularios.Producto;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.management.Archivos.ArchivoProducto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioBorrarProductosDeUnaCategoria extends JFrame implements ActionListener{
    JComboBox<String> categoria;
    JLabel texto,aux;
    JButton botonEnvio;

    String [] categorias = { "despensas", "comestibles", "bebidas", "aseo", "cuidado personal", "otros", "temporada"};

    public FormularioBorrarProductosDeUnaCategoria(){
        setLayout(new FlowLayout());
        texto = new JLabel("Categoria: ");
        categoria = new JComboBox<>(categorias);
        aux = new JLabel("           ");
        botonEnvio = new JButton();
        botonEnvio.setText("Borrar");
        botonEnvio.addActionListener(this);
        add(texto);
        add(categoria);
        add(aux);
        add(botonEnvio);

        this.setSize(250,200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String categoriaField = (String)categoria.getItemAt(categoria.getSelectedIndex());
        if(categoriaField.equals("")){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");
        }else{
            ArchivoProducto.deleteProductosDeUnaCategoria(categoriaField);
            JOptionPane.showMessageDialog(null, "Eliminado satisfactoriamente");
        }
    }
}