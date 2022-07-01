/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.Model.dao.impl;


import com.java.Model.dao.EspecialidadTecnicoDao;
import com.java.Model.entidades.EspecialidadTecnico;
import com.java.conexion.DBConn;
import com.java.service.EspecialidadService;
import com.java.service.HorarioService;
import com.java.service.TecnicoService;
import com.java.service.impl.EspecialidadServiceImpl;
import com.java.service.impl.HorarioServiceImpl;
import com.java.service.impl.TecnicoServiceImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EspecialidadTecnicoDaoImpl implements EspecialidadTecnicoDao {

    private Connection con;
    private ResultSet rs;
    private CallableStatement cst;

    @Override
    public void create(EspecialidadTecnico t) {
        try {
            con = DBConn.getConnection();
            con.setAutoCommit(false);
            System.out.println(t);
            cst = con.prepareCall("{CALL sp_insertar_EspecialidadTecnico(?,?)}");

            cst.setInt(1, t.getEspecialidad().getIdEspecialidad());
            cst.setInt(2, t.getTecnico().getIdTecnico());
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
    public EspecialidadTecnico find(Integer id) {
        EspecialidadTecnico EspecialidadTecnico = null;
        TecnicoService tecnico = new TecnicoServiceImpl();
        EspecialidadService especialidad = new EspecialidadServiceImpl();
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_find_EspecialidadTecnico(?)}");
            cst.setInt(1, id);
            rs = cst.executeQuery();
            if (rs.next()) {
                EspecialidadTecnico = new EspecialidadTecnico();
                EspecialidadTecnico.setIdEspecialidadTecnico(rs.getInt(1));
                EspecialidadTecnico.setTecnico(tecnico.buscar(rs.getInt(2)));
                EspecialidadTecnico.setEspecialidad(especialidad.buscar(rs.getInt(3)));
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
        return EspecialidadTecnico;

    }

    @Override
    public List<EspecialidadTecnico> findAll() {
        List<EspecialidadTecnico> lTecnicos = new ArrayList<>();
        EspecialidadTecnico especialidadTecnico = null;
        TecnicoService tecnico = new TecnicoServiceImpl();
        EspecialidadService especialidad = new EspecialidadServiceImpl();
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_mostrar_EspecialidadTecnico()}");
            rs = cst.executeQuery();
            while (rs.next()) {
                especialidadTecnico = new EspecialidadTecnico();
                especialidadTecnico.setIdEspecialidadTecnico(rs.getInt(1));
                especialidadTecnico.setEspecialidad(especialidad.buscar(rs.getInt(2)));
                especialidadTecnico.setTecnico(tecnico.buscar(rs.getInt(3)));
                System.out.println();

                lTecnicos.add(especialidadTecnico);
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
        return lTecnicos;

    }

    @Override
    public void update(EspecialidadTecnico t) {
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_upd_EspecialidadTecnico(?,?)}");
            cst.setInt(1, t.getTecnico().getIdTecnico());
            cst.setInt(2, t.getEspecialidad().getIdEspecialidad());
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
        } }

    @Override
    public void delete(Integer v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
