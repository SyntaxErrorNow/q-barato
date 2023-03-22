package com.management.Formularios;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.management.Archivo;
import com.management.Producto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioModificarProducto extends JFrame implements ActionListener{
    JTextField ID;
    JLabel texto;

    public FormularioModificarProducto(){
        setLayout(new FlowLayout());
        texto = new JLabel("ID");
        ID = new JTextField(20);
        ID.addActionListener(this);
        add(texto);
        add(ID);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String idField = ID.getText();

            Producto producto =  Archivo.getProducto(idField);
            FormularioModificarInfoProducto form = new FormularioModificarInfoProducto(producto);
            form.setSize(250,550);
            form.setResizable(false);
            form.setLocationRelativeTo(null);
            form.getContentPane().setBackground(Color.WHITE);
            form.setVisible(true);
            setVisible(false);

    }


}
