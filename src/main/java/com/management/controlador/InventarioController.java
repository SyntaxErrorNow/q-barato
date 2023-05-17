
package com.management.controlador;

import java.util.List;

import javax.swing.JOptionPane;

import org.bson.types.ObjectId;

import com.management.modelo.schema.Inventario;
import com.management.modelo.service.InventarioService;

public class InventarioController {
    private InventarioService inventarioService;

    public InventarioController(){
        inventarioService = new InventarioService();
    }

    public List<Inventario> obtenerAllInventarios(){
        try {
            return inventarioService.getAllInventarios();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener a todos los inventarios");
            throw new RuntimeException("Error al obtener todos los inventarios", e);
        }
    }

    public Inventario obtenerOneInventarioById(ObjectId id){
        try {
            return inventarioService.getInventarioById(id);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener un inventario");
            throw new RuntimeException("Error al obtener un inventario");
        }
    }

    public void registrarInventario(Inventario inventario){
        try {
            inventarioService.createInventario(inventario);
            JOptionPane.showMessageDialog(null, "El inventario se registró exitosamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ya existe un inventario con periodo: " + inventario.getFecha().getMonthValue() + " ya existe");
        }
    }

    public void eliminarInventarioId(ObjectId id){
        try {
            inventarioService.deleteInventarioById(id);
            JOptionPane.showMessageDialog(null, "El inventario se eliminó exitosamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el inventario");
        }
    }


    public void actualizarInventarioById(Inventario inventario){
        try {
            inventarioService.updateInventario(inventario.getId(), inventario);
            JOptionPane.showMessageDialog(null, "El inventario se actualizó exitosamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el inventario");
        }
    }

    public Inventario obtenerInventarioByMes(int anio, int periodo){
        try {
            return inventarioService.getInventarioByMes(anio, periodo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el inventario por mes");
            throw new RuntimeException("Error al obtener un inventario por mes");
        }
    }

}
