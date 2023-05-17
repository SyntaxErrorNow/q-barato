package com.management.modelo.schema;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
public class Proveedor {
    @BsonProperty("_id")
    private ObjectId id;

    @BsonProperty("nombre")
    private String nombre;

    @BsonProperty("telefono")
    private String telefono;

    @BsonProperty("listaProductosProveedor")
    private List<String> listaProductosProveedor;

    public Proveedor(String nombre, String telefono, List<String> listaProductosProveedor){
        this.nombre = nombre;
        this.telefono = telefono;
        this.listaProductosProveedor = listaProductosProveedor;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public ObjectId getId(){
        return id;
    }
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public List<String> getProductosProveedor(){
        return listaProductosProveedor;
    }
    public void setProductosProveedor(List<String> productosProveedor){
        this.listaProductosProveedor = productosProveedor;
    }
    @Override
    public String toString(){
        return "\nId: " + id + "\nNombre de Proveedor: " + nombre+"\nTelefono: "+telefono + "\nProductos que provee: " + listaProductosProveedor;
    }
}
