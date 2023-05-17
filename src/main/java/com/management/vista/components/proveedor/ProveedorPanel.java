package com.management.vista.components.proveedor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.management.Proveedor;
import com.management.Archivos.ArchivoProveedor;
import com.management.vista.Formularios.Proveedor.FormularioModificarProveedor;


public class ProveedorPanel extends JPanel{
    private JTable tablaProductos;

    public ProveedorPanel(){
        setLayout(null);
        setSize(1200, 800);

        JPanel navBar = new ProveedorNavbar();
        navBar.setBounds(0, 0, 1200, 70);
        add(navBar);

        String[] columnas = {"Id", "Nombre", "Telefono", "Productos", "Modificar", "Eliminar"};

        Object [][] datosEmpleados = ArchivoProveedor.getAllDatosProveedores();

        tablaProductos = new JTable(datosEmpleados, columnas);
        tablaProductos.setDefaultEditor(Object.class, null);
        tablaProductos.getTableHeader().setReorderingAllowed(false);

        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = tablaProductos.rowAtPoint(e.getPoint());
                    int column = tablaProductos.columnAtPoint(e.getPoint());
                    String id = tablaProductos.getValueAt(row, 0).toString();
                    if(column == 4){
                        Proveedor proveedor = ArchivoProveedor.getProveedor(id);
                        new FormularioModificarProveedor(proveedor);
                    }
                    if(column == 5){
                        ArchivoProveedor.deleteProveedor(id);
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
