package com.management;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;


import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import com.management.Archivos.ArchivoUsuario;

public class IniciarSesionTest {

    private Usuario usuarioFalso;

    @Before
    public void setup(){
        usuarioFalso = new Usuario("Pepito", 20, 12345, "admin", "encargado");
    }

    @Test
    public void verificarDatosUsuario(){
        int ci = 12345;
        String contrasena = "admin";
        try (MockedStatic<ArchivoUsuario> archivo = Mockito.mockStatic(ArchivoUsuario.class)){
            archivo.when(() -> ArchivoUsuario.getUser(ci)).thenReturn(usuarioFalso);
            assertEquals(contrasena, ArchivoUsuario.getUser(ci).getContrasena());
            archivo.verify(() -> ArchivoUsuario.getUser(ci), times(1));
        } catch (Exception e) {
        }
    }

    @Test
    public void verificarUsuarioIsEncargado(){
        try(MockedStatic<ArchivoUsuario> archivo = Mockito.mockStatic(ArchivoUsuario.class)){
            archivo.when(() -> ArchivoUsuario.getUser(usuarioFalso.getCi())).thenReturn(usuarioFalso);
            assertEquals("encargado", ArchivoUsuario.getUser(usuarioFalso.getCi()).getCargo());
            archivo.verify(() -> ArchivoUsuario.getUser(usuarioFalso.getCi()), times(1));
        } catch (Exception e) {
        }
    }

    @Test
    public void verificarUsuarioIsEmpleado(){
        Usuario empleado = new Usuario("Juan", 19, 12345243, "juan123", "empleado");
        try(MockedStatic<ArchivoUsuario> archivo = Mockito.mockStatic(ArchivoUsuario.class)){
            archivo.when(() -> ArchivoUsuario.getUser(empleado.getCi())).thenReturn(empleado);
            assertEquals("empleado", ArchivoUsuario.getUser(empleado.getCi()).getCargo());
            archivo.verify(() -> ArchivoUsuario.getUser(empleado.getCi()), times(1));
        } catch (Exception e) {
        }
    }

}
