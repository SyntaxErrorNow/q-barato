package com.management.vista.components.proveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.management.vista.Formularios.Proveedor.FormularioRegistrarProveedor;


public class ProveedorNavbar extends JPanel{

    public ProveedorNavbar(){
        setLayout(null);

        JTextField buscador = new JTextField();
        buscador.setBounds(50, 20, 200, 20);
        add(buscador);

        JButton buttonRegistrarEmpleado = new JButton("+ Registrar");
            buttonRegistrarEmpleado.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FormularioRegistrarProveedor();
                }
            });
        buttonRegistrarEmpleado.setBounds(810, 20, 110, 20);
        add(buttonRegistrarEmpleado);
    }

}
