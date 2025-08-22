package com.example.proyectoprog.dao;

import com.example.proyectoprog.models.Usuario;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
