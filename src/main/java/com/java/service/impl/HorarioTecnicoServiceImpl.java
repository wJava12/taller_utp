/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.service.impl;


import java.util.List;

import com.java.Model.dao.HorarioTecnicoDao;
import com.java.Model.dao.impl.DaoFactory;
import com.java.Model.entidades.HorarioTecnico;
import com.java.service.HorarioTecnicoService;


/**
 *
 * @author PCNEW
 */
public class HorarioTecnicoServiceImpl implements HorarioTecnicoService {

    HorarioTecnicoDao dao;

    public HorarioTecnicoServiceImpl() {

        DaoFactory fabrica = DaoFactory.getInstance();
        dao = fabrica.getHorarioTecnicoDao();
    }

    @Override
    public void insertar(HorarioTecnico t) {
        dao.create(t);

    }

    @Override
    public HorarioTecnico buscar(Integer v) {
        return dao.find(v);
    }

    @Override
    public List<HorarioTecnico> mostrar() {
        return dao.findAll();

    }

    @Override
    public void actualizar(HorarioTecnico t) {
      dao.update(t);
    }

    @Override
    public void eliminar(Integer v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
