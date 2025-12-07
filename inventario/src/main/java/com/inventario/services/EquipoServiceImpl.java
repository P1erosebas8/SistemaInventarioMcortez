package com.inventario.services;

import com.inventario.model.Equipo;
import com.inventario.repository.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoServiceImpl(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Override
    public void guardarEquipo(Equipo equipo) {
        equipoRepository.save(equipo);
    }

    @Override
    public List<Equipo> listarEquipos() {
        return equipoRepository.findAll();
    }

    @Override
    public Equipo obtenerPorId(Long id) {
        return equipoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarEquipo(Long id) {
        equipoRepository.deleteById(id);
    }

    @Override
    public List<Equipo> buscarPorNombreOCodigo(String filtro) {
        return equipoRepository.findByNombreContainingIgnoreCaseOrCodigoContainingIgnoreCase(filtro, filtro);
    }
}
