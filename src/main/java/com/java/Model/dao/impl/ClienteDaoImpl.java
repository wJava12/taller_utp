/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.Model.dao.impl;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.Model.dao.ClienteDao;
import com.java.Model.entidades.Cliente;
import com.java.Model.entidades.Personal;
import com.java.conexion.DBConn;
import com.java.service.CargoService;
import com.java.service.ElectrodomesticoService;
import com.java.service.impl.CargoServiceImpl;
import com.java.service.impl.ElectrodomesticoServiceImpl;

/**
 *
 * @author PCNEW
 */
public class ClienteDaoImpl implements ClienteDao {
    private Connection con;
    private ResultSet rs;
    private CallableStatement cst;
    @Override
    public void create(Cliente t) {
     try {            
           con = DBConn.getConnection();
       con.setAutoCommit(false); 
           System.out.println(t);
       cst = con.prepareCall("{CALL sp_insertar_cliente(?,?,?,?,?,?,?,?,?,?)}");
           
       cst.setString(1,t.getNombre());
       cst.setString(2,t.getApelldos());
         cst.setString(3,t.getDni());
       cst.setString(4,t.getDireccion());
       //cst.setString(4,t.getDni());
       cst.setString(5,t.getTelefono());
       cst.setString(6,t.getCorreo());
        cst.setString(7,t.getUsuario());
         cst.setString(8,t.getClave());
         cst.setInt(9,t.getEstado());
         cst.setInt(10,t.getCargo().getIdCargo());
       //cst.setInt(6,t.getElectrodomestico().getIdElectr());
 
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
    } 
    
    
    }

    @Override
    public Cliente find(Integer id) {
     Cliente cliente = null;

        
        try{
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_find_cliente(?)}");
            cst.setInt(1,id);
            rs = cst.executeQuery();
            if(rs.next()){
                cliente=new Cliente();
                cliente.setIdCLiente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApelldos(rs.getString(3));
                cliente.setDni(rs.getString(4));
                cliente.setDireccion(rs.getString(5));
                cliente.setTelefono(rs.getString(6));
                cliente.setCorreo(rs.getString(7));
                cliente.setUsuario(rs.getString(8));
                cliente.setClave(rs.getString(9));
                //cliente.setElectrodomestico(electrodomestico.buscar(rs.getInt(7)));
            
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
        return cliente;
    
    }

    @Override
    public List<Cliente> findAll() {
    List<Cliente> lCliente = new ArrayList<>();

     Cliente cliente;        
     try {
         con = DBConn.getConnection(); 
         cst = con.prepareCall("{CALL sp_mostrar_cliente()}");
         rs = cst.executeQuery();              
         while(rs.next()){
             System.out.println("::");
             cliente=new Cliente();               
             cliente.setIdCLiente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApelldos(rs.getString(3));
             cliente.setDni(rs.getString(4));
                cliente.setDireccion(rs.getString(5));
                cliente.setTelefono(rs.getString(6));
             cliente.setCorreo(rs.getString(7));
             cliente.setUsuario(rs.getString(8));
             cliente.setClave(rs.getString(9));
             cliente.setEstado(rs.getInt(10));
             lCliente.add(cliente);
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
     return lCliente;   }

    @Override
    public void update(Cliente t) {
   try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_upd_cliente(?,?,?,?,?,?,?,?,?)}");
       cst.setInt(1,t.getIdCLiente());     
       cst.setString(2,t.getNombre());
       cst.setString(3,t.getApelldos());
       cst.setString(4,t.getDni());
       cst.setString(5,t.getDireccion());
       cst.setString(6,t.getTelefono());
       cst.setString(7,t.getCorreo());
       cst.setString(8,t.getUsuario());
       cst.setString(9,t.getClave());
      // cst.setInt(7,t.getElectrodomestico().getIdElectr());
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
        }}

    @Override
    public void delete(Integer v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente validarLogin(String us, String ps) {
        Cliente cliente = null;
        CargoService cargo = new CargoServiceImpl();

        try {

            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_login_cliente(?,?)}");
            cst.setString(1, us);
            cst.setString(2, ps);
            rs = cst.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCLiente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApelldos(rs.getString(3));
                cliente.setDni(rs.getString(4));
                cliente.setDireccion(rs.getString(5));
                cliente.setTelefono(rs.getString(6));
                cliente.setCorreo(rs.getString(7));
                cliente.setUsuario(rs.getString(8));
                cliente.setClave(rs.getString(9));
                cliente.setEstado(rs.getInt(10));
                cliente.setCargo(cargo.buscar(rs.getInt(11)));
                System.out.println(cliente);
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
        return cliente;
    }

    @Override
    public int idCliente() {
        int id=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_mostrar_idCliente()}");
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
    public Cliente findDni(String dni) {
        Cliente cliente = null;
        CargoService cargo= new CargoServiceImpl();

        try{
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_find_dniCliente(?)}");
            cst.setString(1,dni);
            rs = cst.executeQuery();
            if(rs.next()){
                cliente=new Cliente();
                cliente.setIdCLiente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApelldos(rs.getString(3));
                cliente.setDni(rs.getString(4));
                cliente.setDireccion(rs.getString(5));
                cliente.setTelefono(rs.getString(6));
                cliente.setCorreo(rs.getString(7));
                cliente.setUsuario(rs.getString(8));
                cliente.setClave(rs.getString(9));
                cliente.setEstado(rs.getInt(10));
                cliente.setCargo(cargo.buscar(rs.getInt(11)));
                //cliente.setElectrodomestico(electrodomestico.buscar(rs.getInt(7)));
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
        return cliente;
}

    @Override
    public void updateNotDni(Cliente t) {
        System.out.println(t);
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_upd_sinDnicliente(?,?,?,?,?,?,?,?)}");
            cst.setInt(1,t.getIdCLiente());
            cst.setString(2,t.getNombre());
            cst.setString(3,t.getApelldos());
            cst.setString(4,t.getDireccion());
            cst.setString(5,t.getTelefono());
            cst.setString(6,t.getCorreo());
            cst.setString(7,t.getUsuario());
            cst.setString(8,t.getClave());
            // cst.setInt(7,t.getElectrodomestico().getIdElectr());
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
        }

    }

    @Override
    public boolean updateState(Integer id, int estado) {
        boolean band = true;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_upd_estadoCliente(?,?)}");
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

}
