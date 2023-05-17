package com.management.modelo.service;

import org.bson.types.ObjectId;
import com.management.modelo.database.MongoDBConnection;
import com.management.modelo.repositories.ProviderRepository;
import com.management.modelo.schema.Proveedor;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class ProviderService implements ProviderRepository{
    private final MongoCollection<Proveedor> providerCollection;

    public ProviderService(){
        providerCollection = MongoDBConnection.getDatabase().getCollection("Proveedores",Proveedor.class);

    }

    @Override
    public Proveedor getProviderById(ObjectId id) {
        try {
            return providerCollection.find(new Document("_id", id)).first();

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el Proveedor");
        }
    }

    @Override
    public Proveedor createProvider(Proveedor provider) {
        try {
            providerCollection.insertOne(provider);
            return provider;

        } catch (Exception e) {
            throw new RuntimeException("Error al crear el Proveedor", e);
        }
    }

    @Override
    public Proveedor updateProviderById(ObjectId id, Proveedor provider) {

        try {
            providerCollection.replaceOne(new Document("_id", id), provider);
            return provider;

        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el Proveedor");
        }
    }

    @Override
    public void deleteProviderById(ObjectId id) {
        try {
            providerCollection.deleteOne(new Document("_id", id));

        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el Proveedor");

        }
    }
}
