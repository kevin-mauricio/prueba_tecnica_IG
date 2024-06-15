package com.prueba.pruebaTecnica.controller;

import com.prueba.pruebaTecnica.models.LineaCredito;
import com.prueba.pruebaTecnica.repository.LineaCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lineas-credito")
public class LineaCreditoController {

    @Autowired
    private LineaCreditoRepository lineaCreditoRepository;

    @GetMapping
    public List<LineaCredito> getAllLineasCredito() {
        return lineaCreditoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LineaCredito> getLineaCreditoById(@PathVariable Integer id) {
        Optional<LineaCredito> lineaCredito = lineaCreditoRepository.findById(id);
        return lineaCredito.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public LineaCredito createLineaCredito(@RequestBody LineaCredito lineaCredito) {
        return lineaCreditoRepository.save(lineaCredito);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LineaCredito> updateLineaCredito(@PathVariable Integer id, @RequestBody LineaCredito lineaCreditoDetails) {
        Optional<LineaCredito> lineaCredito = lineaCreditoRepository.findById(id);

        if (lineaCredito.isPresent()) {
            LineaCredito updatedLineaCredito = lineaCredito.get();
            updatedLineaCredito.setValorMaximo(lineaCreditoDetails.getValorMaximo());
            updatedLineaCredito.setValorMinimo(lineaCreditoDetails.getValorMinimo());
            updatedLineaCredito.setPlazoMaximo(lineaCreditoDetails.getPlazoMaximo());
            lineaCreditoRepository.save(updatedLineaCredito);
            return ResponseEntity.ok(updatedLineaCredito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLineaCredito(@PathVariable Integer id) {
        Optional<LineaCredito> lineaCredito = lineaCreditoRepository.findById(id);

        if (lineaCredito.isPresent()) {
            lineaCreditoRepository.delete(lineaCredito.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
