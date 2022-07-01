/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.Model.dao;


import com.java.Model.entidades.Cliente;
import com.java.Model.entidades.Tecnico;

/**
 *
 * @author PCNEW
 */
public interface TecnicoDao extends EntidadDao<Tecnico, Integer> {
    public boolean updateState(Integer id,int estado);
    boolean stateHorario(Integer id,int estado);
    int idTecnico();
    Tecnico findDni(String dni);
}
