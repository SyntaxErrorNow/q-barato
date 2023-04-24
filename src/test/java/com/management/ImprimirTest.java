package com.management;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import com.management.Archivos.ArchivoProducto;


public class ImprimirTest {

    private ArchivoProducto archivo;
    private Producto producto;

    @Before
    public void setUp() {
        archivo = new ArchivoProducto();
        producto = new Producto("fanta", "es una fanta", "fanta", "bebiba", "gaseosa", 20.0, null , 19, 03, 3, 2023, 03, 3, 2024,5.0);
     
    }

   
    @Test
    public void obtenerProductoTest(){
        try(MockedStatic<ArchivoProducto> archivo = Mockito.mockStatic(ArchivoProducto.class)){
            archivo.when(() -> ArchivoProducto.getProducto(producto.getId())).thenReturn(producto);
            assertEquals(producto, ArchivoProducto.getProducto(producto.getId()));
            archivo.verify(() -> ArchivoProducto.getProducto(producto.getId()), times(1));
        } catch (Exception e) {
        }
    }


}
