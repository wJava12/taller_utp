/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.service.impl;


import com.java.Model.dao.ProgramacionHorarioDao;
import com.java.Model.dao.impl.DaoFactory;
import com.java.Model.entidades.ProgramacionHorario;
import com.java.service.ProgramacionHorarioService;

import java.util.List;



public class ProgramacionHorarioServiceImpl implements ProgramacionHorarioService {
    ProgramacionHorarioDao dao;
    public ProgramacionHorarioServiceImpl() {
        
        DaoFactory fabrica = DaoFactory.getInstance();
        dao = fabrica.getProgramacionHorarioDao();
    }
    @Override
    public void insertar(ProgramacionHorario t) {
        dao.create(t);
    
    }

    @Override
    public ProgramacionHorario buscar(Integer v) {
    return dao.find(v);
    }

    @Override
    public List<ProgramacionHorario> mostrar() {
    return dao.findAll();
    }

    @Override
    public void actualizar(ProgramacionHorario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
