/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.service.impl;

import com.java.Model.dao.EspecialidadDao;
import com.java.Model.dao.impl.DaoFactory;
import com.java.Model.entidades.Especialidad;
import com.java.service.EspecialidadService;

import java.util.List;


public class EspecialidadServiceImpl implements EspecialidadService {

    EspecialidadDao dao;

    public EspecialidadServiceImpl() {

        DaoFactory fabrica = DaoFactory.getInstance();
        dao = fabrica.getEspecialidadDao();
    }

    @Override
    public void insertar(Especialidad t) {
        dao.create(t);
    }

    @Override
    public Especialidad buscar(Integer v) {
        return dao.find(v);
    }

    @Override
    public List<Especialidad> mostrar() {
        return dao.findAll();
    }

    @Override
    public void actualizar(Especialidad t) {
        dao.update(t);
    }

    @Override
    public void eliminar(Integer v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
