package com.management.Formularios.Inventario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;
import com.management.Inventario;
import com.management.Archivos.ArchivoInventario;

public class FormularioRecuperarInventarioPasado  extends JFrame{
    private JTextField fechaTextField;
    private JTable tabla;

    public FormularioRecuperarInventarioPasado() {

        JLabel fechaLabel = new JLabel("Ingrese la fecha:");
        fechaTextField = new JTextField(10);
        JButton buscarButton = new JButton("Buscar");
        tabla = new JTable();


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String fecha = fechaTextField.getText();


                List<Object[]> datos = buscarDatosPorFecha(fecha);


                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Año");
                model.addColumn("Mes");
                model.addColumn("Ganancia");
                model.addColumn("Perdida");
                model.addColumn("Ganancia Total");
                model.addColumn("Cantidad vendida");
                model.addColumn("Cantidad perdida");
                model.addColumn("Cantidad adquirida");
                model.addColumn("Capital invertido");

                for (Object[] fila : datos) {
                    model.addRow(fila);
                }

                tabla.setModel(model);
            }
        });


        this.setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(fechaLabel);
        inputPanel.add(fechaTextField);
        inputPanel.add(buscarButton);
        this.add(inputPanel, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(tabla);
        this.add(scrollPane, BorderLayout.CENTER);

        this.setTitle("Inventario Demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private List<Object[]> buscarDatosPorFecha(String fecha) {

        List<Object[]> datos = new ArrayList<>();
        Inventario inventario = ArchivoInventario.getInventario(fecha);
        datos.add(new Object[]{inventario.getAnio(), inventario.getPeriodo(), inventario.getGanancias(), inventario.getPerdida(), inventario.getGanancias() - inventario.getPerdida(),inventario.getCantidadVendida(), inventario.getCantidadPerdida(), inventario.getCantidadAdquirida(),inventario.getCapitalInvertido()});

        return datos;
    }



}