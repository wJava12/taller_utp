/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.Model.dao.impl;


import com.java.Model.dao.ServicioDao;
import com.java.Model.entidades.Electrodomestico;
import com.java.Model.entidades.Servicio;
import com.java.conexion.DBConn;
import com.java.service.*;
import com.java.service.impl.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author PCNEW
 */
public class ServicioDaoImpl implements ServicioDao {

    private Connection con;
    private ResultSet rs;
    private CallableStatement cst;

    @Override
    public void create(Servicio t) {
        try {
            System.out.println("servicio: "+t);
            con = DBConn.getConnection();
            con.setAutoCommit(false);
            System.out.println(t);
            cst = con.prepareCall("{CALL sp_insertar_servicio(?,?,?,?,?,?,?,?,?,?)}");

            cst.setString(1, t.getFecha());
            cst.setString(2, t.getHora());
            cst.setDouble(3, t.getMonto());
            cst.setString(4, t.getDescripcion());
            cst.setInt(5, t.getEstado());
            cst.setString(6, t.getModalidad());
            cst.setInt(7, t.getElectrodomestico().getIdElectr());
            cst.setInt(8, t.getPersonal().getIdPersonal());
            cst.setInt(9, t.getHorarioTecnico().getIdHorarioTecnico());
            cst.setInt(10, t.getTipo().getIdTipoServicio());

            cst.executeUpdate();
            //delete(null);            
            con.commit();
            cst.close();
            con.close();
            System.out.println("grabo con callablestatement");
        } catch (SQLException | NullPointerException ex) {
            try {
                con.rollback();
                cst.close();
                con.close();
            } catch (SQLException ex1) {
                System.out.println(ex1);
            }
        }
    }

    @Override
    public Servicio find(Integer id) {
        Servicio servicio = null;
        ClienteService cliente = new ClienteServiceImpl();
        ElectrodomesticoService electro= new ElectrodomesticoServiceImpl();
        PersonalService personal = new PersonalServiceImpl();
        TipoServicioService tipoServicio = new TipoServicioServiceImpl();
        HorarioTecnicoService horarioTecnico = new HorarioTecnicoServiceImpl();
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_find_servicio(?)}");
            cst.setInt(1, id);
            rs = cst.executeQuery();
            if (rs.next()) {
                servicio = new Servicio();
                servicio.setIdServicio(rs.getInt(1));
                servicio.setFecha(rs.getString(2));
                servicio.setHora(rs.getString(3));
                servicio.setMonto(rs.getDouble(4));
                servicio.setDescripcion(rs.getString(5));
                servicio.setEstado(rs.getInt(6));
                servicio.setModalidad(rs.getString(7));
                servicio.setElectrodomestico(electro.buscar(rs.getInt(8)));
                servicio.setPersonal(personal.buscar(rs.getInt(9)));
                servicio.setTipo(tipoServicio.buscar(rs.getInt(10)));
                servicio.setHorarioTecnico(horarioTecnico.buscar(rs.getInt(11)));

            }
            rs.close();
            cst.close();
            con.close();
        } catch (SQLException ex) {
            try {
                rs.close();
                cst.close();
                con.close();
            } catch (SQLException ex1) {
                System.out.println(ex1);
            }
        }
        return servicio;
    }

    @Override
    public List<Servicio> findAll() {
        List<Servicio> lServicio = new ArrayList<>();
        Servicio servicio;

        ClienteService cliente = new ClienteServiceImpl();
        ElectrodomesticoService electro= new ElectrodomesticoServiceImpl();
        PersonalService personal = new PersonalServiceImpl();
        TipoServicioService tipoServicio = new TipoServicioServiceImpl();
        HorarioTecnicoService horarioTecnico = new HorarioTecnicoServiceImpl();
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_mostrar_servicio()}");
            rs = cst.executeQuery();
            while (rs.next()) {
                servicio = new Servicio();
                servicio.setIdServicio(rs.getInt(1));
                servicio.setFecha(rs.getString(2));
                servicio.setHora(rs.getString(3));
                servicio.setMonto(rs.getDouble(4));
                servicio.setDescripcion(rs.getString(5));
                servicio.setEstado(rs.getInt(6));
                servicio.setModalidad(rs.getString(7));
                servicio.setElectrodomestico(electro.buscar(rs.getInt(8)));
                servicio.setPersonal(personal.buscar(rs.getInt(9)));
                servicio.setHorarioTecnico(horarioTecnico.buscar(rs.getInt(10)));
                servicio.setTipo(tipoServicio.buscar(rs.getInt(11)));

                
                System.out.println(servicio);
                lServicio.add(servicio);

            }
            rs.close();
            cst.close();
            con.close();
        } catch (SQLException ex) {
            try {
                rs.close();
                cst.close();
                con.close();
            } catch (SQLException ex1) {
                System.out.println(ex1);
            }
        }

        return lServicio;
    }

    @Override
    public void update(Servicio t) {

        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_upd_servicio(?,?,?,?,?,?,?,?,?,?,?)}");
            cst.setInt(1, t.getIdServicio());
            cst.setString(2, t.getFecha());
            cst.setString(3, t.getHora());
            cst.setDouble(4, t.getMonto());
            cst.setString(5, t.getDescripcion());
            cst.setInt(6, t.getEstado());
            cst.setString(7, t.getModalidad());
            cst.setInt(8, t.getElectrodomestico().getIdElectr());
            cst.setInt(9, t.getPersonal().getIdPersonal());
            cst.setInt(10, t.getTipo().getIdTipoServicio());
            cst.setInt(11, t.getHorarioTecnico().getIdHorarioTecnico());

            cst.executeUpdate();
            cst.close();
            con.close();
        } catch (SQLException ex) {
            try {
                cst.close();
                con.close();
            } catch (SQLException ex1) {
                System.out.println(ex1);
            }
        }

    }

    @Override
    public void delete(Integer v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
