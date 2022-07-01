package com.java.service.impl;


import java.util.List;

import com.java.Model.dao.HorarioDao;
import com.java.Model.dao.impl.DaoFactory;
import com.java.Model.entidades.Horario;
import com.java.service.HorarioService;



public class HorarioServiceImpl implements HorarioService {
    HorarioDao dao;
    public HorarioServiceImpl() {
        DaoFactory fabrica = DaoFactory.getInstance();
        dao = fabrica.getHorarioDao();
    }

    @Override
    public void insertar(Horario t) {
                dao.create(t);
     }

    @Override
    public Horario buscar(Integer v) {
        return dao.find(v);
    }

    @Override
    public List<Horario> mostrar() {
           return  dao.findAll();
    }

    @Override
    public void actualizar(Horario t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Integer v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Horario bucarPorNombre(String nombre) {
        return dao.findByNameHorario(nombre);
    }

    @Override
    public int mostrarIdHorario() {
        return dao.findIdHorario();
    }


}
