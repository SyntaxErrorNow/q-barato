package com.management;

public class Registro {
    private Producto producto;
    private int cantidad;
    private Fecha fecha;
    private double ganancia;
    private String tipo;
    private String motivo;
    public Registro(Producto producto, int cantidad, Fecha fecha, double ganancia, String tipo, String motivo){
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.ganancia = ganancia;
        this.tipo = tipo;
        this.motivo = motivo;

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
    public double getGanancia(){
        return ganancia;
    }
    public String getTipo(){
        return tipo;
    }
    public String getMotivo(){
        return motivo;
    }
    public String toString(){
        return "\n Producto: "+producto.getNombre()+"\n Cantidad: "+cantidad+"\n Fecha: "+fecha.toString();
    }
}
