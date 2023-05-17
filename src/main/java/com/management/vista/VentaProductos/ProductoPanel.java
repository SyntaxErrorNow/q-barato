package com.management.vista.VentaProductos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.management.modelo.schema.Producto;
import javax.swing.border.Border;

import org.bson.types.ObjectId;


public class ProductoPanel extends JPanel {

    private int cantidad;
    private ObjectId id;
    private JLabel cantidadLabel;

    public ProductoPanel(Producto producto) {
        cantidad = 1;
        id = producto.getId();

         // Crear el panel para mostrar el producto

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 150));
        setMaximumSize(new Dimension(400, 150));

        Border innerBorder = BorderFactory.createLineBorder(Color.BLACK);
        Border outerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border compoundBorder = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
        setBorder(compoundBorder);


        ImagePanel imagePanel = new ImagePanel("imagenes/postre.jpeg");
        imagePanel.setPreferredSize(new Dimension(200, 150));
        imagePanel.setMaximumSize(new Dimension(200, 150));
        add(imagePanel, BorderLayout.WEST);


        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.add(new JLabel("Nombre: " + producto.getNombre()), BorderLayout.NORTH);

        JTextArea descriptionTextArea = new JTextArea("Descripcion: " + producto.getDescripcion());
        descriptionTextArea.setLineWrap(true); // Habilitar el ajuste de línea automático
        descriptionTextArea.setWrapStyleWord(true); // Asegurar el ajuste de palabras completas
        descriptionTextArea.setEditable(false); // Hacer el JTextArea no editable
        infoPanel.add(new JScrollPane(descriptionTextArea), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.add(new JLabel("Precio: $" + producto.getPrecio()));

        cantidadLabel = new JLabel("Cantidad: " + cantidad);
        bottomPanel.add(cantidadLabel);
        infoPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(infoPanel, BorderLayout.CENTER);
    }

    public int getCantidad(){
        return cantidad;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public ObjectId getId(){
        return id;
    }

    public void aumentarCantidad(){
        cantidad = cantidad + 1;
        cantidadLabel.setText("Cantidad: " + cantidad);
    }


    @Override
    public String toString(){
        return "id: " + id + "\ncantidad: " + cantidad;
    }
}