package com.example.microservicio_residuos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicio_residuos.model.Residuo;
import com.example.microservicio_residuos.service.ResiduoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("/api/residuos/v1")
public class ResiduoController {

    @Autowired
    private ResiduoService residuoService;

    @GetMapping("/listarResiduos")
    public ResponseEntity<List<Residuo>> listar() {
        List<Residuo> residuos = residuoService.findAll();
        if (residuos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(residuos);
    }
    
    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<List<Residuo>> buscarPorId(Integer id) {
        List<Residuo> residuos = residuoService.findById(id);
        if (residuos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(residuos);
    }

    @DeleteMapping("/eliminarPorId/{id}")
    public ResponseEntity<Void> eliminarPorId(Integer id) {
        List<Residuo> residuos = residuoService.findById(id);
        if (residuos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        residuoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/guardarResiduos")
    public ResponseEntity<Void> guardar(@RequestBody Residuo nuevoResiduo) {
        if (nuevoResiduo == null) {
            return ResponseEntity.badRequest().build();
        }
        residuoService.guardar(nuevoResiduo);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/actualizarResiduos")
    public ResponseEntity<Void> actualizar(@RequestBody Residuo nuevoResiduo) {
        if (nuevoResiduo == null) {
            return ResponseEntity.badRequest().build();
        }
        residuoService.guardar(nuevoResiduo);
        return ResponseEntity.ok().build();
    }
}
