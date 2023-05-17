package com.management.modelo.repositories;
import java.util.List;


import com.management.modelo.schema.Usuario;

public interface UsuarioRepository {
    Usuario getUserByCi(int ci);
    List<Usuario> getAllEmpleados();
    Usuario createUsuario(Usuario usuario);
    void deleteUsuarioByCi(int ci);
}
