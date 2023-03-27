package com.management.Formularios.Producto;
import javax.swing.*;
import com.management.Producto;
import com.management.Archivos.ArchivoProducto;
import com.management.data.DataProducto;
import com.management.utils.UtilsProducto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.FlowLayout;
import javax.swing.JComboBox;

public class FormularioBuscarCategoria extends JFrame implements ActionListener {
    JComboBox<String> orden,categoria;
    JLabel texto, ordenLabel,aux;
    JButton botonEnvio;

    List<String> categorias = new ArrayList<>(Arrays.asList(DataProducto.obtenerCategorias()));
    String [] ordenamientos = {"Alfabeticamente","Por categoria","Por precio de menor a mayor", "Por precio de mayor a menor"};

    public FormularioBuscarCategoria(){
        setLayout(new FlowLayout());
        texto = new JLabel("Categoria del producto");
        categorias.add("temporada");
        categoria = new JComboBox<>(categorias.toArray(new String[0]));

        orden = new JComboBox<>(ordenamientos);
        ordenLabel = new JLabel("Ordernar: ");
        aux = new JLabel("           ");
        botonEnvio = new JButton();
        botonEnvio.setText("Buscar");
        botonEnvio.addActionListener(this);
        add(texto);
        add(categoria);
        add(aux);
        add(ordenLabel);
        add(orden);
        add(botonEnvio);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String categoriaField = (String)categoria.getItemAt(categoria.getSelectedIndex());
        String ordenField = (String)orden.getItemAt(orden.getSelectedIndex());
        categoriaField.toLowerCase();
        if(categoriaField.equals("")){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");
        }else{
            ArrayList<Producto> productosCategoria = ArchivoProducto.getProductoPorCategoria(categoriaField);
            ArrayList<Producto> Ordenados = UtilsProducto.ordenarListas(productosCategoria, ordenField);
            for(int i = 0; i<Ordenados.size(); i++){
                System.out.println(Ordenados.get(i).toString());
            }
            setVisible(false);
        }
    }


}
