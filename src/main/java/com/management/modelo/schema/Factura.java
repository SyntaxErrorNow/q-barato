package com.management.modelo.schema;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import java.time.LocalDate;


public class Factura {

    @BsonProperty("_id")
    private ObjectId id;

    @BsonProperty("nombre")
    private String nombre;

    @BsonProperty("productos")
    private List<Producto> productos;

    @BsonProperty("ci")
    private int ci;

    @BsonProperty("cantidad")
    private int cantidad;


    @BsonProperty("fecha")
    private LocalDate fecha;


    @BsonProperty("total")
    private Double total;

    @BsonProperty("tipoPago")
    private String tipoPago;

    @BsonProperty("ganancia")
    private Double ganancia;

    public Factura(String nombre,List<Producto> producto,int cantidad, int ci,Double total, String tipoPago, Double ganancia){
        this.nombre=nombre;
        this.productos = producto;
        this.cantidad = cantidad;
        this.ci = ci;
        this.fecha = LocalDate.now();
        this.total = total;
        this.tipoPago = tipoPago;
        this.ganancia = ganancia;


    }

    public Factura(){}

    public ObjectId getId(){
        return id;
    }
    public String getNombre(){
    return nombre;
    }
    public List<Producto> getProductos(){
        return productos;
    }
    public int getCantidad(){
        return cantidad;
    }

    public int getCi(){
        return ci;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getTotal(){
        return total;
    }

    public String getTipoPago(){
        return tipoPago;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setProductos(List<Producto> productos){
        this.productos= productos;
    }
    public void  setCantidad(int cantidad){
       this.cantidad=cantidad;
    }

    public void setCi(int ci){
        this.ci=ci;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public void setTotal(Double total){
        this.total = total;
    }
    public void setTipoPago(String tipoPago){
        this.tipoPago = tipoPago;
    }

    public String toString(){
        return "\n Nombre: "+nombre+"\n Ci: "+ci+"\n Fecha: "+fecha+"\n Producto: "+((Factura) productos).getProductos()+"\n Total: "+total+"\n Tipo de pago: "+tipoPago;
    }

}