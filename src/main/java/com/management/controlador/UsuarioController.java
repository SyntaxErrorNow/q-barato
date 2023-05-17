package com.management.controlador;

import javax.swing.JOptionPane;
import java.util.List;

import com.management.modelo.schema.Usuario;
import com.management.modelo.service.UsuarioService;

public class UsuarioController {
    private UsuarioService usuarioService;
    public UsuarioController(){
        usuarioService = new UsuarioService();
    }

    public List<Usuario> getAllEmpleados(){
        try {
            return usuarioService.getAllEmpleados();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener a todos los usuarios");
            throw new RuntimeException("Error al obtener todos los empleados ", e);
        }
    }

    public Usuario getUsuarioByCI(int ci){
        try {
            return usuarioService.getUserByCi(ci);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener a todos los usuarios");
            throw new RuntimeException("Error al obtener el usuario ", e);
        }
    }

    public void registrarUsuario(Usuario usuario){
        try {
            usuarioService.createUsuario(usuario);
            JOptionPane.showMessageDialog(null, "El usuario se registró exitosamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El usuario con ci: " + usuario.getCi() + " ya existe");
        }
    }


    public void eliminarUsuarioByCi(int ci){
        try {
           usuarioService.deleteUsuarioByCi(ci);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener a todos los usuarios");
            throw new RuntimeException("Error al eliminar el usuario ", e);
        }
    }
}
