/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.Model.dao.impl;


import com.java.Model.dao.CargoDao;
import com.java.Model.entidades.Cargo;
import com.java.conexion.DBConn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CargoDaoImpl implements CargoDao
{

    private Connection con;
    private ResultSet rs;
    private CallableStatement cst;
    @Override
    public void create(Cargo t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cargo find(Integer id) {
      
    Cargo cargo = null;       
    try{   
        con = DBConn.getConnection();
        cst = con.prepareCall("{CALL sp_buscar_cargo(?)}");
        cst.setInt(1,id);
        rs = cst.executeQuery();
        if(rs.next()){
            cargo=new Cargo();
            cargo.setIdCargo(rs.getInt(1)); 
            cargo.setNombre(rs.getString(2)); 
           ; 
        }            rs.close(); 
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
    return cargo;
    }

    @Override
    public List<Cargo> findAll() {
      List<Cargo> lcargo = new ArrayList<>();
     
     Cargo cargo;        
     try {
         con = DBConn.getConnection(); 
         cst = con.prepareCall("{CALL sp_mostrar_cargo()}");
         rs = cst.executeQuery();              
         while(rs.next()){
             cargo=new Cargo();               
             cargo.setIdCargo(rs.getInt(1));
             cargo.setNombre(rs.getString(2));
           
             lcargo.add(cargo);            
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
     return lcargo;  }

    @Override
    public void update(Cargo t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cargo findBYNombre(String nombre) {
         Cargo cargo = null;       
    try{   
        con = DBConn.getConnection();
        cst = con.prepareCall("{CALL sp_buscar_nombreCargo(?)}");
        cst.setString(1,nombre);
        rs = cst.executeQuery();
        if(rs.next()){
            cargo=new Cargo();
            cargo.setIdCargo(rs.getInt(1)); 
            cargo.setNombre(rs.getString(2)); 
           ; 
        }            rs.close(); 
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
    return cargo;
    
    }
    
}
