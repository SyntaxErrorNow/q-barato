package com.management;

import com.management.utils.UtilsCategoria;

public class Producto{
    private String id;
    private String nombre;
    private String descripcion;
    private String marca;
    private String categoria;
    private String subCategoria;
    private Double precio;
    private Proveedor proveedor;
    private int cantidadAdquirida;
    private int cantidadVendida;
    private int cantidadDisponible;
    private Fecha fechaCompra;
    private Fecha fechaCaducidad;
    private boolean disponibilidad;

    public Producto(String nombre, String descripcion, String marca,
                    String categoria, String subCategoria, Double precio,
                    Proveedor proveedor, int cantidadAdquirida,
                    int diaCompra, int mesCompra, int anioCompra,
                    int diaCaducidad, int mesCaducidad, int anioCaducidad)
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.categoria = UtilsCategoria.validarCategoria(categoria);
        this.subCategoria = subCategoria;
        this.precio = precio;
        this.proveedor = proveedor;
        this.cantidadAdquirida = cantidadAdquirida;
        this.cantidadVendida = 0;
        this.cantidadDisponible = cantidadAdquirida;
        this.fechaCompra = new Fecha(diaCompra,mesCompra,anioCompra);
        this.fechaCaducidad = new Fecha(diaCaducidad, mesCaducidad, anioCaducidad);
        this.disponibilidad = (cantidadDisponible > 0) ? true : false;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getSubCategoria() {
        return subCategoria;
    }
    public void setSubCategoria(String subCategoria) {
        this.subCategoria = subCategoria;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Proveedor getProveedor() {
        return proveedor;
    }
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    public int getCantidadAdquirida() {
        return cantidadAdquirida;
    }
    public void setCantidadAdquirida(int cantidadAdquirida) {
        this.cantidadAdquirida = cantidadAdquirida;
    }
    public int getCantidadVendida() {
        return cantidadVendida;
    }
    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    public Fecha getFechaCompra() {
        return fechaCompra;
    }
    public void setFechaCompra(int diaCompra, int mesCompra, int anioCompra) {
        this.fechaCompra = new Fecha(diaCompra, mesCompra, anioCompra);
    }
    public Fecha getFechaCaducidad() {
        return fechaCaducidad;
    }
    public void setFechaCaducidad(int diaCaducidad, int mesCaducidad, int anioCaducidad) {
        this.fechaCaducidad = new Fecha(diaCaducidad, mesCaducidad, anioCaducidad);
    }
    public boolean getDisponibilidad(){
        return disponibilidad;
    }
    public void setDisponibilidad(){
        disponibilidad = (cantidadDisponible > 0 ) ? true : false;
    }

    public void venderProducto(int cantidad){
        this.cantidadDisponible -= cantidad;

    }
    public void abastecerProducto(int cantidad){
        this.cantidadAdquirida += cantidad;
        this.cantidadDisponible += cantidad;
    }

    @Override
    public String toString(){
        return "\nNombre: " + nombre + "\nId: " + id + "\nDescripcion: " + descripcion + "\nMarca: " + marca +
               "\nCategoria " + categoria + "\nSubCategoria: " + subCategoria + "\nPrecio unitario: " + precio +
               "\nProveedor: " + proveedor + "\nCantidad adquirida: " + cantidadAdquirida + "\nCantidad vendida: " + cantidadVendida +
               "\nCantidad disponible: " + cantidadDisponible + "\nFecha de compra: " + fechaCompra + "\nFecha de caducidad: " + fechaCaducidad  + "\nDisponible: "+ disponibilidad;
    }
}
