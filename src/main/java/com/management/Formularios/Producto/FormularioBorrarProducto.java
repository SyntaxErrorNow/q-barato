package com.management.Formularios.Producto;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.management.Archivos.ArchivoProducto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioBorrarProducto extends JFrame implements ActionListener{
    JTextField id;
    JLabel texto;

    public FormularioBorrarProducto(){
        setLayout(new FlowLayout());
        texto = new JLabel("ID del producto");
        id = new JTextField(20);
        id.addActionListener(this);
        add(texto);
        add(id);

        this.setSize(250,200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String idField = (id.getText());
        if(idField.equals("")){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");
        }else{
            System.out.println(ArchivoProducto.getProducto(idField).toString());
            ArchivoProducto.deleteProducto(ArchivoProducto.getProducto(idField));
            JOptionPane.showMessageDialog(null, "Eliminado satisfactoriamente");
        }
    }
}