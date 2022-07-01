/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.Model.dao.impl;


import com.java.Model.dao.EspecialidadDao;
import com.java.Model.entidades.Especialidad;
import com.java.conexion.DBConn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PCNEW
 */
public class EspecialidadDaoImpl implements EspecialidadDao {

    private Connection con;
    private ResultSet rs;
    private CallableStatement cst;

    @Override
    public void create(Especialidad t) {
        try {
            con = DBConn.getConnection();
            con.setAutoCommit(false);
            System.out.println(t);
            cst = con.prepareCall("{CALL sp_insertar_Especialidad(?)}");

            cst.setString(1, t.getNombre());

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
    public Especialidad find(Integer id) {
        Especialidad Especialidad = null;

        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_find_Especialidad(?)}");
            cst.setInt(1, id);
            rs = cst.executeQuery();
            if (rs.next()) {
                Especialidad = new Especialidad();
                Especialidad.setIdEspecialidad(rs.getInt(1));
                Especialidad.setNombre(rs.getString(2));


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
        return Especialidad;
    }

    @Override
    public List<Especialidad> findAll() {
        Especialidad Especialidad = null;
        List<Especialidad> lEspecialidad = new ArrayList<>();
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_mostrar_Especialidad()}");

            rs = cst.executeQuery();
            while (rs.next()) {
                Especialidad = new Especialidad();
                Especialidad.setIdEspecialidad(rs.getInt(1));
                Especialidad.setNombre(rs.getString(2));

                lEspecialidad.add(Especialidad);
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
        return lEspecialidad;
    }

    @Override
    public void update(Especialidad t) {
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_upd_Especialidad(?,?)}");
            cst.setInt(1, t.getIdEspecialidad());
            cst.setString(2, t.getNombre());

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
