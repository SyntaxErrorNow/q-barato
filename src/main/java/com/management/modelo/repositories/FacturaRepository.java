package com.management.modelo.repositories;

import java.util.List;

import org.bson.types.ObjectId;

import com.management.modelo.schema.Factura;

public interface FacturaRepository {
    
    Factura getFacturaById(ObjectId id);
    List<Factura> getAllFacturas();
    Factura createFactura(Factura factura);

}
