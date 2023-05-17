package com.management.vista.VentaProductos;


import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.bson.types.ObjectId;

import com.management.modelo.schema.Producto;

public class ProductoListPanel extends JPanel {

    private double precioTotal;
    private JPanel productosPanels;
    private JScrollPane scrollPane;

    public ProductoListPanel() {
        precioTotal = 0.0;

        productosPanels = new JPanel();
        productosPanels.setLayout(new BoxLayout(productosPanels, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(productosPanels);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    public void addProduct(Producto producto) {

        boolean productoExistente = compararProductoId(producto.getId(), producto.getPrecio());

        if(!productoExistente){
            productosPanels.add(new ProductoPanel(producto));
            revalidate();
            repaint();
            precioTotal += producto.getPrecio();
        }


    }

    public void removeAllProductPanels() {
        productosPanels.removeAll();
        revalidate();
        repaint();
        precioTotal = 0.0;
    }

    public boolean compararProductoId(ObjectId id, double precioProducto) {
        Component[] components = productosPanels.getComponents();

        for (Component component : components) {
            if (component instanceof ProductoPanel) {
                ProductoPanel productoPanel = (ProductoPanel) component;
                if (productoPanel.getId() != null && productoPanel.getId().equals(id)) {
                    System.out.println(productoPanel.getCantidad());
                    productoPanel.aumentarCantidad();
                    precioTotal += precioProducto;
                    return true;
                }
            }
        }

        return false;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
}
