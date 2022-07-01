/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.service.impl;


import com.java.Model.dao.EspecialidadTecnicoDao;
import com.java.Model.dao.impl.DaoFactory;
import com.java.Model.entidades.EspecialidadTecnico;
import com.java.service.EspecialidadTecnicoService;

import java.util.List;


/**
 *
 * @author PCNEW
 */
public class EspecialidadTecnicoServiceImpl implements EspecialidadTecnicoService {

    EspecialidadTecnicoDao dao;

    public EspecialidadTecnicoServiceImpl() {

        DaoFactory fabrica = DaoFactory.getInstance();
        dao = fabrica.getEspecialidadTecnicoDao();
    }

    @Override
    public void insertar(EspecialidadTecnico t) {
        dao.create(t);

    }

    @Override
    public EspecialidadTecnico buscar(Integer v) {
        return dao.find(v);
    }

    @Override
    public List<EspecialidadTecnico> mostrar() {
        return dao.findAll();

    }

    @Override
    public void actualizar(EspecialidadTecnico t) {
      dao.update(t);
    }

    @Override
    public void eliminar(Integer v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
