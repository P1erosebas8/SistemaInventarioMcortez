package com.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventario.model.Equipo;


public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}