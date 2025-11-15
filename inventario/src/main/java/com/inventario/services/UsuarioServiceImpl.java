package com.inventario.services;

import com.inventario.model.Usuario;
import com.inventario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    @Override
    public Usuario login(String correo, String contrasena) {
        Usuario u = repo.findByCorreo(correo);
        if (u != null && u.getContrasena().equals(contrasena)) {
            return u;
        }
        return null;
    }
}