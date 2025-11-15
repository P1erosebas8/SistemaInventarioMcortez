package com.inventario.services;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.inventario.model.Equipo;
import com.inventario.repository.EquipoRepository;

@Service
@RequiredArgsConstructor
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository equipoRepository;

    @Override
    public Equipo save(Equipo e) {
        return equipoRepository.save(e);
    }

    @Override
    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    @Override
    public Equipo update(Long id, Equipo e) {
        Equipo actual = equipoRepository.findById(id).orElseThrow();
        actual.setTipo(e.getTipo());
        actual.setMarca(e.getMarca());
        actual.setEstado(e.getEstado());
        actual.setResponsable(e.getResponsable());
        actual.setUbicacion(e.getUbicacion());
        return equipoRepository.save(actual);
    }

    @Override
    public void delete(Long id) {
        equipoRepository.deleteById(id);
    }
}