package com.management;

public class Producto{
    private String id;
    private String nombre;
    private String descripcion;
    private String marca;
    private String categoria;
    private String subCategoria;
    private Double precio;
    private String proveedor;
    private int cantidadAdquirida;
    private int cantidadVendida;
    private int cantidadDisponible;
    private String fechaCompra;
    private String fechaCaducidad;

    public Producto(String nombre, String descripcion, String marca, String categoria, String subCategoria, Double precio, String proveedor, int cantidadAdquirida, String fechaCompra, String fechaCaducidad){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.categoria = validarCategoria(categoria);
        this.subCategoria = subCategoria;
        this.precio = precio;
        this.proveedor = proveedor;
        this.cantidadAdquirida = cantidadAdquirida;
        this.cantidadVendida = 0;
        this.cantidadDisponible = cantidadAdquirida;
        this.fechaCompra = fechaCompra;
        this.fechaCaducidad = fechaCaducidad;
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
    public String getProveedor() {
        return proveedor;
    }
    public void setProveedor(String proveedor) {
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
    public String getFechaCompra() {
        return fechaCompra;
    }
    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }
    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getNumCategoria(){
        if(categoria.equals("despensa")){
            return 1;
        }
        if(categoria.equals("comestibles")){
            return 2;
        }
        if(categoria.equals("bebidas")){
            return 3;
        }
        if(categoria.equals("aseo")){
            return 4;
        }
        if(categoria.equals("cuidado personal")){
            return 5;
        }else{
            return 6;
        }
    }

    public String validarCategoria(String categoriaIngresada){
        String cat = categoriaIngresada.toLowerCase();
        if(cat.equals("despensa")||cat.equals("comestibles")||cat.equals("bebidas")||
           cat.equals("aseo")||cat.equals("cuidado personal")){
            return cat;
        }else{
            return "otros";
        }
    }

    @Override
    public String toString(){
        return "\nNombre: " + nombre + "\nId: " + id + "\nDescripcion: " + descripcion + "\nMarca: " + marca + 
               "\nCategoria " + categoria + "\nSubCategoria: " + subCategoria + "\nPrecio unitario: " + precio +
               "\nProveedor: " + proveedor + "\nCantidad adquirida: " + cantidadAdquirida + "\nCantidad vendida: " + cantidadVendida +
               "\nCantidad disponible: " + cantidadDisponible + "\nFecha de compra: " + fechaCompra + "\nFecha de caducidad: " + fechaCaducidad;
    }
}
