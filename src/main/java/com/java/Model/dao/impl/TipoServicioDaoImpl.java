/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.Model.dao.impl;


import com.java.Model.dao.TipoServicioDao;
import com.java.Model.entidades.TipoServicio;
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
public class TipoServicioDaoImpl implements TipoServicioDao {

    private Connection con;
    private ResultSet rs;
    private CallableStatement cst;

    @Override
    public void create(TipoServicio t) {
        try {
            con = DBConn.getConnection();
            con.setAutoCommit(false);
            System.out.println(t);
            cst = con.prepareCall("{CALL sp_insertar_tipoServicio(?,?)}");

            cst.setString(1, t.getNombre());
            cst.setDouble(1, t.getPrecio());
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
    public TipoServicio find(Integer id) {
        TipoServicio tipoServicio = null;

        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_find_tipoServicio(?)}");
            cst.setInt(1, id);
            rs = cst.executeQuery();
            if (rs.next()) {
                tipoServicio = new TipoServicio();
                tipoServicio.setIdTipoServicio(rs.getInt(1));
                tipoServicio.setNombre(rs.getString(2));
                tipoServicio.setPrecio(rs.getDouble(3));

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
        return tipoServicio;
    }

    @Override
    public List<TipoServicio> findAll() {
        TipoServicio tipoServicio = null;
        List<TipoServicio> lTipoServicio = new ArrayList<>();
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_mostrar_tipoServicio()}");

            rs = cst.executeQuery();
            while (rs.next()) {
                tipoServicio = new TipoServicio();
                tipoServicio.setIdTipoServicio(rs.getInt(1));
                tipoServicio.setNombre(rs.getString(2));
                tipoServicio.setPrecio(rs.getDouble(3));
                lTipoServicio.add(tipoServicio);
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
        return lTipoServicio;
    }

    @Override
    public void update(TipoServicio t) {
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_upd_tipoServicio(?,?,?)}");
            cst.setInt(1, t.getIdTipoServicio());
            cst.setString(2, t.getNombre());
            cst.setDouble(3, t.getPrecio());
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
