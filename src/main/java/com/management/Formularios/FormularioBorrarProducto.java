package com.management.Formularios;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.management.Archivo;

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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String idField = (id.getText());
        if(idField.equals("")){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");
        }else{
            System.out.println(Archivo.getProducto(idField).toString());
            Archivo.deleteProducto(Archivo.getProducto(idField));
            JOptionPane.showMessageDialog(null, "Eliminado satisfactoriamente");
        }
    }
}