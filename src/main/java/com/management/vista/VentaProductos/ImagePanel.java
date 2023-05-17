package com.management.vista.VentaProductos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class ImagePanel extends JPanel {
    private BufferedImage image;

    public ImagePanel(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            int width = image.getWidth();
            int height = image.getHeight();

            // Calcula el factor de escala para ajustar la imagen al tamaño deseado
            double scaleX = 250.0 / width;
            double scaleY = 250.0 / height;
            double scale = Math.min(scaleX, scaleY);

            int newWidth = (int) (width * scale);
            int newHeight = (int) (height * scale);

            int x = (getWidth() - newWidth) / 2;
            int y = (getHeight() - newHeight) / 2;
            g.drawImage(image, x, y, newWidth, newHeight, this);
        }
    }
}
