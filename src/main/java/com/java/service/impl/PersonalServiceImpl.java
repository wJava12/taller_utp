package com.java.service.impl;


import java.util.List;

import com.java.Model.dao.PersonalDao;
import com.java.Model.dao.impl.DaoFactory;
import com.java.Model.entidades.Personal;
import com.java.service.PersonalService;



public class PersonalServiceImpl implements PersonalService {
    PersonalDao dao;
    public PersonalServiceImpl() {
        
        DaoFactory fabrica = DaoFactory.getInstance();
        dao = fabrica.getPersonalDao();
    }
    @Override
    public Personal validar(String user, String password) {
        return dao.validarLogin(user,password);
    }

    @Override
    public void insertar(Personal t) {
   
    dao.create(t);
    }

    @Override
    public Personal buscar(Integer v) {
    return dao.find(v);
    }

    @Override
    public List<Personal> mostrar() {
   
    return dao.findAll();
    }

    @Override
    public void actualizar(Personal t) {
     dao.update(t);
    }

    @Override
    public void eliminar(Integer v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean cambiarEstado(Integer id,int estado) {  
    return dao.updateState(id, estado);
    }

    @Override
    public List<Personal> buscarPorApellido(String apellido) {
        return dao.buscarLikeAp(apellido);
    
    }
}
