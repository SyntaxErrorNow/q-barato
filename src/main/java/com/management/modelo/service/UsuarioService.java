package com.management.modelo.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.management.modelo.database.MongoDBConnection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.IndexOptions;
import com.management.modelo.repositories.UsuarioRepository;
import com.management.modelo.schema.Usuario;

public class UsuarioService implements UsuarioRepository {
    private final MongoCollection<Usuario> usuarioCollection;

    public UsuarioService(){
        usuarioCollection = MongoDBConnection.getDatabase().getCollection("usuarios", Usuario.class);
        IndexOptions indexOptions = new IndexOptions().unique(true);
        usuarioCollection.createIndex(new Document("ci", 1), indexOptions);
    }

    @Override
    public Usuario getUserByCi(int ci) {
        try{
            return usuarioCollection.find(new Document("ci", ci)).first();
        }catch (Exception e) {
            throw new RuntimeException("Error al obtener el Usuario");
        }
    }

    @Override
    public List<Usuario> getAllEmpleados() {
        try{
            return usuarioCollection.find().into(new ArrayList<>(null));
        }catch (Exception e) {
            throw new RuntimeException("Error al obtener los empleados");
        }
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        try {
            usuarioCollection.insertOne(usuario);
            return usuario;

        } catch (Exception e) {
            throw new RuntimeException("Error al crear el usuario", e);
        }
    }


    @Override
    public void deleteUsuarioByCi(int ci) {
        try {
            usuarioCollection.deleteOne(new Document("ci", ci));

        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el Usuario");

        }
    }

}
