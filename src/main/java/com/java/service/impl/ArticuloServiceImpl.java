/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.service.impl;

import java.util.List;

import com.java.Model.dao.ArticuloDao;
import com.java.Model.dao.impl.DaoFactory;
import com.java.Model.entidades.Articulo;
import com.java.service.ArticuloService;


/**
 *
 * @author PCNEW
 */
public class ArticuloServiceImpl implements ArticuloService {
    ArticuloDao dao;
    public ArticuloServiceImpl() {
        DaoFactory fabrica = DaoFactory.getInstance();
        dao = fabrica.getArticuloDao();
    }
    @Override
    public void insertar(Articulo t) {
    dao.create(t);
    }

    @Override
    public Articulo buscar(Integer v) {
    return dao.find(v); }

    @Override
    public List<Articulo> mostrar() {
    return dao.findAll();}

    @Override
    public void actualizar(Articulo t) {
        dao.update(t);
    }

    @Override
    public void eliminar(Integer v) {
            dao.delete(v);
    }
    
}
