package com.management.modelo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;

import com.management.modelo.database.MongoDBConnection;
import com.management.modelo.repositories.ProductoRepository;
import com.management.modelo.schema.Producto;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Updates;

import org.bson.Document;
import org.bson.conversions.Bson;


public class ProductoService implements ProductoRepository{
    private final MongoCollection<Producto> productoCollection;

    public ProductoService(){
        productoCollection = MongoDBConnection.getDatabase().getCollection("products", Producto.class);
        IndexOptions indexOptions = new IndexOptions().unique(true);
        productoCollection.createIndex(new Document("nombre", 1), indexOptions);
    }

    @Override
    public Producto getProductoById(ObjectId id) {
        try {
            return productoCollection.find(new Document("_id", id)).first();

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el Producto");
        }
    }

    @Override
    public List<Producto> getAllProductos() {
        try {
            return productoCollection.find().into(new ArrayList<>());

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todos los Productos", e);
        }
    }

    @Override
    public Producto createProducto(Producto producto) {
        try {
            productoCollection.insertOne(producto);
            return producto;

        } catch (Exception e) {
            throw new RuntimeException("Error al crear el Producto", e);
        }
    }

    @Override
    public Producto updateProducto(ObjectId id, Producto producto) {
        try {
            productoCollection.replaceOne(new Document("_id", id), producto);
            return producto;

        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el Producto");
        }
    }

    @Override
    public void deleteProductoById(ObjectId id) {
        try {
            productoCollection.deleteOne(new Document("_id", id));

        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el Producto");

        }
    }

    @Override
    public List<Producto> getProductoByNombre(String nombre) {
        try {
            return productoCollection.find(new Document("nombre", nombre)).into(new ArrayList<>());

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los productos por nombre");
        }
    }

    @Override
    public List<Producto> getProductosByCategoria(String categoria) {
        try {
            return productoCollection.find(new Document("categoria", categoria)).into(new ArrayList<>());

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los productos por categoria");
        }
    }

    @Override
    public List<Producto> getProductosBySubCategoria(String subCategoria) {
        try {
            return productoCollection.find(new Document("subCategoria", subCategoria)).into(new ArrayList<>());

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los productos por subCategoria");
        }
    }

    @Override
    public void reabastecerProductosByLote(int cantidad, int porcentaje) {
        try {


            Bson filter = Filters.expr(
                new Document("$lte",
                 Arrays.asList("$cantidadDisponible", new Document("$multiply", Arrays.asList("$cantidadAdquirida", (double) porcentaje/100 )))
                )
            );

            Bson update = Updates.inc("cantidadDisponible", cantidad);
            productoCollection.updateMany(filter, update);


        } catch (Exception e) {
            throw new RuntimeException("Error al reabastecer productos por lote", e);
        }

    }


}
