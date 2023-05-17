package com.management.vista.components.inventario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.management.vista.Formularios.Inventario.FormularioHacerInventario;
import com.management.vista.Formularios.Inventario.FormularioRecuperarInventarioPasado;



public class InventarioNavbar extends JPanel{

    public InventarioNavbar(){
        setLayout(null);


        JButton buttonHacerInventarios = new JButton("+ Inventarios");
        buttonHacerInventarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormularioHacerInventario();
            }
        });
        buttonHacerInventarios.setBounds(820, 20, 130, 20);
        add(buttonHacerInventarios);

        JButton buttonRecuperarInventarios = new JButton("+ Recuperar Inventarios");
        buttonRecuperarInventarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormularioRecuperarInventarioPasado();
            }
        });
        buttonRecuperarInventarios.setBounds(960, 20, 200, 20);
        add(buttonRecuperarInventarios);


    }

}

