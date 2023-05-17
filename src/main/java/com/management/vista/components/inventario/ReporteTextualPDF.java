package com.management.vista.components.inventario;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.management.Inventario;
import com.management.Archivos.ArchivoInventario;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map.Entry;
public class ReporteTextualPDF {
    private Inventario inventario;
    public ReporteTextualPDF(String id){
        Document document = new Document();
        this.inventario = ArchivoInventario.getInventario(id);
        try {
            PdfWriter.getInstance(document, new FileOutputStream("reportes/reporte.pdf"));
            document.open();
            Paragraph title = new Paragraph("Reporte de Desempeño del Negocio - " + inventario.getPeriodo() + " - " + inventario.getAnio(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20));
            title.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(title);
            Paragraph subtitle = new Paragraph("Este es un informe de desempeño para todos los productos del negocio - " + inventario.getPeriodo() + " - " + inventario.getAnio(), FontFactory.getFont(FontFactory.HELVETICA, 15));
            subtitle.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(subtitle);
            Paragraph capitalInvertido = new Paragraph("Capital Invertido: $" + inventario.getCapitalInvertido(), FontFactory.getFont(FontFactory.HELVETICA, 11));
            capitalInvertido.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(capitalInvertido);
            Paragraph gananciasTotales = new Paragraph("Ganancias Totales: $" + inventario.getGanancias(), FontFactory.getFont(FontFactory.HELVETICA, 11));
            gananciasTotales.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(gananciasTotales);
            Paragraph perdidasTotales = new Paragraph("Pérdidas Totales: $" + inventario.getPerdida(), FontFactory.getFont(FontFactory.HELVETICA, 11));
            perdidasTotales.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(perdidasTotales);
            Paragraph ventasRealizadas = new Paragraph("Total Ventas Realizada: " + inventario.getRegistros().size(), FontFactory.getFont(FontFactory.HELVETICA, 11));
            ventasRealizadas.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(ventasRealizadas);
            Paragraph productListTitle = new Paragraph("Lista de los 5 productos mas vendidos", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11));
            productListTitle.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(productListTitle);
            List<Entry<String, Integer>> productosVendidosMap = ArchivoInventario.getProductosMasVendidos(inventario.getRegistros());
            int contador = 0;
            for (Entry<String, Integer> entry : productosVendidosMap) {
                if(contador > 5){
                    break;
                }
                Paragraph productoItem = new Paragraph(entry.getKey() + " : " + entry.getValue(), FontFactory.getFont(FontFactory.HELVETICA, 11));
                productoItem.setAlignment(Paragraph.ALIGN_LEFT);
                document.add(productoItem);
                contador++;
            }
            document.close();
            PdfWriter.getInstance(document, null).close();
            System.out.println("El PDF se ha generado correctamente.");
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}