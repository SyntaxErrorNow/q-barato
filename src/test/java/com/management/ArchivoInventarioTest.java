package com.management;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.management.Archivos.ArchivoInventario;

/**
 * Unit test for simple App.
 */
public class ArchivoInventarioTest 
{
    ArchivoInventario archivoInventarioPrueba;

    @Before
    public void inicializar() {
        archivoInventarioPrueba = new ArchivoInventario();
    }

    @Test
    public void getInventarioTest(){
        assertNull(ArchivoInventario.getInventario("Viernes"));
    }

    @Test
    public void postInventarioTest(){
        ArchivoInventario.postInventario(new Inventario(12, 2030));
        Inventario creado = ArchivoInventario.getInventario("2030-12 1");
        ArchivoInventario.deleteProducto(creado);
        assertNotEquals(creado,ArchivoInventario.getInventario("2030-12 1"));
        
    }

    @Test
    public void recopilarInventarios(){
        assertNotNull(ArchivoInventario.recopilarInventarios());
    }

    @After
    public void limpiar() {
        ArchivoInventario.deleteProducto(ArchivoInventario.getInventario("2030-12 1"));
    }
    //get
    //post
    //recopilarInventarios
}
