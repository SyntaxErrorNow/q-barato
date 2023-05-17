package com.management.vista.Formularios.Producto;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.management.Producto;
import com.management.Archivos.ArchivoProducto;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
public class FormularioElegirProductoReabastecer extends JFrame implements ActionListener{
    JLabel description;
    JButton abastecer;

    public FormularioElegirProductoReabastecer(String categoriaField) {
        this.setLayout(new FlowLayout());
        ArrayList<Producto> listaProductos = ArchivoProducto.getProductoPorCategoria(categoriaField);

        for(Producto producto : listaProductos) {
            final Producto product = producto;
            String nombreProducto = producto.getNombre();
            int cantidadProducto = producto.getCantidadAdquirida();

            description = new JLabel("Producto: "+nombreProducto+" Unidades: "+cantidadProducto);
            abastecer = new JButton("comprar");
            abastecer.setBounds(50,50+(40*50),100,40);

            abastecer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    new FormularioReabastecerProducto(product);
                }
            });

            add(description);
            add(abastecer);
        }


        setSize(1000,1000);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
