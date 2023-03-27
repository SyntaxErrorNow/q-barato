package com.management;

public class RegistroAbastecimientos extends Registro{
    private Proveedor proveedor;
    public RegistroAbastecimientos(Producto producto, int cantidad, Fecha fecha, Proveedor proveedor){
        super(producto, cantidad, fecha);
        this.proveedor = proveedor;
    }
    public Proveedor getProveedor(){
        return proveedor;
    }

    @Override
    public String toString(){
        return "\nNombre: " + producto.getNombre() + "\nId: " + producto.getId() + "\nPrecio unitario: " + producto.getPrecio() + "\nCantidad vendida: " + cantidad + 
               "\nFecha del movimiento: " + fecha.toString() + "\nProveedor: " + proveedor;
    }
    
}
