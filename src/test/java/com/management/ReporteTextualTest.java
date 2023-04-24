package com.management;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import com.management.Archivos.ArchivoInventario;

public class ReporteTextualTest {
    private Inventario inventario = new Inventario(12, 2030);

    @Before
    public void setUp(){
        inventario.setIDInventario("2030-12 1");
    }

    @Test
    public void verificarIdInventario(){
        try(MockedStatic<ArchivoInventario> archivo = Mockito.mockStatic(ArchivoInventario.class)){

            archivo.when(() -> ArchivoInventario.getInventario("2030-12 1")).thenReturn(inventario);

            assertEquals("2030-12 1", ArchivoInventario.getInventario("2030-12 1").getIDInventario());
            archivo.verify(() -> ArchivoInventario.getInventario("2030-12 1"), times(1));
        } catch (Exception e) {
        }
    }


}
