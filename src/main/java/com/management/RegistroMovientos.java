package com.management;

public class RegistroMovientos extends Registro {
    private double ganancia;
    private String motivo;
    public RegistroMovientos(Producto producto, int cantidad, Fecha fecha, String motivo, double ganancia){
        super(producto, cantidad, fecha);
        this.ganancia = ganancia;
        this.motivo =  motivo;
    }
    public double getGanancia(){
        return ganancia;
    }
    public String getMotivo(){
        return motivo;
    }

    @Override
    public String toString(){
        return "\nNombre: " + producto.getNombre() + "\nId: " + producto.getId() + "\nPrecio unitario: " + producto.getPrecio() + "\nCantidad vendida: " + cantidad + 
               "\nCantidad disponible: " + producto.getCantidadDisponible()+ "\nFecha del movimiento: " + fecha.toString() + "\nGanancia: " + ganancia+
               "\nMotivo: " + motivo;
    }

}
