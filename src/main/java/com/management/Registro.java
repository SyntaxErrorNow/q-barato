package com.management;

public abstract class Registro {
    protected Producto producto;
    protected int cantidad;
    protected Fecha fecha;
    public Registro(Producto producto, int cantidad, Fecha fecha){
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
    public Producto getProducto(){
        return producto;
    }
    public int getCantidad(){
        return cantidad;
    }
    public Fecha getFecha(){
        return fecha;
    }
}
