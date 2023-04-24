package com.management.Formularios.Producto;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;

import com.management.Archivos.ArchivoProducto;
import com.management.utils.Utils;
import com.management.Producto;

public class FormularioImprimirEtiqueta extends JFrame implements ActionListener {
    JButton botonEnvio;
    JTextField numeroImpreciones,ID;
    JLabel numeroImprecionesLabel,texto;
    static String numeroImprecionesField;

        public FormularioImprimirEtiqueta(){


            super("Imprimir etiqueta");
            setLayout(new FlowLayout());
            texto = new JLabel("ID del producto");
            ID = new JTextField(20);

            numeroImpreciones=new JTextField(20);
            numeroImprecionesLabel=new JLabel("Numero de impreciones");
            Utils.numInteger(numeroImpreciones);

            botonEnvio = new JButton();
            botonEnvio.setText("Imprimir");
            botonEnvio.addActionListener(this);

            add(texto);
            add(ID);
            add(numeroImpreciones);
            add(numeroImprecionesLabel);
            add(botonEnvio);


            this.setSize(700,250);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.getContentPane().setBackground(Color.WHITE);
            this.setVisible(true);
        }
        @Override
        public void actionPerformed(ActionEvent e) {

            String IDField = ID.getText();
            int numeroImprecionesField=Integer.parseInt(numeroImpreciones.getText());
            if(IDField.equals("")){
                JOptionPane.showMessageDialog(null, "Los datos son requeridos");
            }else{
                Producto producto = ArchivoProducto.getProducto(IDField);
                if(producto!=null){
                for (int i = 0; i < numeroImprecionesField; i++) {
                    System.out.println("\nEtiqueta de Producto:");
                    System.out.println("--------------------");
                    System.out.println("ID: " + IDField);
                    System.out.println("Nombre: " + producto.getNombre());
                    System.out.println("Precio: " + producto.getPrecio() + "Bs");
                    System.out.println("Fecha de caducidad: " + producto.getFechaCaducidad());
                    System.out.println("--------------------");
                }
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "El producto no existe");
            }

        }
    }
}