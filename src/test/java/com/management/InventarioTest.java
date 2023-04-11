package com.management;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.management.Archivos.ArchivoInventario;

/**
 * Unit test for simple App.
 */
public class InventarioTest 
{
    Inventario inventarioPrueba;

    @Before
    public void inicializar() {
        inventarioPrueba = new Inventario(3, 2023);
    }

    @Test
    public void compararRegistrosDeUnInventarioTest(){
        assertEquals(inventarioPrueba.getRegistros(), ArchivoInventario.recopilarRegistros(3,2023));
    }

    @Test
    public void getPeriodosTest(){
        assertNotEquals(inventarioPrueba.getPeriodo(), 5);
    }

    @Test
    public void getAnioTest(){
        assertNotEquals(inventarioPrueba.getPeriodo(), 2020);
    }

    @Test
    public void getGananciasTest(){
        assertTrue(inventarioPrueba.getGanancias() >= 0);
    }

    @Test
    public void getPerdidaTest(){
        assertFalse(inventarioPrueba.getPerdida()<0);
    }

    @Test
    public void getCantidadVendidaTest(){
        assertTrue(inventarioPrueba.getCantidadVendida() >= 0);
    }

    @Test
    public void getCantidadPerdidaTest(){
        assertTrue(inventarioPrueba.getCantidadPerdida() >= 0);
    }

    @Test
    public void getCantidadAdquiridaTest(){
        assertTrue(inventarioPrueba.getCantidadAdquirida() >= 0);
    }

    @Test
    public void getCapitalInvertidoTest(){
        assertTrue(inventarioPrueba.getCapitalInvertido()>=0);
    }
}
