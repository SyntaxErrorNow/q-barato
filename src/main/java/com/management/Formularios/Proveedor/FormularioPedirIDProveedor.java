package com.management.Formularios.Proveedor;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.management.Proveedor;
import com.management.Archivos.ArchivoProveedor;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioPedirIDProveedor extends JFrame implements ActionListener{
    JTextField id;
    JLabel texto;

    public FormularioPedirIDProveedor(){
        setLayout(new FlowLayout());
        texto = new JLabel("Ingrese el id");
        id = new JTextField(20);
        id.addActionListener(this);
        add(texto);
        add(id);


        this.setSize(250,200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String idField = id.getText();
        if(idField.equals("")){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");
        }else{
            Proveedor proveedor = ArchivoProveedor.getProveedor(idField);
            new FormularioModificarProveedor(proveedor);
            setVisible(false);
        }
    }


}
