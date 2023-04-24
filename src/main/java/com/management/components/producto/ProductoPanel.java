package com.management.components.producto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.management.Producto;
import com.management.Archivos.ArchivoProducto;
import com.management.Formularios.Producto.FormularioModificarInfoProducto;



public class ProductoPanel extends JPanel{
    private JTable tablaProductos;

    public ProductoPanel(){
        setLayout(null);
        setSize(1200, 800);

        JPanel navBar = new ProductoNavbar();
        navBar.setBounds(0, 0, 1200, 70);
        add(navBar);

        String[] columnas = {"id", "nombre", "capacidad", "descripción", "cualidades", "marca",
                            "categoria", "sub categoria","precio", "proveedor", "Adquirida",
                            "Vendida", "Disponible", "fechaCompra",
                            "fechaCaducidad", "disponibilidad", "Modificar", "Eliminar"};

        Object [][] datosEmpleados = ArchivoProducto.getAllDatosProductos();

        tablaProductos = new JTable(datosEmpleados, columnas);
        tablaProductos.setDefaultEditor(Object.class, null);
        tablaProductos.getTableHeader().setReorderingAllowed(false);

        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = tablaProductos.rowAtPoint(e.getPoint());
                    int column = tablaProductos.columnAtPoint(e.getPoint());
                    String id = tablaProductos.getValueAt(row, 0).toString();
                    if(column == 14){
                        Producto producto =  ArchivoProducto.getProducto(id);
                        new FormularioModificarInfoProducto(producto);
                    }
                    if(column == 15){
                        ArchivoProducto.deleteProducto(ArchivoProducto.getProducto(id));
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
