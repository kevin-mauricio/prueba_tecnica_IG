package com.prueba.pruebaTecnica.repository;

import com.prueba.pruebaTecnica.models.LineaCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineaCreditoRepository extends JpaRepository<LineaCredito, Integer> {
}
