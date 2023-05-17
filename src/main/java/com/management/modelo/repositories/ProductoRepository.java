package com.management.modelo.repositories;

import java.util.List;

import org.bson.types.ObjectId;

import com.management.modelo.schema.Producto;

public interface ProductoRepository {

    Producto getProductoById(ObjectId id);
    List<Producto> getAllProductos();
    Producto createProducto(Producto producto);
    Producto updateProducto(ObjectId id, Producto producto);
    void deleteProductoById(ObjectId id);
    List<Producto> getProductoByNombre(String nombre);
    List<Producto> getProductosByCategoria(String categoria);
    List<Producto> getProductosBySubCategoria(String subCategoria);
    void reabastecerProductosByLote(int cantidad, int porcentaje);
}




