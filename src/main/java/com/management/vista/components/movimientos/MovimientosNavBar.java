package com.management.vista.components.movimientos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.management.vista.Formularios.Producto.FormularioRegistrarPerdida;
import com.management.vista.Formularios.Producto.FormularioRegistrarVenta;



public class MovimientosNavBar extends JPanel{

    public MovimientosNavBar(){
        setLayout(null);

        JButton buttonVenderProducto= new JButton("+Vender");
        buttonVenderProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormularioRegistrarVenta();
            }
        });
        buttonVenderProducto.setBounds(850, 10, 130, 20);
        add(buttonVenderProducto);


        JButton buttonPerderProducto= new JButton("+Perdidas");
        buttonPerderProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormularioRegistrarPerdida();
            }
        });
        buttonPerderProducto.setBounds(1000, 10, 130, 20);
        add(buttonPerderProducto);




    }

}


