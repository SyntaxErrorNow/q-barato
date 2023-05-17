package com.management.controlador;

import java.util.List;
import javax.swing.JOptionPane;
import com.management.modelo.schema.Producto;
import com.management.modelo.service.QRCodeService;

public class QRCodeController {

    private QRCodeService qrCodeService;

    public QRCodeController(){
        qrCodeService = new QRCodeService();
    }

    public void generateQrCode(List<Producto> productos){
        try {
            if(productos.isEmpty()){
                JOptionPane.showMessageDialog(null, "Lista vacia, no se puede generar qr");
                return;
            }
            qrCodeService.generateQrCode(productos);
            JOptionPane.showMessageDialog(null, "Se generó los qr de los productos exitosamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar el codigo qr de los productos");
            throw new RuntimeException("Error al generar el codigo qr de los productos", e);
        }
    }

    public Producto readerQrCode(){
        try {
            return qrCodeService.readQrCode();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer el codigo qr del producto");
            throw new RuntimeException("Error al leer el codigo qr del producto", e);
        }
    }

}
