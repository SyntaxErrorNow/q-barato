package com.management.vista.Formularios.Usuario;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.management.Usuario;
import com.management.Archivos.ArchivoUsuario;
import com.management.modelo.utils.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;

public class FormularioRegistrarUsuario extends JFrame implements ActionListener {

    JTextField nombre;
    JPasswordField contrasena;
    JTextField edad;
    JTextField ci;
    JComboBox<String> cargo;
    JButton botonEnvio;
    JLabel nombreLabel, contrasenaLabel, ciLabel, cargoLabel, edadLabel;
    static String nombreField, contrasenaField, ciField, cargoField, edadField;
    String[] cargos = {"empleado","encargado"};


    public FormularioRegistrarUsuario(Usuario usuario){
        super("Registrar Usuario");
        setLayout(new FlowLayout());
        nombre = new JTextField(20);
        nombre.setText(usuario.getNombre());
        nombreLabel = new JLabel("Nombre");

        contrasena = new JPasswordField(20);
        contrasena.setText(usuario.getContrasena());
        contrasenaLabel = new JLabel("Contraseña");

        ci = new JTextField(20);
        ci.setText(String.valueOf(usuario.getCi()));
        ciLabel = new JLabel("Carnet de Identidad");
        Utils.numInteger(ci);

        cargo = new JComboBox<>(cargos);
        cargo.setSelectedItem(usuario.getCargo());;
        cargoLabel = new JLabel("Cargo ");

        edad = new JTextField(20);
        edad.setText(String.valueOf(usuario.getEdad()));
        edadLabel = new JLabel("Edad");
        Utils.numInteger(edad);

        botonEnvio = new JButton();
        botonEnvio.setText("Modificar");
        botonEnvio.addActionListener(this);


        add(nombreLabel);
        add(nombre);
        add(ciLabel);
        add(ci);
        add(edadLabel);
        add(edad);
        add(contrasenaLabel);
        add(contrasena);
        add(cargoLabel);
        add(cargo);
        add(botonEnvio);
        ArchivoUsuario.deleteUsario(usuario.getCi());

        this.setSize(250,350);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
    }


    public FormularioRegistrarUsuario(){
        super("Registrar Usuario");
        setLayout(new FlowLayout());
        nombre = new JTextField(20);
        nombreLabel = new JLabel("Nombre");

        contrasena = new JPasswordField(20);
        contrasenaLabel = new JLabel("Contraseña");

        ci = new JTextField(20);
        ciLabel = new JLabel("Carnet de Identidad");
        Utils.numInteger(ci);

        cargo = new JComboBox<>(cargos);
        cargoLabel = new JLabel("Cargo");

        edad = new JTextField(20);
        edadLabel = new JLabel("Edad");
        Utils.numInteger(edad);

        botonEnvio = new JButton();
        botonEnvio.setText("Registrar");
        botonEnvio.addActionListener(this);

        add(nombreLabel);
        add(nombre);
        add(ciLabel);
        add(ci);
        add(edadLabel);
        add(edad);
        add(contrasenaLabel);
        add(contrasena);
        add(cargoLabel);
        add(cargo);
        add(botonEnvio);

        this.setSize(250,350);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nombreField = nombre.getText();
        contrasenaField = String.valueOf(contrasena.getPassword());
        int ciField = Integer.parseInt(ci.getText());
        cargoField = (String)cargo.getItemAt(cargo.getSelectedIndex());
        int edadField = Integer.parseInt(edad.getText());

        if(nombreField.equals("") || contrasenaField.equals("") || ciField <= 0 || cargoField.equals("") || edadField <= 0){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");

        }else{

            Usuario usuario = new Usuario(nombreField, edadField, ciField, contrasenaField, cargoField);
            ArchivoUsuario.postUser(usuario);
            setVisible(false);

        }
    }


}
