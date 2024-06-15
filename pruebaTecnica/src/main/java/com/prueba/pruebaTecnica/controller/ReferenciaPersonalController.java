package com.prueba.pruebaTecnica.controller;

import com.prueba.pruebaTecnica.models.ReferenciaPersonal;
import com.prueba.pruebaTecnica.repository.ReferenciaPersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/referencias-personales")
public class ReferenciaPersonalController {

    @Autowired
    private ReferenciaPersonalRepository referenciaPersonalRepository;

    @GetMapping
    public List<ReferenciaPersonal> getAllReferenciasPersonales() {
        return referenciaPersonalRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReferenciaPersonal> getReferenciaPersonalById(@PathVariable Integer id) {
        Optional<ReferenciaPersonal> referenciaPersonal = referenciaPersonalRepository.findById(id);
        return referenciaPersonal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ReferenciaPersonal createReferenciaPersonal(@RequestBody ReferenciaPersonal referenciaPersonal) {
        return referenciaPersonalRepository.save(referenciaPersonal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReferenciaPersonal> updateReferenciaPersonal(@PathVariable Integer id, @RequestBody ReferenciaPersonal referenciaPersonalDetails) {
        Optional<ReferenciaPersonal> referenciaPersonal = referenciaPersonalRepository.findById(id);

        if (referenciaPersonal.isPresent()) {
            ReferenciaPersonal updatedReferenciaPersonal = referenciaPersonal.get();
            updatedReferenciaPersonal.setCliente(referenciaPersonalDetails.getCliente());
            updatedReferenciaPersonal.setNombre(referenciaPersonalDetails.getNombre());
            updatedReferenciaPersonal.setDireccion(referenciaPersonalDetails.getDireccion());
            updatedReferenciaPersonal.setTelefono(referenciaPersonalDetails.getTelefono());
            updatedReferenciaPersonal.setCiudad(referenciaPersonalDetails.getCiudad());
            updatedReferenciaPersonal.setEmail(referenciaPersonalDetails.getEmail());
            referenciaPersonalRepository.save(updatedReferenciaPersonal);
            return ResponseEntity.ok(updatedReferenciaPersonal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReferenciaPersonal(@PathVariable Integer id) {
        Optional<ReferenciaPersonal> referenciaPersonal = referenciaPersonalRepository.findById(id);

        if (referenciaPersonal.isPresent()) {
            referenciaPersonalRepository.delete(referenciaPersonal.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
