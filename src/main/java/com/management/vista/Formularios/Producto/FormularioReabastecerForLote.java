package com.management.vista.Formularios.Producto;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.management.Archivos.ArchivoProducto;
import com.management.modelo.utils.Utils;

public class FormularioReabastecerForLote extends JFrame{
    private JTextField cantidad;
    public FormularioReabastecerForLote(){
        setLayout(new FlowLayout());
        setSize(300, 300);
        setLocationRelativeTo(null);


        JLabel cantidadLabel = new JLabel("Ingrese la cantidad que quiera reabastecer");
        cantidad = new JTextField(20);
        Utils.numInteger(cantidad);

        add(cantidadLabel);
        add(cantidad);

        JButton reabastecer = new JButton("Reabastecer");
        reabastecer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String cantidadField = cantidad.getText();

                if(cantidadField.equals("")){
                    JOptionPane.showMessageDialog(cantidad, "La cantidad es requerida");
                }else if(ArchivoProducto.reabastecerProductosLote(Integer.parseInt(cantidadField)).size() == 0){
                    JOptionPane.showMessageDialog(null, "No hay productos que requieran reabastecerce");
                }else{
                    ArchivoProducto.reabastecerProductosLote(Integer.parseInt(cantidadField));
                    JOptionPane.showMessageDialog(null, "Se solicito el reabastecimiento existosamente");
                    setVisible(false);
                }
            }
        });
        add(reabastecer);

        setVisible(true);
    }


}
