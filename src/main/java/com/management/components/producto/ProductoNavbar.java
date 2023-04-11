package com.management.components.producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


import com.management.Formularios.Producto.FormularioBorrarProductosDeUnaCategoria;
import com.management.Formularios.Producto.FormularioElegirCategoriaReabastecer;
import com.management.Formularios.Producto.FormularioMostrarReporte;
import com.management.Formularios.Producto.FormularioReabastecerForLote;
import com.management.Formularios.Producto.FormularioRegistrarProducto;
import com.management.Formularios.Producto.FormularioRegistrarProductoTemporada;
import com.management.Formularios.Producto.FormularioVerificarEstadoProducto;


public class ProductoNavbar extends JPanel{

    public ProductoNavbar(){
        setLayout(null);

        JTextField buscador = new JTextField();
        buscador.setBounds(50, 20, 200, 20);
        add(buscador);

        JButton buttonReabastecerLotes = new JButton("Reabastecer por lote");
        buttonReabastecerLotes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormularioReabastecerForLote();

            }
        });
        buttonReabastecerLotes.setBounds(390, 20, 130, 20);
        add(buttonReabastecerLotes);

        JButton buttonReabastecer = new JButton("++ Reabastecer");
        buttonReabastecer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormularioElegirCategoriaReabastecer();
            }
        });
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

        JButton buttonMostrarReporte = new JButton("** Mostrar Reporte");
        buttonMostrarReporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormularioMostrarReporte();
            }
        });

        buttonMostrarReporte.setBounds(380, 20, 140, 20);
        add(buttonMostrarReporte);

    }

}

