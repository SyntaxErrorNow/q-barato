package com.management;
import javax.swing.*;

import com.management.Archivos.ArchivoUsuario;
import com.management.Formularios.Producto.FormularioBorrarProducto;
import com.management.Formularios.Producto.FormularioBorrarProductosDeUnaCategoria;
import com.management.Formularios.Producto.FormularioBuscarProducto;
import com.management.Formularios.Producto.FormularioComprobarExistenciaProducto;
import com.management.Formularios.Producto.FormularioDescuento;
import com.management.Formularios.Producto.FormularioElegirCategoriaReabastecer;
import com.management.Formularios.Producto.FormularioImprimirEtiqueta;
import com.management.Formularios.Producto.FormularioModificarProducto;
import com.management.Formularios.Producto.FormularioMostrarProducto;
import com.management.Formularios.Producto.FormularioRegistrarMovimientos;
import com.management.Formularios.Producto.FormularioRegistrarProducto;
import com.management.Formularios.Producto.FormularioRegistrarProductoTemporada;
import com.management.Formularios.Producto.FormularioVerificarEstadoProducto;
import com.management.Formularios.Proveedor.FormularioEliminarProveedor;
import com.management.Formularios.Proveedor.FormularioPedirIDProveedor;
import com.management.Formularios.Proveedor.FormularioRegistrarProveedor;
import com.management.Formularios.Usuario.FormularioBorrarUsuario;
import com.management.Formularios.Usuario.FormularioModificarUsuario;
import com.management.Formularios.Usuario.FormularioRegistrarUsuario;

