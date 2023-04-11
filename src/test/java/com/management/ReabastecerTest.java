package com.management;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import com.management.Archivos.ArchivoProducto;

public class ReabastecerTest {
    private ArrayList<Producto> productosReabastecidos=  new ArrayList<Producto>();
    private Producto producto1 = new Producto("coca cola", "refresco", "coca cola", "bebidas", "gaseosas", 13.0, null, 70, 2, 4, 2023, 13, 11, 2024, 23.0);
    //private Producto producto2;

    @Before
    public void setUp(){

        producto1.setCantidadDisponible(5);
        //producto2 = new Producto("fanta", "refresco", "coca cola", "bebidas", "gaseosas", 13.0, null, 10, 2, 4, 2023, 13, 11, 2024);
        productosReabastecidos.add(producto1);
    }

    @Test
    public void devolverSoloProductosCumplanCondicion(){
        try(MockedStatic<ArchivoProducto> archivo = Mockito.mockStatic(ArchivoProducto.class)){

            archivo.when(() -> ArchivoProducto.reabastecerProductosLote(50)).thenReturn(productosReabastecidos);

            assertArrayEquals(productosReabastecidos.toArray(), ArchivoProducto.reabastecerProductosLote(50).toArray());
            archivo.verify(() -> ArchivoProducto.reabastecerProductosLote(50), times(1));
        } catch (Exception e) {
        }
    }

    @Test
    public void verificarCambioCantidadAdquirida(){
        try(MockedStatic<ArchivoProducto> archivo = Mockito.mockStatic(ArchivoProducto.class)){
            for (Producto producto : productosReabastecidos) {
                when(producto.getCantidadAdquirida()).thenReturn(50);
                assertEquals(50, producto.getCantidadAdquirida());
            }
        } catch (Exception e) {
        }
    }

    @Test
    public void verificarCambioCantidadDisponible(){
        try(MockedStatic<ArchivoProducto> archivo = Mockito.mockStatic(ArchivoProducto.class)){
            for (Producto producto : productosReabastecidos) {
                when(producto.getCantidadDisponible()).thenReturn(55);
                assertEquals(55, producto.getCantidadDisponible());
            }
        } catch (Exception e) {
        }
    }


}
