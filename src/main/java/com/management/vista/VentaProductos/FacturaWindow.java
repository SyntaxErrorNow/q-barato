package com.management.vista.VentaProductos;

import javax.swing.*;
import com.management.controlador.QRCodeController;
import com.management.modelo.schema.Producto;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacturaWindow extends JFrame {

    private ProductoListPanel productoListPanel;
    private JLabel totalPriceLabel;
    private QRCodeController qrCodeController;

    public FacturaWindow() {
        qrCodeController = new QRCodeController();
        setTitle("Factura de los productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);


        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());


        // Panel de datos del cliente
        JPanel customerInfoPanel = new JPanel();
        customerInfoPanel.setLayout(new GridLayout(2, 1));
        customerInfoPanel.add(new JLabel("Nombre: Gorinez"));
        customerInfoPanel.add(new JLabel("CI: 13415"));
        mainPanel.add(customerInfoPanel, BorderLayout.NORTH);


        // Panel de lista de productos
        productoListPanel = new ProductoListPanel();
        productoListPanel.setLayout(new BoxLayout(productoListPanel, BoxLayout.Y_AXIS));
        mainPanel.add(productoListPanel);


        // Panel de precio total
        JPanel totalPricePanel = new JPanel();
        totalPricePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        totalPriceLabel = new JLabel("Total: " + productoListPanel.getPrecioTotal() + "bs");
        totalPricePanel.add(totalPriceLabel);
        mainPanel.add(totalPricePanel, BorderLayout.SOUTH);


        // Botón de añadir producto
        JButton addProductButton = new JButton("Añadir Producto");
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nu.pattern.OpenCV.loadLocally();
                Producto producto = qrCodeController.readerQrCode();
                if(producto != null){
                    productoListPanel.addProduct(producto);
                    totalPriceLabel.setText("Total: " + productoListPanel.getPrecioTotal() + " bs");
                }
            }
        });

        mainPanel.add(addProductButton, BorderLayout.EAST);

        add(mainPanel);
        setVisible(true);
    }


}