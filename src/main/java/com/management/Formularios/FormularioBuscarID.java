package com.management.Formularios;
import javax.swing.*;
import com.management.Archivo;
import com.management.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
public class FormularioBuscarID extends JFrame implements ActionListener {
    JTextField ID;
    JLabel texto;

    public FormularioBuscarID(){
        setLayout(new FlowLayout());
        texto = new JLabel("ID del producto");
        ID = new JTextField(20);
        ID.addActionListener(this);
        add(texto);
        add(ID);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String IDField = ID.getText();
        if(IDField.equals("")){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");
        }else{
            Producto producto = Archivo.getProducto(IDField);
            System.out.println(producto);
            setVisible(false);
        }
    }

}
