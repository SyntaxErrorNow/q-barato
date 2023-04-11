package com.management.components.inventario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.management.Inventario;
import com.management.Producto;



public class ExistenciasNavbar extends JPanel{

    public ExistenciasNavbar(Inventario inventario){
        setLayout(null);


        JButton buttonDevolverMasVendidos = new JButton("+ Vendidos");
        buttonDevolverMasVendidos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> masVendidos = inventario.determinarProductosMasVendidos(3);
                String respuesta = "";
                for(String producto:masVendidos){
                    respuesta += " - "+producto;
                }
                JOptionPane.showMessageDialog(null, "Los productos mas vendidos son: \n"+respuesta);
            }
        });
        buttonDevolverMasVendidos.setBounds(750, 20, 130, 20);
        add(buttonDevolverMasVendidos);

        JButton buttonDevolverEscasos = new JButton("- Cantidad");
        buttonDevolverEscasos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Producto> escasos = inventario.devolverProductosConPocasUnidades();
                String respuesta = "";
                for(Producto producto:escasos){
                    respuesta += " - "+producto.getNombre();
                }
                JOptionPane.showMessageDialog(null, "Los productos con menos unidades son: \n"+respuesta);
            }
        });
        buttonDevolverEscasos.setBounds(890, 20, 130, 20);
        add(buttonDevolverEscasos);
        
        JButton buttonDevolverEstaticos = new JButton("* Estaticos");
        buttonDevolverEstaticos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int[] sex = {70,50,30};
                ArrayList<ArrayList<Producto>> estaticos = inventario.devolverProductosEstaticos(0.4);
                String respuesta = "";
                for(int i = 0; i<estaticos.size(); i++){
                    for(int j = 0; j < estaticos.get(i).size(); j++){
                        respuesta += " - "+estaticos.get(i).get(j).getNombre() + "    " + sex[i]+"%" +  "\n";
                    }
                }
                JOptionPane.showMessageDialog(null, "SUGERENCIA DE DESCUENTO: \n"+respuesta);
            }

        });

        buttonDevolverEstaticos.setBounds(1030, 20, 130, 20);
        add(buttonDevolverEstaticos);

    }

}

