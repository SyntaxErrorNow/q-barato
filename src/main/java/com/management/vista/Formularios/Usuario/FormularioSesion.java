package com.management.vista.Formularios.Usuario;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.management.Usuario;
import com.management.Archivos.ArchivoUsuario;
import com.management.modelo.utils.Utils;
import com.management.vista.Dashboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
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

        this.setSize(250,300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int ciField =  Integer.parseInt(ci.getText());

        contrasenaField = String.valueOf(contrasena.getPassword());


        Usuario usuario = ArchivoUsuario.getUser(ciField);
        if(usuario == null || ciField <= 0 || contrasenaField.equals("")){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");
        }else if(ciField == usuario.getCi() && contrasenaField.equals(usuario.getContrasena())){
            new Dashboard(usuario.getCi());
            setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "Los datos con incorrectos");
        }


    }
}
