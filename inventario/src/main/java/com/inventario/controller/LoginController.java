package com.inventario.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inventario.model.Usuario;
import com.inventario.services.UsuarioService;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(
            @RequestParam String correo,
            @RequestParam String password,
            Model model) {

        Usuario usuario = usuarioService.login(correo, password);

        if (usuario == null) {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login";
        }

        return "redirect:/panel";
    }
}
