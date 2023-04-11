package com.management.components.movimientos;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.management.Archivos.ArchivoRegistro;

public class MovimientosPanel extends JPanel{
    private JTable tablaRegistros;
    public MovimientosPanel(){
        setLayout(null);
        setSize(1200, 800);

        JPanel navBar = new MovimientosNavBar();
        navBar.setBounds(0, 0, 1200, 70);
        add(navBar);

        String[] columnas = {"Año", "mes", "Dia", "Ganancia", "Motivo", "Producto", "Categoria",
        "Cantidad"};
        Object [][] datosRegistro = ArchivoRegistro.getAllDatosRegistros();

        tablaRegistros = new JTable(datosRegistro, columnas);
        tablaRegistros.setDefaultEditor(Object.class, null);
        tablaRegistros.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(tablaRegistros);
        scrollPane.setBounds(5, 80, 1175, 670);
        add(scrollPane);


    }

}