/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.service.impl;


import java.util.List;

import com.java.Model.dao.ServicioDao;
import com.java.Model.dao.impl.DaoFactory;
import com.java.Model.entidades.Servicio;
import com.java.service.ServicioService;


/**
 *
 * @author PCNEW
 */
public class ServicioServiceImpl implements ServicioService {

    ServicioDao dao;

    public ServicioServiceImpl() {

        DaoFactory fabrica = DaoFactory.getInstance();
        dao = fabrica.getServicioDao();
    }

    @Override
    public void insertar(Servicio t) {
        dao.create(t);
    }

    @Override
    public Servicio buscar(Integer v) {
        return dao.find(v);
    }

    @Override
    public List<Servicio> mostrar() {
        return dao.findAll();
    }

    @Override
    public void actualizar(Servicio t) {
    }

    @Override
    public void eliminar(Integer v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
