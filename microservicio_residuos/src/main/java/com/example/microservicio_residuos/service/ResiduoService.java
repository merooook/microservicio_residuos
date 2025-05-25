package com.example.microservicio_residuos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicio_residuos.model.Residuo;
import com.example.microservicio_residuos.repository.ResiduoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ResiduoService {

    @Autowired
    private ResiduoRepository residuoRepository;
    
    public List<Residuo> findAll() {
        return residuoRepository.findAll();
    }

    public List<Residuo> buscarPorId(Integer idBuscar) {
        return residuoRepository.buscarPorId(idBuscar);
    }

    public void eliminarPorId(Integer id) {
        residuoRepository.eliminarPorId(id);
    }

    public void guardar(Residuo nuevoResiduo) {
        residuoRepository.save(nuevoResiduo);
    }

    public List<Residuo> findById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