import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    private Usuario usuario;
    private JPanel pagePrincipal, pageProductos, pageEmpleados, pageProveedores, sidebar;
    private JButton buttonProductos, buttonEmpleados, buttonProveedores;

    public Dashboard(int ci) {
        this.usuario = ArchivoUsuario.getUser(ci);
        if(usuario.getCargo().equals("encargado")){


            setTitle("Q'BARATO");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(1000, 800);

            // HOME PAGE

            pagePrincipal = new JPanel();
            pagePrincipal.setBackground(Color.WHITE);
            JLabel summaryLabel = new JLabel("Hola Bienvenido a Q barato");
            pagePrincipal.add(summaryLabel);


            /// PRODUCTOS
            JButton buttonRegistrarProducto = new JButton("Registrar Producto");
            buttonRegistrarProducto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioRegistrarProducto();
                }
            });
            JButton buttonModificarProducto = new JButton("Modificar Producto");
            buttonModificarProducto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioModificarProducto();
                }
            });
            JButton buttonEliminarProducto = new JButton("Eliminar Producto");
            buttonEliminarProducto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioBorrarProducto();
                }
            });
            JButton buttonMostrarInformacionProducto = new JButton("Mostrar informacion de un Producto");
            buttonMostrarInformacionProducto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioMostrarProducto();
                }
            });
            JButton buttonRegistrarProductoTemporada = new JButton("Registrar Producto por Temporada");
            buttonRegistrarProductoTemporada.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioRegistrarProductoTemporada();
                }
            });
            JButton buttonEliminarProductosCategoria = new JButton("Eliminar los productos de una categoria");
            buttonEliminarProductosCategoria.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioBorrarProductosDeUnaCategoria();
                }
            });
            JButton buttonVerificarProductoEstado = new JButton("Verificar estado de un producto");
            buttonVerificarProductoEstado.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioVerificarEstadoProducto();
                }
            });
            JButton buttonRegsitrarMovimientoProducto = new JButton("Registrar movimientos de un producto");
            buttonRegsitrarMovimientoProducto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioRegistrarMovimientos();
                }
            });
            JButton buttonBuscarProducto = new JButton("Buscar un producto");
            buttonBuscarProducto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioBuscarProducto();
                }
            });
            JButton buttonComprobarCantidadProducto = new JButton("Comprobar cantidad disponible de un producto");
            buttonComprobarCantidadProducto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioComprobarExistenciaProducto();
                }
            });
            JButton buttonReabastecerProducto = new JButton("Reabasteser producto");
            buttonReabastecerProducto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioElegirCategoriaReabastecer();
                }
            });
            JButton buttonSugerirDescuento = new JButton("Sugerir descuento");
            buttonSugerirDescuento.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioDescuento();
                }
            });



            /// EMPLEADO

            JButton buttonRegistrarEmpleado = new JButton("Registrar Empleados");
            buttonRegistrarEmpleado.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioRegistrarUsuario();
                }
            });
            JButton buttonModificarEmpleado = new JButton("Modificar Empleados");
            buttonModificarEmpleado.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioModificarUsuario();
                }
            });
            JButton buttonEliminarEmpleado = new JButton("Eliminar Empleados");
            buttonEliminarEmpleado.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioBorrarUsuario();
                }
            });



            /// PROVEEDORES

            JButton buttonRegistrarProveedores = new JButton("Registrar Proveedores");
            buttonRegistrarProveedores.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioRegistrarProveedor();
                }
            });
            JButton buttonModificarProveedores = new JButton("Modificar Proveedores");
            buttonModificarProveedores.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioPedirIDProveedor();
                }
            });
            JButton buttonEliminarProveedores = new JButton("Eliminar Proveedores");
            buttonEliminarProveedores.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioEliminarProveedor();
                }
            });

            pageProductos = new JPanel(new GridLayout(10, 1));
            JLabel panel1Label = new JLabel("Productos");
            pageProductos.add(panel1Label);
            pageProductos.add(buttonRegistrarProducto);
            pageProductos.add(buttonModificarProducto);
            pageProductos.add(buttonEliminarProducto);
            pageProductos.add(buttonMostrarInformacionProducto);
            pageProductos.add(buttonRegistrarProductoTemporada);
            pageProductos.add(buttonEliminarProductosCategoria);
            pageProductos.add(buttonVerificarProductoEstado);
            pageProductos.add(buttonRegsitrarMovimientoProducto);
            pageProductos.add(buttonBuscarProducto);
            pageProductos.add(buttonComprobarCantidadProducto);
            pageProductos.add(buttonReabastecerProducto);
            pageProductos.add(buttonSugerirDescuento);

            pageEmpleados = new JPanel(new GridLayout(17, 1));
            JLabel panel2Label = new JLabel("Empleados");
            pageEmpleados.add(panel2Label);
            pageEmpleados.add(buttonRegistrarEmpleado);
            pageEmpleados.add(buttonModificarEmpleado);
            pageEmpleados.add(buttonEliminarEmpleado);


            pageProveedores = new JPanel(new GridLayout(17, 1));
            JLabel panel3Label = new JLabel("Proveedores");
            pageProveedores.add(panel3Label);
            pageProveedores.add(buttonRegistrarProveedores);
            pageProveedores.add(buttonModificarProveedores);
            pageProveedores.add(buttonEliminarProveedores);



            /// SIDEBAR

            // Creación de los botones del sidebar
            buttonProductos = new JButton("Productos");
            buttonProductos.addActionListener(this);

            buttonEmpleados = new JButton("Empleados");
            buttonEmpleados.addActionListener(this);

            buttonProveedores = new JButton("Proveedores");
            buttonProveedores.addActionListener(this);



            // Creación del sidebar
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
            sidebar.setBackground(Color.DARK_GRAY);


            // Configuración del layout de la ventana
            setLayout(new BorderLayout());
            add(sidebar, BorderLayout.WEST);
            add(pagePrincipal, BorderLayout.CENTER);
            setVisible(true);
        }

        if(usuario.getCargo().equals("empleado")){


            setTitle("Q'BARATO");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(1000, 800);

            // HOME PAGE

            pagePrincipal = new JPanel();
            pagePrincipal.setBackground(Color.WHITE);
            JLabel summaryLabel = new JLabel("Hola Bienvenido a Q barato");
            pagePrincipal.add(summaryLabel);


            /// PRODUCTOS

            JButton buttonMostrarInformacionProducto = new JButton("Mostrar informacion de un Producto");
            buttonMostrarInformacionProducto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioMostrarProducto();
                }
            });

            JButton buttonVerificarProductoEstado = new JButton("Verificar estado de un producto");
            buttonVerificarProductoEstado.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioVerificarEstadoProducto();
                }
            });

            JButton buttonBuscarProducto = new JButton("Buscar un producto");
            buttonBuscarProducto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioBuscarProducto();
                }
            });
            JButton buttonComprobarCantidadProducto = new JButton("Comprobar cantidad disponible de un producto");
            buttonComprobarCantidadProducto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioComprobarExistenciaProducto();
                }
            });
            JButton buttonReabastecerProducto = new JButton("Reabasteser producto");
            buttonReabastecerProducto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioElegirCategoriaReabastecer();
                }
            });

            JButton buttonImprimirEtiqueta = new JButton("Imprimir Etiqueta");
            buttonImprimirEtiqueta.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioImprimirEtiqueta();
                }
            });

            pageProductos = new JPanel(new GridLayout(20, 1));
            JLabel panel1Label = new JLabel("Productos");
            pageProductos.add(panel1Label);
            pageProductos.add(buttonMostrarInformacionProducto);
            pageProductos.add(buttonVerificarProductoEstado);
            pageProductos.add(buttonBuscarProducto);
            pageProductos.add(buttonComprobarCantidadProducto);
            pageProductos.add(buttonReabastecerProducto);


            /// SIDEBAR
            buttonProductos = new JButton("Productos");
            buttonProductos.addActionListener(this);


            // Creación del sidebar
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

            // Configuración del layout de la ventana
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
                remove(pageProveedores);
                remove(pageEmpleados);
                add(pageProductos, BorderLayout.CENTER);
                revalidate();
                repaint();
            }

            if (e.getSource() == buttonEmpleados) {
                remove(pagePrincipal);
                remove(pageProveedores);
                remove(pageProductos);
                add(pageEmpleados, BorderLayout.CENTER);
                revalidate();
                repaint();
            }

            if (e.getSource() == buttonProveedores) {
                remove(pagePrincipal);
                remove(pageEmpleados);
                remove(pageProductos);
                add(pageProveedores, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        }

        if(usuario.getCargo().equals("empleado")){
            if (e.getSource() == buttonProductos) {
                remove(pagePrincipal);
                add(pageProductos, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        }
    }
}
