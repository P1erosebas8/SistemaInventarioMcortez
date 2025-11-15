package com.inventario.controller;
import com.inventario.model.Ubicacion;
import com.inventario.repository.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ubicaciones")
public class UbicacionController {

@Autowired
private UbicacionRepository repo;

@GetMapping
public List<Ubicacion> listar() {
return repo.findAll();
}

@PostMapping
public Ubicacion crear(@RequestBody Ubicacion u) {
if (u.getFechaRegistro() == null) u.setFechaRegistro(LocalDate.now());
return repo.save(u);
}
}