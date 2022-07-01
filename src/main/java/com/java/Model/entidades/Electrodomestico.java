/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.Model.entidades;

/**
 *
 * @author PCNEW
 */
public class Electrodomestico {
    private Integer idElectr;
    private String nombre;
    private String marca;
    private String modelo;
    private String serie;
    private TipoElectro tipo;
    private String descripcion;

    private Cliente cliente;

    public Electrodomestico() {
    }

    public Electrodomestico(String nombre,String marca, String modelo, String serie, TipoElectro tipo, String descripcion,Cliente cliente) {
        this.nombre=nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.serie = serie;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.cliente= cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdElectr() {
        return idElectr;
    }

    public void setIdElectr(Integer idElectr) {
        this.idElectr = idElectr;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public TipoElectro getTipo() {
        return tipo;
    }

    public void setTipo(TipoElectro tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Electrodomestico{" +
                "idElectr=" + idElectr +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", serie='" + serie + '\'' +
                ", tipo=" + tipo +
                ", descripcion='" + descripcion + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
