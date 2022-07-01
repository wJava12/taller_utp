/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.service.impl;


import java.util.List;

import com.java.Model.dao.ElectrodomesticoDao;
import com.java.Model.dao.impl.DaoFactory;
import com.java.Model.entidades.Electrodomestico;
import com.java.service.ElectrodomesticoService;


/**
 *
 * @author PCNEW
 */
public class ElectrodomesticoServiceImpl implements ElectrodomesticoService {
    ElectrodomesticoDao dao;
    public ElectrodomesticoServiceImpl() {
        DaoFactory fabrica = DaoFactory.getInstance();
        dao = fabrica.getElectrodomesticoDao();
    }
    @Override
    public void insertar(Electrodomestico t) {
     dao.create(t);
    
    }

    @Override
    public Electrodomestico buscar(Integer v) {
            return dao.find(v);
    
    }

    @Override
    public List<Electrodomestico> mostrar() {
    
        return dao.findAll();
    }

    @Override
    public void actualizar(Electrodomestico t) {
    dao.update(t);
    
    }

    @Override
    public void eliminar(Integer v) {
    dao.delete(v);
    }

    @Override
    public int mostrarIdElectro() {
        return dao.idELectro();
    }
}
