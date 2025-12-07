package com.inventario.controller;

import com.inventario.repository.EquipoRepository;
import com.inventario.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReporteController {

    private final EquipoRepository equipoRepository;
    private final UsuarioRepository usuarioRepository;

    public ReporteController(EquipoRepository equipoRepository, UsuarioRepository usuarioRepository) {
        this.equipoRepository = equipoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/reportes")
    public String mostrarReportes(Model model) {
        long activos = equipoRepository.countByEstado("Activo");
        long malogrados = equipoRepository.countByEstado("Malogrado");
        long reparacion = equipoRepository.countByEstado("En reparación");
        long cambio = equipoRepository.countByEstado("Listo para cambio");

        model.addAttribute("cantActivos", activos);
        model.addAttribute("cantMalogrados", malogrados);
        model.addAttribute("cantReparacion", reparacion);
        model.addAttribute("cantCambio", cambio);

        model.addAttribute("totalUsuarios", usuarioRepository.count());
        model.addAttribute("totalEquipos", equipoRepository.count());

        return "reportes";
    }
}