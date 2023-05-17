package com.management.modelo.service;

import java.util.ArrayList;
import java.util.List;


import org.bson.types.ObjectId;

import com.management.modelo.database.MongoDBConnection;
import com.management.modelo.repositories.InventarioRepository;
import com.management.modelo.schema.Inventario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.IndexOptions;
import static com.mongodb.client.model.Filters.*;
import org.bson.Document;
import org.bson.conversions.Bson;


public class InventarioService implements InventarioRepository{
    private final MongoCollection<Inventario> inventarioCollection;

    public InventarioService(){
        inventarioCollection = MongoDBConnection.getDatabase().getCollection("inventarios", Inventario.class);
        IndexOptions indexOptions = new IndexOptions().unique(true);
        inventarioCollection.createIndex(new Document("fecha.month", 1), indexOptions);
    }

    @Override
    public Inventario getInventarioById(ObjectId id) {
        try {
            return inventarioCollection.find(new Document("_id", id)).first();

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el Inventario");
        }
    }

    @Override
    public List<Inventario> getAllInventarios() {
        try {
            return inventarioCollection.find().into(new ArrayList<>());

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todos los Inventario", e);
        }
    }

    @Override
    public Inventario createInventario(Inventario inventario) {
        try {
            inventarioCollection.insertOne(inventario);
            return inventario;

        } catch (Exception e) {
            throw new RuntimeException("Error al crear el inventario (capa servicio)", e);
        }
    }

    @Override
    public Inventario updateInventario(ObjectId id, Inventario inventario) {
        try {
            inventarioCollection.replaceOne(new Document("_id", id),inventario);
            return inventario;

        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el Inventario");
        }
    }

    @Override
    public void deleteInventarioById(ObjectId id) {
        try {
            inventarioCollection.deleteOne(new Document("_id", id));

        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el Inventario");

        }
    }

    @Override
    public Inventario getInventarioByMes(int anio, int periodo) {
        try {
            Bson filter = and(
                    eq("fecha.year", anio),
                    eq("fecha.monthValue", periodo)
            );

            return inventarioCollection.find(filter).first();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el inventario por mes y año", e);
        }
    }

}
