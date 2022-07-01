/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.service;


import com.java.Model.entidades.Tecnico;

/**
 *
 * @author PCNEW
 */
public interface TecnicoService extends EntidadService<Tecnico, Integer> {
   boolean cambiarEstado(Integer id,int estado);
    boolean cambiarEstadoTecnico(Integer id,int estado);
    int mostrarIdTecnico();
    Tecnico buscarPorDni(String dni);
}
