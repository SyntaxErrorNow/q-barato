package com.management.Formularios;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.management.Archivo;
import com.management.Producto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class FormularioMostrarProducto extends JFrame implements ActionListener{
    JTextField ID;
    JLabel texto;

    public FormularioMostrarProducto(){
        setLayout(new FlowLayout());
        texto = new JLabel("ID del producto");
        ID = new JTextField(20);
        ID.addActionListener(this);
        add(texto);
        add(ID);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String IDField = ID.getText();
        if(IDField.equals("")){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");
        }else{
            Producto producto = Archivo.getProducto(IDField);
            System.out.println(producto);
            setVisible(false);
        }
    }

}
