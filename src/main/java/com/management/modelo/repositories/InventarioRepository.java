package com.management.modelo.repositories;

import java.util.List;

import org.bson.types.ObjectId;

import com.management.modelo.schema.Inventario;

public interface InventarioRepository {

    Inventario getInventarioById(ObjectId id);
    List<Inventario> getAllInventarios();
    Inventario createInventario(Inventario inventario);
    Inventario updateInventario(ObjectId id, Inventario inventario);
    void deleteInventarioById(ObjectId id);
    Inventario getInventarioByMes(int anio, int periodo);
}

