package com.management;
import javax.swing.*;

import com.management.Archivos.ArchivoUsuario;
import com.management.Graficos.AnalystRoot;
import com.management.components.empleado.EmpleadoPanel;
import com.management.components.inventario.InventarioPanel;
import com.management.components.movimientos.MovimientosPanel;
import com.management.components.producto.ProductoPanel;
import com.management.components.proveedor.ProveedorPanel;

import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    private Usuario usuario;
    private JPanel pagePrincipal, panelProducto, panelEmpleado, panelProveedor, panelInventario, sidebar, panelMovimientos;
    private JButton buttonProductos, buttonEmpleados, buttonProveedores, buttonInventarios, buttonMovimientos;

    public Dashboard(int ci) {
        this.usuario = ArchivoUsuario.getUser(ci);
        if(usuario.getCargo().equals("encargado")){


            setTitle("Q'BARATO");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(1400, 800);
            setLocationRelativeTo(null);

            // HOME PAGE

            pagePrincipal = new JPanel();
            pagePrincipal.setBackground(Color.WHITE);
            JLabel bienvenidaLabel = new JLabel("Hola Bienvenido a Q barato");
            pagePrincipal.add(bienvenidaLabel);


            panelProducto = new ProductoPanel();
            panelEmpleado = new EmpleadoPanel();
            panelProveedor = new ProveedorPanel();
            panelInventario = new InventarioPanel();
            panelMovimientos = new MovimientosPanel();



            /// SIDEBAR
            buttonProductos = new JButton("Productos");
            buttonProductos.addActionListener(this);
            buttonEmpleados = new JButton("Empleados");
            buttonEmpleados.addActionListener(this);
            buttonProveedores = new JButton("Proveedores");
            buttonProveedores.addActionListener(this);
            buttonInventarios = new JButton("Inventarios");
            buttonInventarios.addActionListener(this);
            buttonMovimientos = new JButton("Movimientos");
            buttonMovimientos.addActionListener(this);
            JButton butttonReportesGraficos = new JButton("Reportes");
            // butttonReportesGraficos.addActionListener(this);
            butttonReportesGraficos.addActionListener((e) -> {
                AnalystRoot.initApplicationFXML();
            });


            JLabel logoLabel = new JLabel("😉 Q'BARATO");
            logoLabel.setForeground(Color.WHITE);

            sidebar = new JPanel();
            sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
            sidebar.setPreferredSize(new Dimension(200, 800));
            sidebar.setLayout(new GridLayout(20, 1));
            sidebar.add(logoLabel);
            sidebar.add(Box.createRigidArea(new Dimension(0, 30)));
            sidebar.add(buttonProductos);
            sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
            sidebar.add(buttonEmpleados);
            sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
            sidebar.add(buttonProveedores);
            sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
            sidebar.add(buttonInventarios);
            sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
            sidebar.add(buttonMovimientos);
            sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
            sidebar.add(butttonReportesGraficos);
            sidebar.setBackground(Color.DARK_GRAY);


            setLayout(new BorderLayout());
            add(sidebar, BorderLayout.WEST);
            add(pagePrincipal, BorderLayout.CENTER);
            setVisible(true);
        }

        if(usuario.getCargo().equals("empleado")){


            setTitle("Q'BARATO");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(1400, 800);
            setLocationRelativeTo(null);

            // HOME PAGE

            pagePrincipal = new JPanel();
            pagePrincipal.setBackground(Color.WHITE);
            JLabel bienvenidLabel = new JLabel("Hola Bienvenido a Q barato");
            pagePrincipal.add(bienvenidLabel);


            panelProducto = new ProductoPanel();

            /// SIDEBAR
            buttonProductos = new JButton("Productos");
            buttonProductos.addActionListener(this);

            JLabel logoLabel = new JLabel("😉 Q'BARATO");
            logoLabel.setForeground(Color.WHITE);
            sidebar = new JPanel();
            sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
            sidebar.setPreferredSize(new Dimension(200, 800));
            sidebar.setLayout(new GridLayout(20, 1));
            sidebar.add(logoLabel);
            sidebar.add(Box.createRigidArea(new Dimension(0, 30)));
            sidebar.add(buttonProductos);
            sidebar.setBackground(Color.DARK_GRAY);


            setLayout(new BorderLayout());
            add(sidebar, BorderLayout.WEST);
            add(pagePrincipal, BorderLayout.CENTER);
            setVisible(true);
        }

    }


    // Manejo de eventos de los botones del sidebar

    public void actionPerformed(ActionEvent e) {
        if(usuario.getCargo().equals("encargado")){
            if (e.getSource() == buttonProductos) {
                remove(pagePrincipal);
                remove(panelProveedor);
                remove(panelEmpleado);
                remove(panelInventario);
                remove(panelMovimientos);
                add(panelProducto);
                revalidate();
                repaint();
            }

            if (e.getSource() == buttonEmpleados) {
                remove(pagePrincipal);
                remove(panelProveedor);
                remove(panelProducto);
                remove(panelInventario);
                remove(panelMovimientos);
                add(panelEmpleado);
                revalidate();
                repaint();
            }

            if (e.getSource() == buttonProveedores) {
                remove(pagePrincipal);
                remove(panelEmpleado);
                remove(panelProducto);
                remove(panelInventario);
                remove(panelMovimientos);
                add(panelProveedor);
                revalidate();
                repaint();
            }
            if (e.getSource() == buttonInventarios) {
                remove(pagePrincipal);
                remove(panelEmpleado);
                remove(panelProducto);
                remove(panelProveedor);
                remove(panelMovimientos);
                add(panelInventario);
                revalidate();
                repaint();
            }

            if (e.getSource() == buttonMovimientos) {
                remove(pagePrincipal);
                remove(panelEmpleado);
                remove(panelProducto);
                remove(panelProveedor);
                remove(panelInventario);
                add(panelMovimientos);
                revalidate();
                repaint();
            }
        }

        if(usuario.getCargo().equals("empleado")){
            if (e.getSource() == buttonProductos) {
                remove(pagePrincipal);
                add(panelProducto);
                revalidate();
                repaint();
            }
        }
    }

    public void existencias(JPanel panel){
        remove(pagePrincipal);
                remove(panelEmpleado);
                remove(panelProducto);
                remove(panelInventario);
                remove(panelMovimientos);
                remove(panelProveedor);
                add(panel);
                revalidate();
                repaint();
    }
}
