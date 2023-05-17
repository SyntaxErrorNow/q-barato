package com.management.modelo.service;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.management.modelo.database.MongoDBConnection;
import com.management.modelo.repositories.FacturaRepository;
import com.management.modelo.schema.Factura;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

public class FacturaService implements FacturaRepository{

    private final MongoCollection<Factura> facturaCollection;

    public FacturaService(){
        facturaCollection = MongoDBConnection.getDatabase().getCollection("facturas", Factura.class);
    }
    @Override
    public List<Factura> getAllFacturas() {
        try {
            return facturaCollection.find().into(new ArrayList<>());

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todas las facturas", e);
        }
    }

    @Override
    public Factura getFacturaById(ObjectId id) {
        try {
            return facturaCollection.find(new Document("_id", id)).first();

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la factura");
        }
    }

    @Override
    public Factura createFactura(Factura factura) {
        try {
            facturaCollection.insertOne(factura);
            return factura;
        } catch (Exception e) {
            throw new RuntimeException("Error al crear la factura", e);
        }
    }

}





