/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.Model.entidades;

/**
 *
 * @author PCNEW
 */
public class TipoServicio {
    private Integer idTipoServicio;
    private String nombre;
    private Double precio;

    public TipoServicio(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public TipoServicio() {
    }

    public Integer getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "TipoServicio{" + "idTipoServicio=" + idTipoServicio + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
    
    
}
