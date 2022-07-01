/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.service.impl;


import java.util.List;

import com.java.Model.dao.ClienteDao;
import com.java.Model.dao.impl.DaoFactory;
import com.java.Model.entidades.Cliente;
import com.java.service.ClienteService;


/**
 *
 * @author PCNEW
 */
public class ClienteServiceImpl implements ClienteService {
    ClienteDao dao;
    public ClienteServiceImpl() {
        DaoFactory fabrica = DaoFactory.getInstance();
        dao = fabrica.getClienteDao();
    }
    @Override
    public void insertar(Cliente t) {
        dao.create(t);
    
    }

    @Override
    public Cliente buscar(Integer v) {
    return dao.find(v);
    
    }

    @Override
    public List<Cliente> mostrar() {
        return dao.findAll();
    }

    @Override
    public void actualizar(Cliente t) {
    dao.update(t);
    
    }

    @Override
    public void eliminar(Integer v) {
    dao.delete(v);
    }

    @Override
    public Cliente validar(String user, String password) {
        return dao.validarLogin(user,password);
    }

    @Override
    public int mostrarIdCliente() {
        return dao.idCliente();
    }

    @Override
    public Cliente mostrarClientePorDni(String dni) {
       return dao.findDni(dni);
    }

    @Override
    public void actualizarSinDni(Cliente cliente) {
        dao.updateNotDni(cliente);
    }

    @Override
    public boolean cambiarEstado(Integer id, int estado) {
        return dao.updateState(id, estado);
    }
}
