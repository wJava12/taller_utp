package com.java.service.impl;


import java.util.List;

import com.java.Model.dao.CargoDao;
import com.java.Model.dao.impl.DaoFactory;
import com.java.Model.entidades.Cargo;
import com.java.service.CargoService;



public class CargoServiceImpl implements CargoService {
    CargoDao dao;
    public CargoServiceImpl() {
        DaoFactory fabrica = DaoFactory.getInstance();
        dao = fabrica.getCargoDao();
    }

    @Override
    public void insertar(Cargo t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cargo buscar(Integer v) {
            return dao.find(v);   
    }

    @Override
    public List<Cargo> mostrar() {
    return  dao.findAll();
             }

    @Override
    public void actualizar(Cargo t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Integer v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cargo bucarPorNombre(String nombre) {
        return dao.findBYNombre(nombre);
    }
    
}
