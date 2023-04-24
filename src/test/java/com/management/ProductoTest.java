package com.management;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.management.Archivos.ArchivoInventario;

/**
 * Unit test for simple App.
 */
public class ProductoTest 
{
    Producto productoPrueba;

    @Before
    public void inicializar() {
        productoPrueba = new Producto("MENDOSINA", "light-refresco de cola mendosina", "Mendosina", "bebidas", "gaseosa", 15.0, null, 15, 15, 1, 2023, 9, 9, 2024, 15);
    }

    @Test
    public void comprobarEstado(){
        assertTrue(productoPrueba.getFechaCompra().compararSiOtraFechaEsMayor(productoPrueba.getFechaCaducidad()));
    }

}
