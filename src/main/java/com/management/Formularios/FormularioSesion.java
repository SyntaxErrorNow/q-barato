package com.management.Formularios;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.management.Archivo;
import com.management.IniciarSesion;
import com.management.Usuario;
import com.management.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class FormularioSesion extends JFrame implements ActionListener {

    JTextField ci;
    JPasswordField contrasena;
    static String ciField, contrasenaField;
    JLabel ciLabel, contrasenaLabel;

    public FormularioSesion(){
        super("Iniciar Sesion");
        setLayout(new FlowLayout());
        ci = new JTextField(20);
        ci.addActionListener(this);
        ciLabel = new JLabel("Carnet de Identidad");
        Utils.numInteger(ci);

        contrasena = new JPasswordField(20);
        contrasena.addActionListener(this);
        contrasenaLabel = new JLabel("Contraseña");
        add(ciLabel);
        add(ci);
        add(contrasenaLabel);
        add(contrasena);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int ciField =  Integer.parseInt(ci.getText());

        contrasenaField = String.valueOf(contrasena.getPassword());

        Usuario usuario = Archivo.getUser(ciField);

        if(ciField <= 0 || contrasenaField.equals("")){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");
        }else if(ciField == usuario.getCi() && contrasenaField.equals(usuario.getContrasena())){
            IniciarSesion iniciarSesion = new IniciarSesion(ciField);
            iniciarSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            iniciarSesion.setSize(1000, 900);
            iniciarSesion.setResizable(false);
            iniciarSesion.setLocationRelativeTo(null);
            iniciarSesion.setVisible(true);
            setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "Los datos con incorrectos");
        }


    }
}
