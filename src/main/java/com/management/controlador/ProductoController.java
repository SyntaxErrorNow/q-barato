package com.management.controlador;

import java.util.List;

import javax.swing.JOptionPane;

import org.bson.types.ObjectId;

import com.management.modelo.schema.Producto;
import com.management.modelo.service.ProductoService;

public class ProductoController {
    private ProductoService productoService;

    public ProductoController(){
        productoService = new ProductoService();
    }

    public List<Producto> obtenerAllProductos(){
        try {
            return productoService.getAllProductos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener a todos los productos");
            throw new RuntimeException("Error al obtener todos los productos", e);
        }
    }

    public Producto obtenerOneProductoById(ObjectId id){
        try {
            return productoService.getProductoById(id);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener un producto");
            throw new RuntimeException("Error al obtener un producto");
        }
    }

    public void registrarProducto(Producto producto){
        try {
            productoService.createProducto(producto);
            JOptionPane.showMessageDialog(null, "El producto se regisstró exitosamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "EL producto con nombre: " + producto.getNombre() + " ya existe");
        }
    }

    public void eliminarProductoById(ObjectId id){
        try {
            productoService.deleteProductoById(id);
            JOptionPane.showMessageDialog(null, "El producto se eliminó exitosamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto");
        }
    }


    public void actualizarProductoById(Producto producto){
        try {
            productoService.updateProducto(producto.getId(), producto);
            JOptionPane.showMessageDialog(null, "El producto se actualizó exitosamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el producto");
        }
    }

    public List<Producto> obtenerProductosByNombre(String nombre){
        try {
            return productoService.getProductoByNombre(nombre);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el producto por nombre");
            throw new RuntimeException("Error al obtener el producto por nombre");
        }
    }

    public List<Producto> obtenerProductosByCategoria(String categoria){
        try {
            return productoService.getProductosByCategoria(categoria);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el producto por categoria");
            throw new RuntimeException("Error al obtener el producto por categoria");
        }
    }

    public List<Producto> obtenerProductosBySubCategoria(String subCategoria){
        try {
            return productoService.getProductosBySubCategoria(subCategoria);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el producto por subCategoria");
            throw new RuntimeException("Error al obtener el producto por subCategoria");
        }
    }

    public void reabastecerProductosByLote(int cantidad, int porcentaje){
        try {
            productoService.reabastecerProductosByLote(cantidad, porcentaje);
            JOptionPane.showMessageDialog(null, "Los productos se reabastecieron exitosamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al reabastecer los productos por lotes");
            throw new RuntimeException("Error al reabastecer los productos por lotes", e);
        }
    }
}
