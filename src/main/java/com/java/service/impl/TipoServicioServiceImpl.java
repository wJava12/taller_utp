/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.service.impl;

import java.util.List;

import com.java.Model.dao.TipoServicioDao;
import com.java.Model.dao.impl.DaoFactory;
import com.java.Model.entidades.TipoServicio;
import com.java.service.TipoServicioService;


public class TipoServicioServiceImpl implements TipoServicioService {

    TipoServicioDao dao;

    public TipoServicioServiceImpl() {

        DaoFactory fabrica = DaoFactory.getInstance();
        dao = fabrica.getTipoServicioDao();
    }

    @Override
    public void insertar(TipoServicio t) {
        dao.create(t);
    }

    @Override
    public TipoServicio buscar(Integer v) {
        return dao.find(v);
    }

    @Override
    public List<TipoServicio> mostrar() {
        return dao.findAll();
    }

    @Override
    public void actualizar(TipoServicio t) {
        dao.update(t);
    }

    @Override
    public void eliminar(Integer v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
