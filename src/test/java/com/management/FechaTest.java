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
public class FechaTest 
{
    Fecha fechaPrueba;

    @Test
    public void comprobarFechaCorrectaTest(){
        fechaPrueba = new Fecha(32, 2, 2023);
        assertEquals(fechaPrueba.getDia(), 0);;
    }

    @Test
    public void comprobarDiasDelMesTest(){
        fechaPrueba = new Fecha(18, 2, 2023);
        assertEquals(fechaPrueba.determinarDiasPorMes(fechaPrueba.getMes()), 28);;
    }

    @Test
    public void comprobarFechaMayorTest(){
        fechaPrueba = new Fecha(18, 2, 2023);
        Fecha fechaPrueba2 = new Fecha(8, 1, 2025);
        assertTrue(fechaPrueba.compararSiOtraFechaEsMayor(fechaPrueba2));;
    }

}
