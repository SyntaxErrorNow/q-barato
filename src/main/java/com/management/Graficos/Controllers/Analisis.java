package com.management.Graficos.Controllers;

import java.util.ArrayList;

import com.management.Producto;

public class Analisis {
    public static int cantidadVendida(ArrayList<Producto> productos) {
        int value = 0;
        for (Producto p : productos) {
            value += p.getCantidadVendida();
        }
        return value;
    }
    public static int cantidadRestante(ArrayList<Producto> productos) {
        int value = 0;
        for (Producto p : productos) {
            value += p.getCantidadAdquirida()-p.getCantidadVendida();
        }
        return value;
    }
    
}
