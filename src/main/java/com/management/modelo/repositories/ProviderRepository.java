package com.management.modelo.repositories;
import org.bson.types.ObjectId;
import com.management.modelo.schema.Proveedor;


public interface ProviderRepository {
    Proveedor getProviderById(ObjectId id);
    Proveedor createProvider(Proveedor provider);
    Proveedor updateProviderById(ObjectId id, Proveedor provider);
    void deleteProviderById(ObjectId id);
}
