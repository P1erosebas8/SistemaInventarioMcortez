package com.inventario.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.inventario.model.Equipo;
import com.inventario.services.EquipoService;


@RestController
@RequestMapping("/api/equipos")
@RequiredArgsConstructor
@CrossOrigin
public class EquipoController {


private final EquipoService equipoService;


@PostMapping
public Equipo save(@RequestBody Equipo e) {
return equipoService.save(e);
}


@GetMapping
public List<Equipo> list() {
return equipoService.findAll();
}


@PutMapping("/{id}")
public Equipo update(@PathVariable Long id, @RequestBody Equipo e) {
return equipoService.update(id, e);
}


@DeleteMapping("/{id}")
public void delete(@PathVariable Long id) {
equipoService.delete(id);
}
}