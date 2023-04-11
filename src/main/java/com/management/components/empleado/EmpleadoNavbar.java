package com.management.components.empleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.management.Formularios.Usuario.FormularioRegistrarUsuario;

public class EmpleadoNavbar extends JPanel{



    public EmpleadoNavbar(){
        setLayout(null);

        JTextField buscador = new JTextField();
        buscador.setBounds(50, 20, 200, 20);
        add(buscador);

        JButton buttonRegistrarEmpleado = new JButton("+ Registrar");
            buttonRegistrarEmpleado.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioRegistrarUsuario();
                }
            });
        buttonRegistrarEmpleado.setBounds(810, 20, 110, 20);
        add(buttonRegistrarEmpleado);
    }

}
