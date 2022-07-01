/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.service.impl;


import com.java.Model.dao.TecnicoDao;
import com.java.Model.dao.impl.DaoFactory;
import com.java.Model.entidades.Tecnico;
import com.java.service.TecnicoService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


/**
 *
 * @author PCNEW
 */
public class TecnicoServiceImpl implements TecnicoService {

    
    TecnicoDao dao;
    public TecnicoServiceImpl() {
        
        DaoFactory fabrica = DaoFactory.getInstance();
        dao = fabrica.getTecnicoDao();
    }
    @Override
    public void insertar(Tecnico t) {
        dao.create(t);
    
    }

    @Override
    public Tecnico buscar(Integer v) {
    return dao.find(v);
       }

    @Override
    public List<Tecnico> mostrar() {
     return dao.findAll(); }

    @Override
    public void actualizar(Tecnico t) {
     dao.update(t);}

    @Override
    public void eliminar(Integer v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean cambiarEstado(Integer id,int estado) {  
    return dao.updateState(id, estado);
    }

    @Override
    public boolean cambiarEstadoTecnico(Integer id, int estado) {
        return dao.stateHorario(id,estado);
    }

    @Override
    public int mostrarIdTecnico() {
        return dao.idTecnico();
    }

    @Override
    public Tecnico buscarPorDni(String dni) {
        Tecnico tecnico=dao.findDni(dni);
        return (tecnico!=null)?tecnico:new Tecnico();
    }


}
