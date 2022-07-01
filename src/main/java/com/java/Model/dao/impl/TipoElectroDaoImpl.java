/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.Model.dao.impl;


import com.java.Model.dao.TIpoElectroDao;
import com.java.Model.entidades.TipoElectro;
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
public class TipoElectroDaoImpl implements TIpoElectroDao {

    
    private Connection con;
    private ResultSet rs;
    private CallableStatement cst;
    @Override
    public void create(TipoElectro t) {
     try {            
           con = DBConn.getConnection();
       con.setAutoCommit(false); 
           System.out.println(t);
       cst = con.prepareCall("{CALL sp_insertar_TipoElectro(?)}");
           
       cst.setString(1,t.getNombre());
       
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
    public TipoElectro find(Integer id) {
     TipoElectro electro = null;
    
        try{
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_find_tipoElectro(?)}");
            cst.setInt(1,id);
            rs = cst.executeQuery();
            if(rs.next()){
                electro=new TipoElectro();
                electro.setIdTipoElectro(rs.getInt(1));
                electro.setNombre(rs.getString(2));
             
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
        return electro;
    }

    @Override
    public List<TipoElectro> findAll() {
    List<TipoElectro> lElectros = new ArrayList<>();
    
     TipoElectro electro;        
     try {
         con = DBConn.getConnection(); 
         cst = con.prepareCall("{CALL sp_mostrar_tipoElectro()}");
         rs = cst.executeQuery();              
         while(rs.next()){
             electro=new TipoElectro();               
             electro.setIdTipoElectro(rs.getInt(1));
             electro.setNombre(rs.getString(2));
             
             lElectros.add(electro);            
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
     return lElectros;  }

    @Override
    public void update(TipoElectro t) {
   try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_upd_tipoElectro(?,?)}");
       cst.setInt(1,t.getIdTipoElectro());     
       cst.setString(2,t.getNombre());
       
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
    public void delete(Integer v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
