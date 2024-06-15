package com.prueba.pruebaTecnica.models;

import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "lineas_credito")
public class LineaCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "l_credito_id")
    private Integer id;

    @Column(name = "valor_maximo", nullable = false)
    private Float valorMaximo;

    @Column(name = "valor_minimo", nullable = false)
    private Float valorMinimo;

    @Column(name = "plazo_maximo", nullable = false)
    private LocalDate plazoMaximo;

    public LineaCredito() {}

    public LineaCredito(Float valorMaximo, Float valorMinimo, LocalDate plazoMaximo) {
        this.valorMaximo = valorMaximo;
        this.valorMinimo = valorMinimo;
        this.plazoMaximo = plazoMaximo;
    }

    public Float getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(Float valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(Float valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public LocalDate getPlazoMaximo() {
        return plazoMaximo;
    }

    public void setPlazoMaximo(LocalDate plazoMaximo) {
        this.plazoMaximo = plazoMaximo;
    }
}
