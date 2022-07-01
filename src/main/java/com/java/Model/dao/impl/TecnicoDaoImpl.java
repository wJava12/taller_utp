/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.Model.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.java.Model.dao.TecnicoDao;
import com.java.Model.entidades.Tecnico;
import com.java.conexion.DBConn;
import com.java.service.CargoService;
import com.java.service.impl.CargoServiceImpl;

/**
 *
 * @author PCNEW
 */
public class TecnicoDaoImpl implements TecnicoDao {
    
    private Connection con;
    private ResultSet rs;
    private CallableStatement cst;
    @Override
    public void create(Tecnico t) {
    try {            
           con = DBConn.getConnection();
       con.setAutoCommit(false); 
           System.out.println(t);
       cst = con.prepareCall("{CALL sp_insertar_tecnico(?,?,?,?,?,?,?,?,?,?,?)}");
           
       cst.setString(1,t.getNombre());
       cst.setString(2,t.getApellido());
        cst.setString(3,t.getDni());
       cst.setString(4,t.getTelefono());
       cst.setString(5,t.getCorreo());

       cst.setString(6,t.getExperiencia());
       
       cst.setInt(7,t.getEstado());
       cst.setInt(8,t.getEstadoEliminado());
       cst.setString(9,t.getUsuario());
       cst.setString(10,t.getClave());
       cst.setInt(11,t.getCargo().getIdCargo());
       cst.executeUpdate();           
       //delete(null);            
       con.commit();            
       cst.close();            
       con.close();            
       System.out.println("grabo con callablestatement");        
    }catch(SQLException | NullPointerException ex){           
    try {                
        con.rollback();               
        cst.close();                
        con.close();            
    } catch (SQLException ex1) {       
        System.out.println(ex1);            
    }        
    }}

