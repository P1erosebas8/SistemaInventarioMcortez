package com.inventario.controller;

import com.inventario.model.Usuario;
import com.inventario.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String vistaUsuarios(@RequestParam(required = false) String filtro, Model model) {
        if (filtro != null && !filtro.trim().isEmpty()) {
            model.addAttribute("usuarios", usuarioService.buscarPorNombreOCorreo(filtro));
            model.addAttribute("filtro", filtro);
        } else {
            model.addAttribute("usuarios", usuarioService.listarUsuarios());
        }
        model.addAttribute("usuario", new Usuario());
        return "usuarios";
    }

    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/api/{id}")
    @ResponseBody
    public Usuario obtenerUsuarioJson(@PathVariable Long id) {
        return usuarioService.obtenerPorId(id);
    }

    @PostMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, @ModelAttribute Usuario usuarioForm) {
        usuarioService.actualizarUsuario(id, usuarioForm);
        
        return "redirect:/usuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
}