package com.management.Formularios;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.management.Archivo;
import com.management.Utils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioBorrarUsuario extends JFrame implements ActionListener{
    JTextField ci;
    JLabel texto;

    public FormularioBorrarUsuario(){
        setLayout(new FlowLayout());
        texto = new JLabel("Carnet de identidad");
        ci = new JTextField(20);
        ci.addActionListener(this);
        Utils.numInteger(ci);
        add(texto);
        add(ci);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int ciField = Integer.parseInt(ci.getText());
        if(ciField <= 0){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");
        }else{
            Archivo.deleteUsario(ciField);
            JOptionPane.showMessageDialog(null, "Eliminado satisfactoriamente");
        }
    }
}
