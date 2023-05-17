package com.management.vista.components.registro;

import javax.swing.*;

import com.management.Archivos.ArchivoRegistro;

public class RegistroPanel extends JPanel {
    private JTable TablaRegistros;

    public RegistroPanel(){
        setLayout(null);
        setSize(1200, 800);

        JPanel navBar = new RegistroNavbar();
        navBar.setBounds(0, 0, 1200, 70);
        add(navBar);

        String[] columnas = {"Año", "mes", "Dia", "Ganancia", "Motivo", "Producto", "Categoria", "Perdida",
        "Cantidad"};
        Object [][] datosRegistro = ArchivoRegistro.getAllDatosRegistros();
    }
}