package com.management.components.producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.management.Producto;
import com.management.Archivos.ArchivoProducto;
import com.management.Formularios.Producto.FormularioBorrarProductosDeUnaCategoria;
import com.management.Formularios.Producto.FormularioDescuento;
import com.management.Formularios.Producto.FormularioElegirCategoriaReabastecer;
import com.management.Formularios.Producto.FormularioImprimirEtiqueta;
import com.management.Formularios.Producto.FormularioMostrarReporte;
import com.management.Formularios.Producto.FormularioReabastecerForLote;
import com.management.Formularios.Producto.FormularioRegistrarProducto;
import com.management.Formularios.Producto.FormularioRegistrarProductoTemporada;
import com.management.Formularios.Producto.FormularioVerificarEstadoProducto;
import com.management.utils.UtilsProducto;


public class ProductoNavbar extends JPanel{

    public ProductoNavbar(){
        JComboBox orden;
        JLabel ordenLabel;
        JButton botonEnvio;
        String[] ordenamientos = {"Alfabeticamente","Por categoria","Por precio de menor a mayor", "Por precio de mayor a menor"};
        setLayout(null);
        JTextField buscador = new JTextField();
        buscador.setBounds(10, 20, 130, 20);
        add(buscador);

        orden = new JComboBox<>(ordenamientos);
        orden.setBounds(260,50,180,20);
        ordenLabel = new JLabel("Ordernar: ");
        ordenLabel.setBounds(180,50,80,20);
        

        botonEnvio = new JButton();
        botonEnvio.setBounds(160, 20, 80, 20);
        botonEnvio.setText("Buscar");

        botonEnvio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String nombreField = buscador.getText();
                String ordenField = (String)orden.getItemAt(orden.getSelectedIndex());
                nombreField.toLowerCase();
                if(nombreField.equals("")){
                    JOptionPane.showMessageDialog(null, "Los datos son requeridos");
                }else{
                    ArrayList<Producto> productosNombre = ArchivoProducto.getProductoPorNombre(nombreField);
                    ArrayList<Producto> Ordenados = UtilsProducto.ordenarListas(productosNombre, ordenField);
                    String busqueda = "------RESULTADOS DE BUSQUEDA------ \n";
                    for(int i = 0; i<Ordenados.size(); i++){
                        busqueda = busqueda + (Ordenados.get(i).getNombre() + " " + Ordenados.get(i).getId() +" " + Ordenados.get(i).getCategoria() + " " 
                        + Ordenados.get(i).getCualidad() + "\n");
                    }
                    JOptionPane.showMessageDialog(null, busqueda);
                    setVisible(true);
                }
            }
        });
        add(botonEnvio);
        add(ordenLabel);
        add(orden);

        JButton buttonReabastecerLotes = new JButton("Reabastecer por lote");
        buttonReabastecerLotes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormularioReabastecerForLote();

            }
        });
        JButton buttonMostrarReporte = new JButton("** Mostrar Reporte");
        buttonMostrarReporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormularioMostrarReporte();
            }
        });

        buttonMostrarReporte.setBounds(250, 20, 140, 20);
        add(buttonMostrarReporte);
        buttonReabastecerLotes.setBounds(390, 20, 130, 20);
        add(buttonReabastecerLotes);

        JButton buttonReabastecer = new JButton("++ Reabastecer");
        buttonReabastecer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormularioElegirCategoriaReabastecer();
            }
        });
        JButton buttonImprimirEtiqueta = new JButton("Imprimir");
        buttonImprimirEtiqueta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormularioImprimirEtiqueta();
            }
        });
        
        buttonImprimirEtiqueta.setBounds(450,50,100,20);
        add(buttonImprimirEtiqueta);
        buttonReabastecer.setBounds(530, 20, 130, 20);
        add(buttonReabastecer);

        JButton buttonRegistrarProducto = new JButton("+ Registrar");
            buttonRegistrarProducto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioRegistrarProducto();
                }
            });
        buttonRegistrarProducto.setBounds(930, 20, 100, 20);
        add(buttonRegistrarProducto);


        JButton buttonRegistrarProductoTemporada = new JButton("+ Temporada");
        buttonRegistrarProductoTemporada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormularioRegistrarProductoTemporada();
            }
        });
        buttonRegistrarProductoTemporada.setBounds(1040, 20, 110, 20);
        add(buttonRegistrarProductoTemporada);

        JButton buttonVerificarProductoEstado = new JButton("Estado Producto");
        buttonVerificarProductoEstado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormularioVerificarEstadoProducto();
            }
        });
        JButton buttonDescuentosTemporada = new JButton("Descuentos");
        buttonDescuentosTemporada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormularioDescuento();
            }
        });
        
        buttonDescuentosTemporada.setBounds(580,50,130,20);
        add(buttonDescuentosTemporada);
        buttonVerificarProductoEstado.setBounds(670, 20, 130, 20);
        add(buttonVerificarProductoEstado);

        JButton buttonEliminarProductoCategoria = new JButton("-- Categoria");
        buttonEliminarProductoCategoria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormularioBorrarProductosDeUnaCategoria();
            }
        });
        buttonEliminarProductoCategoria.setBounds(810, 20, 110, 20);
        add(buttonEliminarProductoCategoria);


    }

}

