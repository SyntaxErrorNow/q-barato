package com.management.modelo.schema;

import java.time.LocalDate;
import java.util.ArrayList;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Inventario {

    @BsonProperty("_id")
    private ObjectId id;

    @BsonProperty("registros")
    private ArrayList<Factura> registros;

    @BsonProperty("productosRegistrados")
    private ArrayList<Producto> productosRegistrados;

    @BsonProperty("fecha")
    private LocalDate fecha;


    public Inventario(){
        fecha = LocalDate.now();
        registros = new ArrayList<>();
        productosRegistrados = new ArrayList<>();
    }
    public ObjectId getId (){
        return id;
    }
    public void setId(ObjectId id){
        this.id = id;
    }
    public ArrayList<Factura> getRegistros(){
        return registros;
    }

    public ArrayList<Producto> getProductosRegistrados(){
        return productosRegistrados;
    }

    public void setProductosRegistrados(ArrayList<Producto> productosRegistrados){
        this.productosRegistrados = productosRegistrados;
    }

    public LocalDate getFecha(){
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}
