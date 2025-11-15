package com.inventario.services;

import java.util.List;
import com.inventario.model.Equipo;

public interface EquipoService {
Equipo save(Equipo e);
List<Equipo> findAll();
Equipo update(Long id, Equipo e);
void delete(Long id);
}