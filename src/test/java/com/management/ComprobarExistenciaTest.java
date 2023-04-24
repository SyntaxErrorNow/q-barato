package com.management;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import com.management.Archivos.ArchivoProducto;

public class ComprobarExistenciaTest {

    private Producto productoFalso;

    @Before
    public void setUp() {
        productoFalso = new Producto("fanta", "es una fanta", "fanta", "bebiba", "gaseosa", 20.0, null , 19, 03, 3, 2023, 03, 3, 2024,5.0);
    }




    @Test
    public void verificarObtenerProductoArchivoById(){
        try(MockedStatic<ArchivoProducto> archivo = Mockito.mockStatic(ArchivoProducto.class)){
            archivo.when(() -> ArchivoProducto.getProducto(productoFalso.getId())).thenReturn(productoFalso);
            assertEquals(productoFalso, ArchivoProducto.getProducto(productoFalso.getId()));
            archivo.verify(() -> ArchivoProducto.getProducto(productoFalso.getId()), times(1));
        } catch (Exception e) {
        }
    }

    @Test
    public void verificarCantidadDisponible(){
        try{
            assertEquals(19, productoFalso.getCantidadDisponible());
        } catch (Exception e) {
        }
    }

}
