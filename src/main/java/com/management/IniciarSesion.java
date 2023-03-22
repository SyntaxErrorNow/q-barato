package com.management;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IniciarSesion extends JFrame implements ActionListener{
    private Usuario usuario;
    JTextField ci, id;
    JLabel texto;
    JButton registrarEmpleado, registrarProducto, modificarEmpleado, eliminarEmpleado, mostrarInformacionProducto,modificarInformacionProducto ,borrarProducto, buscarProducto;

    public IniciarSesion(int ciUsuario){
        this.usuario = Archivo.getUser(ciUsuario);
        if(usuario.getCargo().equals("encargado")){
                    setLayout(new FlowLayout());
                    texto = new JLabel("Bienvenido a Q' Barato");
                    texto.setFont(new Font("Verdana", Font.BOLD + Font.ITALIC, 10));
                    texto.setForeground(Color.BLACK);

                    registrarEmpleado = new JButton("Registrar empleado");
                    registrarEmpleado.addActionListener(this);

                    registrarProducto = new JButton("Registrar producto");
                    registrarProducto.addActionListener(this);

                    modificarEmpleado = new JButton("Modificar empleado");
                    modificarEmpleado.addActionListener(this);

                    eliminarEmpleado = new JButton("Eliminar empleado");
                    eliminarEmpleado.addActionListener(this);

                    mostrarInformacionProducto = new JButton("Mostrar informacion de un producto");
                    mostrarInformacionProducto.addActionListener(this);

                    modificarInformacionProducto = new JButton("Modificar informacion de un producto");
                    modificarInformacionProducto.addActionListener(this);

                    borrarProducto = new JButton("Borrar un producto");
                    borrarProducto.addActionListener(this);

                    buscarProducto = new JButton("Buscar un producto");
                    buscarProducto.addActionListener(this);

                    add(texto);
                    add(registrarEmpleado);
                    add(registrarProducto);
                    add(modificarEmpleado);
                    add(eliminarEmpleado);
                    add(mostrarInformacionProducto);
                    add(modificarInformacionProducto);
                    add(buscarProducto);
                    add(borrarProducto);

                    setVisible(true);
        }

        if(usuario.getCargo().equals("empleado")){
            setLayout(new FlowLayout());
                    texto = new JLabel("Bienvenido a Q' Barato");
                    texto.setFont(new Font("Verdana", Font.BOLD + Font.ITALIC, 10));
                    texto.setForeground(Color.BLACK);

                    mostrarInformacionProducto = new JButton("Mostrar informacion de un producto");
                    mostrarInformacionProducto.addActionListener(this);

                    buscarProducto = new JButton("Buscar un producto");
                    buscarProducto.addActionListener(this);

                    add(texto);
                    add(mostrarInformacionProducto);
                    add(buscarProducto);
                    setVisible(true);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(usuario.getCargo().equals("encargado")){

            Encargado encargado = Archivo.getEncargado(usuario.getCi());

            if(e.getSource() == registrarEmpleado){
                encargado.registrarEmpleado();
            }

            if(e.getSource() == registrarProducto){
                encargado.registrarProducto();
            }

            if(e.getSource() == modificarEmpleado){
                encargado.modificarEmpleado();
            }

            if(e.getSource() == eliminarEmpleado){
                encargado.eliminarEmpleado();
            }

            if(e.getSource() == mostrarInformacionProducto){
                encargado.mostrarInformacionProducto();
            }

            if(e.getSource() == modificarInformacionProducto){
                encargado.modificarProducto();
            }

            if(e.getSource() == borrarProducto){
                encargado.eliminarProducto();
            }
            if(e.getSource() == buscarProducto){
                usuario.buscarProducto();
            }

        }

        if(usuario.getCargo().equals("empleado")){
            if(e.getSource() == mostrarInformacionProducto){
                usuario.mostrarInformacionProducto();
            }
            if(e.getSource() == buscarProducto){
                usuario.buscarProducto();
            }
        }




    }


}
