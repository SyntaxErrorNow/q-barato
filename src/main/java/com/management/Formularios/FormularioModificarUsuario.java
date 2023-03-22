package com.management.Formularios;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.management.Archivo;
import com.management.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioModificarUsuario extends JFrame implements ActionListener{
    JTextField ci;
    JLabel texto;

    public FormularioModificarUsuario(){
        setLayout(new FlowLayout());
        texto = new JLabel("Carnet de identidad");
        ci = new JTextField(20);
        ci.addActionListener(this);
        add(texto);
        add(ci);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int ciField = Integer.parseInt(ci.getText());
        if(ciField <= 0){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");
        }else{
            Usuario usuario =  Archivo.getUser(ciField);
            FormularioRegistrarUsuario form = new FormularioRegistrarUsuario(usuario);
            form.setSize(250,350);
            form.setResizable(false);
            form.setLocationRelativeTo(null);
            form.getContentPane().setBackground(Color.WHITE);
            form.setVisible(true);
            setVisible(false);
        }
    }


}
