package com.inventario.controller;

import com.inventario.repository.EquipoRepository;
import com.inventario.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PanelController {

    private final UsuarioRepository usuarioRepository;
    private final EquipoRepository equipoRepository;

    public PanelController(UsuarioRepository usuarioRepository, EquipoRepository equipoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.equipoRepository = equipoRepository;
    }

    @GetMapping("/panel")
    public String mostrarPanel(Model model) {
        long totalUsuarios = usuarioRepository.count();
        long totalEquipos = equipoRepository.count();

        model.addAttribute("totalUsuarios", totalUsuarios);
        model.addAttribute("totalEquipos", totalEquipos);

        return "panel"; 
    }
}