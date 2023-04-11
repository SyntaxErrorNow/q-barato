package com.management.components.empleado;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.management.Usuario;
import com.management.Archivos.ArchivoUsuario;
import com.management.Formularios.Usuario.FormularioRegistrarUsuario;

public class EmpleadoPanel extends JPanel{
    private JTable tablaProductos;

    public EmpleadoPanel(){
        setLayout(null);
        setSize(1200, 800);

        JPanel navBar = new EmpleadoNavbar();
        navBar.setBounds(0, 0, 1200, 70);
        add(navBar);

        String[] columnas = {"Ci", "Nombre", "Cargo", "edad", "Modificar", "Eliminar"};

        Object [][] datosEmpleados = ArchivoUsuario.getAllEmpleados();

        tablaProductos = new JTable(datosEmpleados, columnas);
        tablaProductos.setDefaultEditor(Object.class, null);
        tablaProductos.getTableHeader().setReorderingAllowed(false);

        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = tablaProductos.rowAtPoint(e.getPoint());
                    int column = tablaProductos.columnAtPoint(e.getPoint());
                    int ci = Integer.parseInt(tablaProductos.getValueAt(row, 0).toString());
                    if(column == 4){
                        Usuario usuario =  ArchivoUsuario.getUser(ci);
                        new FormularioRegistrarUsuario(usuario);
                    }
                    if(column == 5){
                        ArchivoUsuario.deleteUsario(ci);
                    }
                }
            }
        };

        tablaProductos.addMouseListener(mouseListener);
        JScrollPane scrollPane = new JScrollPane(tablaProductos);
        scrollPane.setBounds(5, 80, 1175, 670);
        add(scrollPane);
    }

}
