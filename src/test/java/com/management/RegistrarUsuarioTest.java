package com.management;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import org.mockito.MockedStatic;
import org.mockito.Mockito;

import org.mockito.stubbing.Answer;

import com.management.Archivos.ArchivoUsuario;
public class RegistrarUsuarioTest {


    private Encargado encargado;
    private Usuario usuarioFalso;
    @Before
    public void setUp(){
        encargado = Mockito.mock(Encargado.class);
        usuarioFalso = new Usuario("Pepito", 20, 12345, "admin", "encargado");
    }


    @Test
    public void verificarGuardarUsuarioArchivoUsuario(){
        try(MockedStatic<ArchivoUsuario> archivo = Mockito.mockStatic(ArchivoUsuario.class)){
            archivo.when(() -> ArchivoUsuario.postUser(usuarioFalso)).thenAnswer((Answer<Void>) invocation -> null);
            ArchivoUsuario.postUser(usuarioFalso);
            archivo.verify(()-> ArchivoUsuario.postUser(usuarioFalso), times(1));
        } catch (Exception e) {

        }
    }

    @Test
    public void verificarEncargadoRegistrarEmpleado(){
        try(MockedStatic<ArchivoUsuario> archivo = Mockito.mockStatic(ArchivoUsuario.class)){
            Mockito.doCallRealMethod().when(encargado).registrarEmpleado();
            encargado.registrarEmpleado();
            verify(encargado, times(1)).registrarEmpleado();
        } catch (Exception e) {
        }
    }

    @Test
    public void verificarObtenerUsuarioArchivoUsuario(){
        try(MockedStatic<ArchivoUsuario> archivo = Mockito.mockStatic(ArchivoUsuario.class)){
            archivo.when(() -> ArchivoUsuario.getUser(usuarioFalso.getCi())).thenReturn(usuarioFalso);
            assertEquals(usuarioFalso, ArchivoUsuario.getUser(usuarioFalso.getCi()));
            archivo.verify(() -> ArchivoUsuario.getUser(usuarioFalso.getCi()), times(1));
        } catch (Exception e) {
        }
    }

    @Test
    public void verificarEncargadoModificarEmpleado(){
        try {
            Mockito.doAnswer((Answer<Void>) invocation -> null).when(encargado).modificarEmpleado();
            encargado.modificarEmpleado();
            verify(encargado, times(1)).modificarEmpleado();
        } catch (Exception e) {
        }
    }

    @Test
    public void verificarUsuarioNoExiste(){
        try(MockedStatic<ArchivoUsuario> archivo = Mockito.mockStatic(ArchivoUsuario.class)){
            archivo.when(() -> ArchivoUsuario.getUser(usuarioFalso.getCi())).thenReturn(null);
            assertEquals(null, ArchivoUsuario.getUser(usuarioFalso.getCi()));
            archivo.verify(() -> ArchivoUsuario.getUser(usuarioFalso.getCi()), times(1));
        } catch (Exception e) {
        }
    }

}
