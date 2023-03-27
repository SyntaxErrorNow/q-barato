package com.management.Formularios.Usuario;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.management.Usuario;
import com.management.Archivos.ArchivoUsuario;

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

        this.setSize(250,200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int ciField = Integer.parseInt(ci.getText());
        if(ciField <= 0){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");
        }else{
            Usuario usuario =  ArchivoUsuario.getUser(ciField);
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
