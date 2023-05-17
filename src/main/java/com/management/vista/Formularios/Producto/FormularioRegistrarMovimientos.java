package com.management.vista.Formularios.Producto;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Color;
public class FormularioRegistrarMovimientos extends JFrame implements ActionListener {
    JTextField nombre;
    JLabel texto;
    JButton venderProducto, registrarPerdida;

    public FormularioRegistrarMovimientos(){
        setLayout(new FlowLayout());
        venderProducto = new JButton("Vender Productos");
        venderProducto.addActionListener(this);

        registrarPerdida = new JButton("Registrar perdidas de un producto");
        registrarPerdida.addActionListener(this);

        add(venderProducto);
        add(registrarPerdida);

        this.setSize(700,250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == venderProducto){
            FormularioRegistrarVenta form = new FormularioRegistrarVenta();
            form.setSize(250,250);
            form.setResizable(false);
            form.setLocationRelativeTo(null);
            form.getContentPane().setBackground(Color.WHITE);
            form.setVisible(true);
        }

        if(e.getSource() == registrarPerdida){
            FormularioRegistrarPerdida form = new FormularioRegistrarPerdida();
            form.setSize(250,250);
            form.setResizable(false);
            form.setLocationRelativeTo(null);
            form.getContentPane().setBackground(Color.WHITE);
            form.setVisible(true);
        }
    }

}
