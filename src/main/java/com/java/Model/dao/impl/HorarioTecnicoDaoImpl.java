/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.Model.dao.impl;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.Model.dao.HorarioTecnicoDao;
import com.java.Model.entidades.HorarioTecnico;
import com.java.conexion.DBConn;
import com.java.service.HorarioService;
import com.java.service.TecnicoService;
import com.java.service.impl.HorarioServiceImpl;
import com.java.service.impl.TecnicoServiceImpl;


public class HorarioTecnicoDaoImpl implements HorarioTecnicoDao {

    private Connection con;
    private ResultSet rs;
    private CallableStatement cst;

    @Override
    public void create(HorarioTecnico t) {
        try {
            con = DBConn.getConnection();
            con.setAutoCommit(false);
            System.out.println(t);
            cst = con.prepareCall("{CALL sp_insertar_horarioTecnico(?,?,?)}");

            cst.setInt(1, t.getEstado());
            cst.setInt(2, t.getTecnico().getIdTecnico());
            cst.setInt(3, t.getHorario().getIdHorario());

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
    public HorarioTecnico find(Integer id) {
        HorarioTecnico horarioTecnico = null;
        TecnicoService tecnico = new TecnicoServiceImpl();
        HorarioService horario = new HorarioServiceImpl();
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_find_horarioTecnico(?)}");
            cst.setInt(1, id);
            rs = cst.executeQuery();
            if (rs.next()) {
                horarioTecnico = new HorarioTecnico();
                horarioTecnico.setIdHorarioTecnico(rs.getInt(1));
                horarioTecnico.setEstado(rs.getInt(2));
                horarioTecnico.setTecnico(tecnico.buscar(rs.getInt(3)));
                horarioTecnico.setHorario(horario.buscar(rs.getInt(4)));
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
        return horarioTecnico;

    }

    @Override
    public List<HorarioTecnico> findAll() {
        List<HorarioTecnico> lHorarios = new ArrayList<>();
        HorarioTecnico horarioTecnico = null;
        TecnicoService tecnico = new TecnicoServiceImpl();
        HorarioService horario = new HorarioServiceImpl();
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_mostrar_horarioTecnico()}");
            rs = cst.executeQuery();
            while (rs.next()) {
                horarioTecnico = new HorarioTecnico();
                horarioTecnico.setIdHorarioTecnico(rs.getInt(1));
                horarioTecnico.setEstado(rs.getInt(2));
                horarioTecnico.setTecnico(tecnico.buscar(rs.getInt(3)));
                horarioTecnico.setHorario(horario.buscar(rs.getInt(4)));

                lHorarios.add(horarioTecnico);
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
        return lHorarios;

    }

    @Override
    public void update(HorarioTecnico t) {
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_upd_horarioTecnico(?,?)}");
            cst.setInt(1, t.getIdHorarioTecnico());
            cst.setInt(2, t.getEstado());
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
