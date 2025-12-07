package com.inventario.services;

import com.inventario.model.Usuario;
import com.inventario.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario login(String correo, String contrasena) {
        Usuario u = usuarioRepository.findByCorreo(correo);
        if (u != null && passwordEncoder.matches(contrasena, u.getContrasena())) {
            return u;
        }
        return null;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> buscarPorNombreOCorreo(String filtro) {
        return usuarioRepository.findAll().stream()
                .filter(u -> u.getNombre().toLowerCase().contains(filtro.toLowerCase())
                        || u.getCorreo().toLowerCase().contains(filtro.toLowerCase()))
                .toList();
    }


    public void registrarUsuario(Usuario usuario) {
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        usuarioRepository.save(usuario);
    }

    public void actualizarUsuario(Long id, Usuario usuarioForm) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);

        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuarioForm.getNombre());
            usuarioExistente.setCorreo(usuarioForm.getCorreo());

            if (usuarioForm.getContrasena() != null && !usuarioForm.getContrasena().trim().isEmpty()) {
                usuarioExistente.setContrasena(passwordEncoder.encode(usuarioForm.getContrasena()));
            }

            usuarioRepository.save(usuarioExistente);
        }
    }
}