package com.inventario.services;
import com.inventario.model.Usuario;

public interface UsuarioService {
    Usuario login(String correo, String contrasena);
}