package com.inventario.controller;

import com.inventario.model.Usuario;
import com.inventario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> body) {
        String correo = body.get("correo");
        String contrasena = body.get("contrasena");

        Usuario u = usuarioService.login(correo, contrasena);

        Map<String, Object> resp = new HashMap<>();
        resp.put("success", u != null);
        return resp;
    }
}