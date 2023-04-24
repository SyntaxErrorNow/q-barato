package com.management;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.management.Archivos.ArchivoInventario;

public class Inventario {
      

    private ArrayList<Registro> registros;
    private ArrayList<Producto> productosRegistrados;
    private int periodo, anio;
    private String IDinventario;

    public Inventario(int periodo, int anio){
        this.periodo = periodo;
        this.anio = anio;
        this.registros = ArchivoInventario.recopilarRegistros(periodo, anio);
        this.productosRegistrados = ArchivoInventario.recopilarProductosDelMomento();
    }
    public String getIDInventario (){
        return IDinventario;
    }
    public void setIDInventario(String id){
        this.IDinventario = id;
    }
    public ArrayList<Registro> getRegistros(){
        return registros;
    }
    public ArrayList<Producto> getProductosAlMomento(){
        return productosRegistrados;
    }
    public int getPeriodo(){
        return periodo;
    }
    public int getAnio(){
        return anio;
    }
    public void imprimirRegistros(){
        for(Registro registro: registros){
            System.out.println(registro.toString()+"\n");
        }
    }

    public void imprimirCantidadesDisponibles(){
        for(Producto producto: productosRegistrados){
            System.out.println("Producto "+producto.getId()+" "+producto.getNombre()+" Unidades: "+producto.getCantidadDisponible()+"\n");
        }
    }

    public double getGanancias(){
        double ganancia = 0;
        for(int i = 0; i<registros.size(); i++){
            if(registros.get(i).getGanancia() > 0){
                ganancia += registros.get(i).getGanancia();
            }
        }
        return ganancia;
    }
    public double getPerdida(){
        double perdida = 0;
        for(int i = 0; i< registros.size(); i++){
            if(registros.get(i).getGanancia() < 0){
                perdida += (registros.get(i).getGanancia()) * -1;
            }
        }
        return perdida;
    }
    public int getCantidadVendida(){
        int cantidad = 0;
        for(int i = 0; i < registros.size(); i ++){
            if(registros.get(i).getGanancia() > 0){
                cantidad += registros.get(i).getCantidad();
            }
        }
        return cantidad;
    }

    public int getCantidadPerdida(){
        int cantidad = 0;
        for(int i = 0; i < registros.size(); i ++){
            if(registros.get(i).getGanancia()< 0){
                cantidad += registros.get(i).getCantidad();
            }
        }
        return cantidad;
    }
    public int getCantidadAdquirida(){
        int cantidad = 0;
        for(int i = 0; i<registros.size(); i++){
            if(registros.get(i).getGanancia() == 0){
                cantidad += registros.get(i).getCantidad();
            }
        }
        return cantidad;
    }
    public double getCapitalInvertido(){
        double capital = 0;
        for(int i = 0; i<registros.size(); i++){
            if(registros.get(i).getGanancia() == 0){
                capital = registros.get(i).getCantidad() * registros.get(i).getProducto().getPrecio();
            }
        }
        return capital;
    }

    public ArrayList<String> determinarProductosMasVendidos(int i){
        ArrayList<String> productosVendidos = new ArrayList<>();
        ArrayList<Double> cantidadVendida = new ArrayList<>();
        devolverProductosVendidos(productosVendidos, cantidadVendida);
        ArrayList<String> masVendidos = new ArrayList<>();
        for(int c = 0; c<i && c<productosVendidos.size(); c++){
            String p = devolverProductoMasVendido(productosVendidos, cantidadVendida);
            if(p!=null){
                masVendidos.add(p);
            }
        }
        return masVendidos;
    }

    private String devolverProductoMasVendido(ArrayList<String> productosVendidos, ArrayList<Double> cantidadVendida){
        System.out.println(productosVendidos.get(0));
        System.out.println(Collections.max(cantidadVendida)+ " "+ cantidadVendida.indexOf((double)Collections.max(cantidadVendida)));
        String masVendido = productosVendidos.get(cantidadVendida.indexOf((double)Collections.max(cantidadVendida)));
        if(masVendido!=null){
            productosVendidos.remove(masVendido);
            cantidadVendida.remove(cantidadVendida.indexOf(Collections.max(cantidadVendida)));
            return masVendido;
        }
        return null;
    }

    private void devolverProductosVendidos(ArrayList<String> productosVendidos, ArrayList<Double> cantidadVendida){
        for(Registro registro: registros){
            if(registro.getTipo().equals("Venta")){
                if(!productosVendidos.contains(registro.getProducto().getNombre())){
                    productosVendidos.add(registro.getProducto().getNombre());
                    cantidadVendida.add((double)registro.getCantidad());
                }else{
                    int index = productosVendidos.indexOf(registro.getProducto()); 
                    cantidadVendida.set(index,cantidadVendida.get(index) + registro.getCantidad());
                }
            }
        }
    }

    public ArrayList<Producto> devolverProductosConPocasUnidades(){
        double porcentaje = 0.3;
        ArrayList<Producto> productosEscasos = new ArrayList<>();
        for(Producto producto: productosRegistrados){
            if(producto.getCantidadDisponible() <= (int)((producto.getCantidadAdquirida() * porcentaje))){
                productosEscasos.add(producto);
            }
        }
        return productosEscasos;
    }

    private ArrayList<Producto> devolverProductosPocoVendidosEnUnMargen(double margenInicial, double margenLimite){
        ArrayList<String> productosVendidos = new ArrayList<>();
        ArrayList<Double> cantidadVendida = new ArrayList<>();
        devolverProductosVendidos(productosVendidos, cantidadVendida);
        ArrayList<Producto> menosVendidos = new ArrayList<>();
        for(int i = 0; i < productosVendidos.size(); i++){
            for(Producto producto: productosRegistrados){
                if(producto.getNombre().equals(productosVendidos.get(i))){
                    if(producto.getCantidadAdquirida()*margenLimite >= cantidadVendida.get(i) && producto.getCantidadAdquirida()*margenInicial <= cantidadVendida.get(i)){
                        menosVendidos.add(producto);
                        break;
                    }
                }
            }
        }
        return menosVendidos;
    }

    private ArrayList<Producto> devolverProductosNoVendidos(){
        ArrayList<String> productosVendidos = new ArrayList<>();
        ArrayList<Double> cantidadVendida = new ArrayList<>();
        devolverProductosVendidos(productosVendidos, cantidadVendida);
        ArrayList<Producto> noVendidos = new ArrayList<>();
        for(Producto producto: productosRegistrados){
            boolean encontrado = false;
            for(int i = 0; i < productosVendidos.size(); i++){
                if(producto.getNombre().equals(productosVendidos.get(i))){
                    encontrado = true;
                    break;
                }
            }
            if(!encontrado){
                noVendidos.add(producto);
            }
        }
        return noVendidos;
    }

    public ArrayList<ArrayList<Producto>> devolverProductosEstaticos(double margen){
        ArrayList<ArrayList<Producto>> productosEstaticos = new ArrayList<>();
        productosEstaticos.add(devolverProductosNoVendidos());
        double margenInterno = 0.0;
        while((margenInterno + 0.2)<=margen){
            productosEstaticos.add(devolverProductosPocoVendidosEnUnMargen(margenInterno, margenInterno+0.2));
            margenInterno += 0.2;
        }
        return productosEstaticos;
    }
}
