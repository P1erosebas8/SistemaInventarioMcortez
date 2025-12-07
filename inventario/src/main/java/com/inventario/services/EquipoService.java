package com.inventario.services;

import com.inventario.model.Equipo;

import java.util.List;

public interface EquipoService {

    void guardarEquipo(Equipo equipo);

    List<Equipo> listarEquipos();

    Equipo obtenerPorId(Long id);

    void eliminarEquipo(Long id);

    List<Equipo> buscarPorNombreOCodigo(String filtro);
}
