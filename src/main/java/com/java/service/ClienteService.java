/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.service;


import com.java.Model.entidades.Cliente;
import com.java.Model.entidades.Personal;

/**
 *
 * @author PCNEW
 */
public interface ClienteService extends EntidadService<Cliente, Integer>{
    Cliente validar(String user, String password);
   int mostrarIdCliente();
    Cliente mostrarClientePorDni(String dni);
    void actualizarSinDni(Cliente cliente);
    boolean cambiarEstado(Integer id,int estado);
}
