package com.prueba.pruebaTecnica.models;

import jakarta.persistence.*;

@Entity
@Table(name = "lineas_credito")
public class LineaCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "l_credito_id")
    private Integer LCreditoId;

    @Column(name = "valor_maximo", nullable = false)
    private Float valorMaximo;

    @Column(name = "valor_minimo", nullable = false)
    private Float valorMinimo;

    @Column(name = "plazo_maximo", nullable = false)
    private Integer plazoMaximo;

    public LineaCredito() {}

    public LineaCredito(Float valorMaximo, Float valorMinimo, Integer plazoMaximo) {
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

    public Integer getLCreditoId() {
        return this.LCreditoId;
    }

    public void setLCreditoId(Integer LCreditoId) {
        this.LCreditoId = LCreditoId;
    }

    public Float getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(Float valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public Integer getPlazoMaximo() {
        return plazoMaximo;
    }

    public void setPlazoMaximo(Integer plazoMaximo) {
        this.plazoMaximo = plazoMaximo;
    }
}
