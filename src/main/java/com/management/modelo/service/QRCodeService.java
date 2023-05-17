package com.management.modelo.service;

import java.io.FileOutputStream;
import java.util.List;

import org.bson.types.ObjectId;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.QRCodeDetector;
import org.opencv.videoio.VideoCapture;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.management.modelo.repositories.QRCodeRepository;
import com.management.modelo.schema.Producto;

public class QRCodeService implements QRCodeRepository{

    private ProductoService productoService;

    public QRCodeService(){
        productoService = new ProductoService();
    }


    @Override
    public void generateQrCode(List<Producto> productos) {
        try {

            int anchoCodigoQR = 212; // (1 cm = 28.35 puntos)
            int altoCodigoQR = 212; // (1 cm = 28.35 puntos)
            int cantidadColumnas = 2;
            float posicionXInicial = 100;
            float posicionYInicial = 500;

            Document documento = new Document();
            PdfWriter creaerPdfArchivo = PdfWriter.getInstance(documento, new FileOutputStream("etiquetas/qr.pdf"));
            documento.open();
            PdfContentByte contenidoPDF = creaerPdfArchivo.getDirectContent();


            int contador = 0;
            for (Producto producto : productos) {
                String contenido = producto.getId() + "," + producto.getNombre();
                BarcodeQRCode codigoQR = new BarcodeQRCode(contenido, anchoCodigoQR, altoCodigoQR, null);
                PdfTemplate plantilla = contenidoPDF.createTemplate(anchoCodigoQR, altoCodigoQR);
                PdfContentByte contenidoPlantilla = plantilla;
                codigoQR.placeBarcode(contenidoPlantilla, BaseColor.BLACK, 1f);

                int fila = contador / cantidadColumnas;
                int columna = contador % cantidadColumnas;
                float posicionX = posicionXInicial + columna * anchoCodigoQR;
                float posicionY = posicionYInicial - fila * altoCodigoQR;

                contenidoPDF.addTemplate(plantilla, posicionX, posicionY);
                contador++;
            }

            documento.close();
        } catch (Exception e) {
            throw new RuntimeException("Error al generar codigo qr");
        }
    }

    @Override
    public Producto readQrCode() {
        QRCodeDetector detector = new QRCodeDetector();
        try {

            VideoCapture camera = new VideoCapture(0);
            Mat imagen = new Mat();
            String  productoValues = "";

            if (!camera.isOpened()) {
                System.err.println("No se puede abrir la cámara.");
                return null;
            }

            while (true) {
                if (camera.read(imagen)) {
                    Mat grayFrame = new Mat();
                    Imgproc.cvtColor(imagen, grayFrame, Imgproc.COLOR_BGR2GRAY);
                    productoValues = detector.detectAndDecode(grayFrame);
                    
                    if (!productoValues.equals("")) {
                        String [] contenido = productoValues.split(",");
                        System.out.println(productoValues);
                        camera.release();
                        return productoService.getProductoById(new ObjectId(contenido[0]));
                    }
                } else {
                    System.err.println("No se pudo capturar un fotograma de la cámara.");
                    break;
                }
            }

            return null;

        } catch (Exception e) {
            throw new RuntimeException("Error al leer el codigo qr");
        }
    }

}
