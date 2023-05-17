package com.management.vista.Formularios.Producto;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.management.modelo.data.DataProducto;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
public class FormularioElegirCategoriaReabastecer extends JFrame implements ActionListener, ItemListener{
    JButton aplicar;
    JLabel subcategoriaLabel,categoriaLabel;
    private JComboBox<String> categoria,subcategoria;
    String [] categorias = DataProducto.obtenerCategorias();
    String [] subCategorias = DataProducto.obtenerSubCategorias();
    String categoriaField,subcategoriaField;

    public FormularioElegirCategoriaReabastecer(){
        setLayout(new FlowLayout());

        categoria = new JComboBox<String>(categorias);
        categoriaLabel = new JLabel("Categoria");
        categoria.addItemListener(this);


        subcategoria = new JComboBox<String>(subCategorias);
        subcategoriaLabel = new JLabel("Subcategoria");
        subcategoria.addItemListener(this);


        aplicar = new JButton("Aplicar");
        aplicar.addActionListener(this);


        add(categoriaLabel);
        add(categoria);
        add(subcategoriaLabel);
        add(subcategoria);
        add(aplicar);

        this.setSize(700,250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
        setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        categoriaField = (String)categoria.getItemAt(categoria.getSelectedIndex());
        subcategoriaField = (String)subcategoria.getItemAt(subcategoria.getSelectedIndex());
        if (e.getSource() == categoria) {
            String seleccionado = (String)categoria.getItemAt(categoria.getSelectedIndex());
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(DataProducto.opcionesSubCategoria(seleccionado));
            subcategoria.setModel(model);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(categoriaField.equals("") || subcategoriaField.equals("")){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");

        }else{
            new FormularioElegirProductoReabastecer(categoriaField);
            setVisible(false);
        }
    }


}
