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
public class TipoElectro {
   private Integer idTipoElectro;
   private String nombre;

    public TipoElectro() {
    }

    public TipoElectro(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdTipoElectro() {
        return idTipoElectro;
    }

    public void setIdTipoElectro(Integer idTipoElectro) {
        this.idTipoElectro = idTipoElectro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "TipoElectro{" + "idTipoElectro=" + idTipoElectro + ", nombre=" + nombre + '}';
    }
   
}
