package com.management.controlador;
import java.util.List;

import javax.swing.JOptionPane;

import org.bson.types.ObjectId;

import com.management.modelo.schema.Factura;
import com.management.modelo.service.FacturaService;
public class FacturaController {
    private FacturaService facturaService;

    public FacturaController(){
        facturaService = new FacturaService();
    }

    public List<Factura> obtenerAllFacturas(){
        try {
            return facturaService.getAllFacturas();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener a todas las facturas");
            throw new RuntimeException("Error al obtener todas las facturas", e);
        }
    }

    public Factura obtenerOneFacturaById(ObjectId id){
        try {
            return facturaService.getFacturaById(id);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener una factura");
            throw new RuntimeException("Error al obtener una factura");
        }
    }

    public void registrarFactura(Factura factura){
        try {
            facturaService.createFactura(factura);
            JOptionPane.showMessageDialog(null, "La factura se registró exitosamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la factura");
        }
    }


}
