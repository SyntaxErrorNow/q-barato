package com.management;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.management.Archivos.ArchivoInventario;
import com.management.Archivos.ArchivoProducto;

/**
 * Unit test for simple App.
 */
public class ArchivoProductoTest 
{
    ArchivoProducto archivoInventarioPrueba;


    @Test
    public void getProductoTest(){
        assertNull(ArchivoProducto.getProducto("Viernes"));
    }

    @Test
    public void postProductoTest(){
        Producto productoPrueba = new Producto("MENDOSINA", "light-refresco de cola mendosina", "Mendosina", "bebidas", "gaseosa", 15.0, null, 15, 15, 1, 2023, 9, 9, 2024, 15);
        ArchivoProducto.postProducto(productoPrueba);
        Producto creado = ArchivoProducto.getProducto("30002");
        ArchivoProducto.deleteProducto(creado);
        assertNotEquals(creado,ArchivoProducto.getProducto("10001"));
    }

    public void modifyProductoTest(){
        ArchivoProducto.postProducto(new Producto("MENDOSINA", "light-refresco de cola mendosina", "Mendosina", "bebidas", "gaseosa", 15.0, null, 15, 15, 1, 2023, 9, 9, 2024, 15));
        Producto conesguido = ArchivoProducto.getProducto("30002");
        conesguido.setNombre("Mirinda");
        ArchivoProducto.modifyProducto(conesguido);
        assertNotNull(ArchivoProducto.getProducto(conesguido.getId()));
    }
    
    public void deleteProductoTest(){
        ArchivoProducto.postProducto(new Producto("MENDOSINA", "light-refresco de cola mendosina", "Mendosina", "bebidas", "gaseosa", 15.0, null, 15, 15, 1, 2023, 9, 9, 2024, 15));
        Producto conesguido = ArchivoProducto.getProducto("30002");
        ArchivoProducto.deleteProducto(conesguido);
        assertNull(ArchivoProducto.getProducto(conesguido.getId()));
    }

    //get
    //post
    //modify
    //delete


    @Test
    public void postProductoDeTemporadaTest(){
        Producto productoPrueba = new Producto("Paneton Carlitos", "apto para celiacos-un paneton de chocolate", "San Gabriel", "comestibles", "derivados de cereales", 12.0, null, 10, 15, 1, 2023, 9, 9, 2024, 15);
        ArchivoProducto.postProductoTemporada(productoPrueba,12);
        Producto creado = ArchivoProducto.getProducto("71201");
        ArchivoProducto.deleteProducto(creado);
        assertEquals(productoPrueba.getNombre(),creado.getNombre());
    }

    @Test
    public void recolectarTemporadaTest(){
        Producto productoPrueba = new Producto("Paneton Carlitos", "apto para celiacos-un paneton de chocolate", "San Gabriel", "comestibles", "derivados de cereales", 12.0, null, 10, 15, 1, 2023, 9, 9, 2024, 15);
        ArchivoProducto.postProductoTemporada(productoPrueba,12);
        Producto creado = ArchivoProducto.getProducto("71201");
        ArrayList<Producto> temporales = ArchivoProducto.getProductoTemporales();
        ArchivoProducto.deleteProducto(creado);
        assertEquals(productoPrueba.getNombre(),temporales.get(0).getNombre());
    }

    @Test
    public void getProductoPorNombreTest(){
        assertNotNull(ArchivoProducto.getProductoPorNombre("fanta"));
    }
    @Test 
    public void getProductoPorCategoriaTest(){
        assertNotNull(ArchivoProducto.getProductoPorCategoria("despensa"));
    }


    //postTemp
    //recolectarTemp
}
