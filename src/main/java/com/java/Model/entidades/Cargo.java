/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.Model.entidades;

/**
 *
 * @author ASUS
 */
public class Cargo {
    private Integer idCargo;
    private String nombre;

    public Cargo() {
    }

    public Cargo(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cargo{" + "idCargo=" + idCargo + ", nombre=" + nombre + '}';
    }
    
    
    
}
