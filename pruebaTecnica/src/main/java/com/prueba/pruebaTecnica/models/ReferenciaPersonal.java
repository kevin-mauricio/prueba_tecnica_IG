package com.prueba.pruebaTecnica.models;

import jakarta.persistence.*;

@Entity
@Table(name = "referencias_personales")
public class ReferenciaPersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_personales_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "nombre", nullable = false, length = 40)
    private String nombre;

    @Column(name = "direccion", nullable = false, length = 120)
    private String direccion;

    @Column(name = "telefono", nullable = false, length = 12)
    private String telefono;

    @Column(name = "ciudad", nullable = false, length = 50)
    private String ciudad;

    @Column(name = "email", nullable = false, length = 120)
    private String email;

    public ReferenciaPersonal() {}

    public ReferenciaPersonal(Cliente cliente, String nombre, String direccion, String telefono, String ciudad, String email) {
        this.cliente = cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.email = email;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
