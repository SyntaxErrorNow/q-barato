package com.management.components.inventario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.management.Dashboard;
import com.management.Archivos.ArchivoInventario;



public class InventarioPanel extends JPanel{
    private JTable tablaInventarios;
    Object [][] datosInventario;

    public InventarioPanel(){
        setLayout(null);
        setSize(1200, 800);

        JPanel navBar = new InventarioNavbar();
        navBar.setBounds(0, 0, 1200, 70);
        add(navBar);

        String[] columnas = {"Año", "mes", "ID", "Ganancia", "Perdida", "Ganancia Total",
                            "Cantidad vendida","Cantidad perdida", "Cantidad adquirida", "Capital invertido" , "Existencias", "Reporte Textual"};

        datosInventario = ArchivoInventario.getAllDatosInventarios();

        tablaInventarios = new JTable(datosInventario, columnas);
        tablaInventarios.setDefaultEditor(Object.class, null);
        tablaInventarios.getTableHeader().setReorderingAllowed(false);

        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int row = tablaInventarios.rowAtPoint(e.getPoint());
                    int column = tablaInventarios.columnAtPoint(e.getPoint());
                    String ID = tablaInventarios.getValueAt(row, 2).toString();
                    if(column == 10){
                        ExistenciasPanel panel = new ExistenciasPanel(ArchivoInventario.getInventario(ID));
                        Dashboard aux = new Dashboard(10101010);
                        aux.existencias(panel);
                        /*if (e.getSource() == buttonProductos) {
                            remove(pagePrincipal);
                            remove(panelProveedor);
                            remove(panelEmpleado);
                            remove(panelInventario);
                            remove(panelMovimientos);
                            add(panelProducto);
                            revalidate();
                            repaint();
                        }*/
                    }
                    if(column == 11){
                        new ReporteTextualPDF(ID);
                    }
                    
                }
            }
        };

        tablaInventarios.addMouseListener(mouseListener);
        JScrollPane scrollPane = new JScrollPane(tablaInventarios);
        scrollPane.setBounds(5, 80, 1175, 670);
        add(scrollPane);
    }

}
