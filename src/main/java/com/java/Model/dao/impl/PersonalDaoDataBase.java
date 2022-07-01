package com.java.Model.dao.impl;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.Model.dao.PersonalDao;
import com.java.Model.entidades.Personal;
import com.java.conexion.DBConn;
import com.java.service.CargoService;
import com.java.service.HorarioService;
import com.java.service.impl.CargoServiceImpl;
import com.java.service.impl.HorarioServiceImpl;


public class PersonalDaoDataBase implements PersonalDao {

    private Connection con;
    private ResultSet rs;
    private CallableStatement cst;

    @Override
    public Personal validarLogin(String us, String ps) {
        Personal administrador = null;
        CargoService cargo = new CargoServiceImpl();

        try {

            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_login(?,?)}");
            cst.setString(1, us);
            cst.setString(2, ps);
            rs = cst.executeQuery();
            if (rs.next()) {
                administrador = new Personal();
                administrador.setIdPersonal(rs.getInt(1));
                administrador.setNombre(rs.getString(2));
                administrador.setApellidos(rs.getString(3));
                administrador.setDireccion(rs.getString(4));
                administrador.setDni(rs.getString(5));
                administrador.setTelefono(rs.getString(6));
                administrador.setCorreo(rs.getString(7));
                administrador.setUsuario(rs.getString(8));
                administrador.setClave(rs.getString(9));
                administrador.setCargo(cargo.buscar(rs.getInt(10)));

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
        return administrador;
    }

    @Override
    public void create(Personal t) {
        try {
            con = DBConn.getConnection();
            con.setAutoCommit(false);
            System.out.println(t);
            cst = con.prepareCall("{CALL sp_insertar_personal(?,?,?,?,?,?,?,?,?,?)}");

            cst.setString(1, t.getNombre());
            cst.setString(2, t.getApellidos());
            cst.setString(3, t.getDireccion());
            cst.setString(4, t.getDni());
            cst.setString(5, t.getTelefono());
            cst.setString(6, t.getCorreo());
            cst.setString(7, t.getUsuario());
            cst.setString(8, t.getClave());
            cst.setInt(9, t.getEstado());
            cst.setInt(10, t.getCargo().getIdCargo());

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
    public Personal find(Integer id) {
        Personal personal = null;
        CargoService cargo = new CargoServiceImpl();
        HorarioService horario = new HorarioServiceImpl();
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_find_personal(?)}");
            cst.setInt(1, id);
            rs = cst.executeQuery();
            if (rs.next()) {
                personal = new Personal();
                personal.setIdPersonal(rs.getInt(1));
                personal.setNombre(rs.getString(2));
                personal.setApellidos(rs.getString(3));
                personal.setDireccion(rs.getString(4));
                personal.setDni(rs.getString(5));
                personal.setTelefono(rs.getString(6));
                personal.setCorreo(rs.getString(7));
                personal.setUsuario(rs.getString(8));
                personal.setClave(rs.getString(9));
                personal.setEstado(rs.getInt(10));
                personal.setCargo(cargo.buscar(rs.getInt(11)));

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
        return personal;
    }

    @Override
    public List<Personal> findAll() {
        List<Personal> lPersonal = new ArrayList<>();
        CargoService cargo = new CargoServiceImpl();

        Personal personal;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_mostrar_personal()}");
            rs = cst.executeQuery();
            while (rs.next()) {
                personal = new Personal();
                personal.setIdPersonal(rs.getInt(1));
                personal.setNombre(rs.getString(2));
                personal.setApellidos(rs.getString(3));
                personal.setDireccion(rs.getString(4));
                personal.setDni(rs.getString(5));
                personal.setTelefono(rs.getString(6));
                personal.setCorreo(rs.getString(7));
                personal.setUsuario(rs.getString(8));
                personal.setClave(rs.getString(9));
                personal.setEstado(rs.getInt(10));
                personal.setCargo(cargo.buscar(rs.getInt(11)));

                lPersonal.add(personal);
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
        return lPersonal;

    }

    @Override
    public void update(Personal t) {
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_upd_personal(?,?,?,?,?,?,?,?,?,?,?)}");
            cst.setInt(1, t.getIdPersonal());
            cst.setString(2, t.getNombre());
            cst.setString(3, t.getApellidos());
            cst.setString(4, t.getDireccion());
            cst.setString(5, t.getDni());
            cst.setString(6, t.getTelefono());
            cst.setString(7, t.getCorreo());
            cst.setString(8, t.getUsuario());
            cst.setString(9, t.getClave());
            cst.setInt(10, t.getEstado());
            cst.setInt(11, t.getCargo().getIdCargo());

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
    public void delete(Integer id) {
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_del_personal(?)}");
            cst.setInt(1, id);
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
    public boolean updateState(Integer id, int estado) {
        boolean band = true;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_upd_estadoPersonal(?,?)}");
            cst.setInt(1, id);
            cst.setInt(2, estado);

            cst.executeUpdate();
            cst.close();
            con.close();
        } catch (SQLException ex) {
            try {
                band = false;
                cst.close();
                con.close();
            } catch (SQLException ex1) {
                System.out.println(ex1);
            }
        }
        return band;
    }

    @Override
    public List<Personal> buscarLikeAp(String apellido) {
        List<Personal> lPersonal = new ArrayList<>();
        Personal personal;
        CargoService cargo = new CargoServiceImpl();
        HorarioService horario = new HorarioServiceImpl();
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_buscar_apPersonal(?)}");
            cst.setString(1, apellido);
            rs = cst.executeQuery();
            if (rs.next()) {
                personal = new Personal();
                personal.setIdPersonal(rs.getInt(1));
                personal.setNombre(rs.getString(2));
                personal.setApellidos(rs.getString(3));
                personal.setDireccion(rs.getString(4));
                personal.setDni(rs.getString(5));
                personal.setTelefono(rs.getString(6));
                personal.setCorreo(rs.getString(7));
                personal.setUsuario(rs.getString(8));
                personal.setClave(rs.getString(9));
                personal.setEstado(rs.getInt(10));
                personal.setCargo(cargo.buscar(rs.getInt(11)));

                lPersonal.add(personal);
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
        return lPersonal;
    }

}
