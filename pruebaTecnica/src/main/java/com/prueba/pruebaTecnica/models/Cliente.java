package com.prueba.pruebaTecnica.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cliente_id;
    private String tipo_documento;
    private String numero_documento;
    private String apellidos;
    private String residencia;
    private String ciudad;
    private String telefono;
    private String nit_empresa;
    private String nombre_empresa;
    private String direccion_empresa;
    private String telefono_empresa;
    private String cargo;
    private LocalDate fecha_vinculacion;

    public Cliente() {
    }

    public Cliente(String tipo_documento, String numero_documento, String apellidos, String residencia, String ciudad, String telefono, String nit_empresa, String nombre_empresa, String direccion_empresa, String telefono_empresa, String cargo, LocalDate fecha_vinculacion) {
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.apellidos = apellidos;
        this.residencia = residencia;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.nit_empresa = nit_empresa;
        this.nombre_empresa = nombre_empresa;
        this.direccion_empresa = direccion_empresa;
        this.telefono_empresa = telefono_empresa;
        this.cargo = cargo;
        this.fecha_vinculacion = fecha_vinculacion;
    }

    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit_empresa() {
        return nit_empresa;
    }

    public void setNit_empresa(String nit_empresa) {
        this.nit_empresa = nit_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getDireccion_empresa() {
        return direccion_empresa;
    }

    public void setDireccion_empresa(String direccion_empresa) {
        this.direccion_empresa = direccion_empresa;
    }

    public String getTelefono_empresa() {
        return telefono_empresa;
    }

    public void setTelefono_empresa(String telefono_empresa) {
        this.telefono_empresa = telefono_empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getFecha_vinculacion() {
        return fecha_vinculacion;
    }

    public void setFecha_vinculacion(LocalDate fecha_vinculacion) {
        this.fecha_vinculacion = fecha_vinculacion;
    }
}
