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

import com.java.Model.dao.ArticuloDao;
import com.java.Model.entidades.Articulo;
import com.java.conexion.DBConn;

public class ArticuloDaoImpl implements ArticuloDao {
private Connection con;
    private ResultSet rs;
    private CallableStatement cst;
    @Override
    public void create(Articulo t) {
    try {            
           con = DBConn.getConnection();
       con.setAutoCommit(false); 
           System.out.println(t);
       cst = con.prepareCall("{CALL sp_insertar_articulo(?,?,?)}");
           
       cst.setString(1,t.getNombre());
       cst.setInt(2,t.getCantidad());
       cst.setDouble(3,t.getPrecio());
       
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
    public Articulo find(Integer id) {
    Articulo articulo = null;
      
        try{
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_find_articulo(?)}");
            cst.setInt(1,id);
            rs = cst.executeQuery();
            if(rs.next()){
                articulo=new Articulo();
                articulo.setIdArticulo(rs.getInt(1));
             articulo.setNombre(rs.getString(2));
             articulo.setCantidad(rs.getInt(3));
              articulo.setPrecio(rs.getDouble(4));
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
        return articulo; }

    @Override
    public List<Articulo> findAll() {
     List<Articulo> lArticulo = new ArrayList<>();
    
     Articulo articulo;        
     try {
         con = DBConn.getConnection(); 
         cst = con.prepareCall("{CALL sp_mostrar_articulo()}");
         rs = cst.executeQuery();              
         while(rs.next()){
             articulo=new Articulo();               
             
              articulo.setIdArticulo(rs.getInt(1));
             articulo.setNombre(rs.getString(2));
             articulo.setCantidad(rs.getInt(3));
              articulo.setPrecio(rs.getDouble(4));
              
             lArticulo.add(articulo);            
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
     return lArticulo;  }

    @Override
    public void update(Articulo t) {
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_upd_articulo(?,?,?,?)}");
       
            cst.setInt(1,t.getIdArticulo());     
       cst.setString(2,t.getNombre());
       cst.setInt(3,t.getCantidad());
       cst.setDouble(4,t.getPrecio());
       
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
    public void delete(Integer id) {
     try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_del_articulo(?)}");
            cst.setInt(1,id);
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
    
}
