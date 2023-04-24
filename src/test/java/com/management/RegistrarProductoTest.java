package com.management;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import com.management.Archivos.ArchivoProducto;

public class RegistrarProductoTest {


    private Producto productoFalso;

    @Before
    public void setUp() {
        productoFalso = new Producto("fanta", "es una fanta", "fanta", "bebiba", "gaseosa", 20.0, null , 19, 03, 3, 2023, 03, 3, 2024,5.0);
    }


    @Test
    public void verificarGuardarProductoArchivo(){
        try(MockedStatic<ArchivoProducto> archivo = Mockito.mockStatic(ArchivoProducto.class)){
            archivo.when(() -> ArchivoProducto.postProducto(productoFalso)).thenAnswer((Answer<Void>) invocation -> null);
            ArchivoProducto.postProducto(productoFalso);
            archivo.verify(() -> ArchivoProducto.postProducto(productoFalso), times(1));
        }catch(Exception e){

        }

    }

    @Test
    public void verificarObtenerProductoArchivoByNombre(){
        try(MockedStatic<ArchivoProducto> archivo = Mockito.mockStatic(ArchivoProducto.class)){
            archivo.when(() -> ArchivoProducto.getProductoPorNombre(productoFalso.getNombre())).thenReturn(productoFalso);
            assertEquals(productoFalso, ArchivoProducto.getProductoPorNombre(productoFalso.getNombre()));
            archivo.verify(() -> ArchivoProducto.getProductoPorNombre(productoFalso.getNombre()), times(1));
        } catch (Exception e) {
        }
    }

}
