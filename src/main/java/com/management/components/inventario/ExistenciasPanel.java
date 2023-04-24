//Pablo limachi es un explotador
package com.management.components.inventario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.management.Inventario;
import com.management.Producto;
import com.management.Archivos.ArchivoInventario;
import com.management.Archivos.ArchivoProducto;

import com.management.components.registro.RegistroPanel;


public class ExistenciasPanel extends JPanel{
    private JTable tablaInventarios;

    public ExistenciasPanel(Inventario inventario){
        setLayout(null);
        setSize(1200, 800);

        JPanel navBar = new ExistenciasNavbar(inventario);
        navBar.setBounds(0, 0, 1200, 70);
        add(navBar);

        String[] columnas = {"ID", "Producto", "Precio Unitario", "Cantidad Disponible","Cantidad Vendida"};


        Object [][] datosExistencias = ArchivoProducto.getAllDatosExistencias(inventario.getProductosAlMomento());

        tablaInventarios = new JTable(datosExistencias, columnas);
        tablaInventarios.setDefaultEditor(Object.class, null);
        tablaInventarios.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(tablaInventarios);
        scrollPane.setBounds(5, 80, 1175, 670);
        add(scrollPane);
    }

}