    @Override
    public Tecnico find(Integer id) {
    Tecnico tecnico = null;
    CargoService cargo= new CargoServiceImpl();
        try{
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_find_tecnico(?)}");
            cst.setInt(1,id);
            rs = cst.executeQuery();
            if(rs.next()){
                tecnico=new Tecnico();
                tecnico.setIdTecnico(rs.getInt(1));
             tecnico.setNombre(rs.getString(2));
             tecnico.setApellido(rs.getString(3));
                tecnico.setDni(rs.getString(4));
              tecnico.setTelefono(rs.getString(5));
             tecnico.setCorreo(rs.getString(6));
                      tecnico.setExperiencia(rs.getString(7));
             tecnico.setEstado(rs.getInt(8));
              tecnico.setEstadoEliminado(rs.getInt(9));
              tecnico.setUsuario(rs.getString(10));
              tecnico.setClave(rs.getString(11));
             tecnico.setCargo(cargo.buscar(rs.getInt(12)));
             
            }
            rs.close();
            cst.close();
            con.close();
        }catch(SQLException ex){
            try {
                rs.close();
                cst.close();
                con.close();
            } catch (SQLException ex1) {
                System.out.println(ex1);
            }
        }
        return tecnico;
    }

    @Override
    public List<Tecnico> findAll() {
      List<Tecnico> lTecnico = new ArrayList<>();
     CargoService cargo= new CargoServiceImpl();
     Tecnico tecnico;
     
     try {
         con = DBConn.getConnection(); 
         cst = con.prepareCall("{CALL sp_mostrar_tecnico()}");
         rs = cst.executeQuery();              
         while(rs.next()){
             tecnico=new Tecnico();
             tecnico.setIdTecnico(rs.getInt(1));
             tecnico.setNombre(rs.getString(2));
             tecnico.setApellido(rs.getString(3));
             tecnico.setDni(rs.getString(4));
             tecnico.setTelefono(rs.getString(5));
             tecnico.setCorreo(rs.getString(6));

             tecnico.setExperiencia(rs.getString(7));
             tecnico.setEstado(rs.getInt(8));
             tecnico.setEstadoEliminado(rs.getInt(9));
             tecnico.setUsuario(rs.getString(10));
             tecnico.setClave(rs.getString(11));
             tecnico.setCargo(cargo.buscar(rs.getInt(12)));
             lTecnico.add(tecnico);            
         }rs.close();            
         cst.close();
         con.close();
     
     }catch(SQLException ex){
         try {                
             rs.close(); 
             cst.close();  
             con.close();  
         } catch (SQLException ex1) { 
             System.out.println(ex1);
         }        }
     return lTecnico;  }

    @Override
    public void update(Tecnico t) {
   try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_upd_tecnico(?,?,?,?,?,?,?,?,?,?,?,?)}");
       cst.setInt(1,t.getIdTecnico());     
       cst.setString(2,t.getNombre());
       cst.setString(3,t.getApellido());
       cst.setString(4,t.getDni());
       cst.setString(5,t.getTelefono());
       cst.setString(6,t.getCorreo());

       cst.setString(7,t.getExperiencia());
       cst.setInt(8,t.getEstado());
       cst.setInt(9,t.getEstadoEliminado());
       
        cst.setString(10,t.getUsuario());
       cst.setString(11,t.getClave());
       cst.setInt(12,t.getCargo().getIdCargo());
            cst.executeUpdate();
            cst.close();
            con.close();
        }catch(SQLException ex){
            try {
                cst.close();
                con.close();
            } catch (SQLException ex1) {
                System.out.println(ex1);
            }
        } }

    @Override
    public void delete(Integer v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateState(Integer id, int estado) {
      boolean band=true;
    try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_upd_estadoTecnico(?,?)}");
       cst.setInt(1,id);     
       cst.setInt(2,estado);

            cst.executeUpdate();
            cst.close();
            con.close();
        }catch(SQLException ex){
            try {
                band=false;
                cst.close();
                con.close();
            } catch (SQLException ex1) {
                System.out.println(ex1);
            }
        }
    return band; }

    @Override
    public boolean stateHorario(Integer id, int estado) {
        boolean band=true;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_upd_estado2Tecnico(?,?)}");
            cst.setInt(1,id);
            cst.setInt(2,estado);

            cst.executeUpdate();
            cst.close();
            con.close();
        }catch(SQLException ex){
            try {
                band=false;
                cst.close();
                con.close();
            } catch (SQLException ex1) {
                System.out.println(ex1);
            }
        }
        return band;
    }

    @Override
    public int idTecnico() {
        int id=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_mostrar_idTecnico()}");
            rs = cst.executeQuery();
            if(rs.next()){
                id=rs.getInt(1);
            }
            rs.close();
            cst.close();
            con.close();
        }catch(SQLException ex){
            try {
                rs.close();
                cst.close();
                con.close();
            } catch (SQLException ex1) {
                System.out.println(ex1);
            }        }
        return id;
    }

    @Override
    public Tecnico findDni(String dni) {
        Tecnico tecnico = null;
        CargoService cargo= new CargoServiceImpl();

        try{
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_find_dniTecnico(?)}");
            cst.setString(1,dni);
            rs = cst.executeQuery();
            if(rs.next()){
                tecnico=new Tecnico();
                tecnico.setIdTecnico(rs.getInt(1));
                tecnico.setNombre(rs.getString(2));
                tecnico.setApellido(rs.getString(3));
                tecnico.setDni(rs.getString(4));
                tecnico.setTelefono(rs.getString(5));
                tecnico.setCorreo(rs.getString(6));

                tecnico.setExperiencia(rs.getString(7));
                tecnico.setEstado(rs.getInt(8));
                tecnico.setEstadoEliminado(rs.getInt(9));
                tecnico.setUsuario(rs.getString(10));
                tecnico.setClave(rs.getString(11));
                tecnico.setCargo(cargo.buscar(rs.getInt(12)));
            }
            rs.close();
            cst.close();
            con.close();
            System.out.println("Busco correctamente");
        }
        catch (SQLIntegrityConstraintViolationException e){
            System.out.println("Dni duplicado: "+e);
            return null;

        }

        catch(SQLException ex){
            try {
                rs.close();
                cst.close();
                con.close();
            } catch (SQLException ex1) {
                System.out.println(ex1);
            }
        }
        return tecnico;
    }

}
