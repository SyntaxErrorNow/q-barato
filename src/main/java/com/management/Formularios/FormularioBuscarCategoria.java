package com.management.Formularios;
import javax.swing.*;
import com.management.Archivo;
import com.management.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.JComboBox;

public class FormularioBuscarCategoria extends JFrame implements ActionListener {
    JComboBox<String> orden,categoria;
    JLabel texto, ordenLabel,aux;
    JButton botonEnvio;

    String [] categorias = { "despensas", "comestibles", "bebidas", "aseo", "cuidado personal", "otros" };
    String[] ordenamientos = {"Alfabeticamente","Por categoria","Por precio de menor a mayor", "Por precio de mayor a menor"};

    public FormularioBuscarCategoria(){
        setLayout(new FlowLayout());
        texto = new JLabel("Categoria del producto");
        categoria = new JComboBox<>(categorias);

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
            ArrayList<Producto> productosCategoria = Archivo.getProductoPorCategoria(categoriaField);
            ArrayList<Producto> Ordenados = Archivo.ordenarListas(productosCategoria, ordenField);
            for(int i = 0; i<Ordenados.size(); i++){
                System.out.println(Ordenados.get(i).toString());
            }
            setVisible(false);
        }
    }


}
