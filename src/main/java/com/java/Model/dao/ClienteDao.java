/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.Model.dao;


import com.java.Model.entidades.Cliente;
import com.java.Model.entidades.Personal;

/**
 *
 * @author PCNEW
 */
public interface ClienteDao extends EntidadDao<Cliente,Integer> {

    Cliente validarLogin(String us, String ps);
    int idCliente();
    Cliente findDni(String dni);
    void updateNotDni(Cliente cliente);
    boolean updateState(Integer id,int estado);
}
