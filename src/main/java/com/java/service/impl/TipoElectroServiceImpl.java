/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.service.impl;


import java.util.List;

import com.java.Model.dao.TIpoElectroDao;
import com.java.Model.dao.impl.DaoFactory;
import com.java.Model.entidades.TipoElectro;
import com.java.service.TipoElectroService;


/**
 *
 * @author PCNEW
 */
public class TipoElectroServiceImpl implements TipoElectroService {
    TIpoElectroDao dao;
    public TipoElectroServiceImpl() {
        
        DaoFactory fabrica = DaoFactory.getInstance();
        dao = fabrica.getElectroDao();
    }
    @Override
    public void insertar(TipoElectro t) {
     dao.create(t);
    }

    @Override
    public TipoElectro buscar(Integer v) {
    return dao.find(v);
    }

    @Override
    public List<TipoElectro> mostrar() {
    return dao.findAll();
            }

    @Override
    public void actualizar(TipoElectro t) {
    dao.update(t);
    }

    @Override
    public void eliminar(Integer v) {
    dao.delete(v);
    }
    
}
