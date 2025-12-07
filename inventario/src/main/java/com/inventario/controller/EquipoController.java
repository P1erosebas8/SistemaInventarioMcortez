package com.inventario.controller;

import com.inventario.model.Equipo;
import com.inventario.services.EquipoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/equipos")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public String vistaEquipos(@RequestParam(required = false) String filtro, Model model) {

        if (filtro != null && !filtro.trim().isEmpty()) {
            model.addAttribute("equipos", equipoService.buscarPorNombreOCodigo(filtro));
            model.addAttribute("filtro", filtro);
        } else {
            model.addAttribute("equipos", equipoService.listarEquipos());
        }

        model.addAttribute("equipo", new Equipo());

        return "equipos";
    }

    @PostMapping("/registrar")
    public String registrarEquipo(@ModelAttribute Equipo equipo) {
        equipoService.guardarEquipo(equipo);
        return "redirect:/equipos";
    }

    @GetMapping("/api/{id}")
    @ResponseBody
    public Equipo obtenerEquipoJson(@PathVariable Long id) {
        return equipoService.obtenerPorId(id);
    }

    @PostMapping("/editar/{id}")
    public String editarEquipo(@PathVariable Long id, @ModelAttribute Equipo equipo) {
        equipo.setId(id);
        equipoService.guardarEquipo(equipo);
        return "redirect:/equipos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEquipo(@PathVariable Long id) {
        equipoService.eliminarEquipo(id);
        return "redirect:/equipos";
    }
}
