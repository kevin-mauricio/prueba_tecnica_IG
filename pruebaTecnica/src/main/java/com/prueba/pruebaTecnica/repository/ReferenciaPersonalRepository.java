package com.prueba.pruebaTecnica.repository;

import com.prueba.pruebaTecnica.models.ReferenciaPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenciaPersonalRepository extends JpaRepository<ReferenciaPersonal, Integer> {
}
