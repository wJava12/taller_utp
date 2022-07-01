/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.Model.dao.impl;


import com.java.Model.dao.HorarioDao;
import com.java.Model.entidades.Horario;
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
public class HorarioDaoImpl implements HorarioDao
{
    private Connection con;
    private ResultSet rs;
    private CallableStatement cst;
    @Override
    public void create(Horario t) {
      try {

          System.out.println("Insertando: "+t);
           con = DBConn.getConnection();
       con.setAutoCommit(false); 
           System.out.println(t);
       cst = con.prepareCall("{CALL sp_insertar_horario(?,?,?,?,?,?)}");

          cst.setString(1,t.getFechaIngreso());
          cst.setString(2,t.getHorarioEntrada());
          cst.setString(3,t.getHoraSalida());
          cst.setString(4,t.getDiaInicio());
          cst.setString(5,t.getDiaFin());
          cst.setString(6,t.getHoraAlmuerzo());

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
    public Horario find(Integer id) {
     Horario horario = null;       
    try{   
        con = DBConn.getConnection();
        cst = con.prepareCall("{CALL sp_buscar_horario(?)}");
        cst.setInt(1,id);
        rs = cst.executeQuery();
        if(rs.next()){
            horario=new Horario();
            horario.setIdHorario(rs.getInt(1));
            horario.setFechaIngreso(rs.getString(2));
            horario.setHorarioEntrada(rs.getString(3));
            horario.setHoraSalida(rs.getString(4));
            horario.setDiaInicio(rs.getString(5));
            horario.setDiaFin(rs.getString(6));
            horario.setHoraAlmuerzo(rs.getString(7));


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
    return horario;  
    }

    @Override
    public List<Horario> findAll() {
     List<Horario> lHorario = new ArrayList<>();
     
     Horario horario;        
     try {
         con = DBConn.getConnection(); 
         cst = con.prepareCall("{CALL sp_mostrar_horario()}");
         rs = cst.executeQuery();              
         while(rs.next()){
             horario=new Horario();
             horario.setIdHorario(rs.getInt(1));
             horario.setFechaIngreso(rs.getString(2));
             horario.setHorarioEntrada(rs.getString(3));
             horario.setHoraSalida(rs.getString(4));
             horario.setDiaInicio(rs.getString(5));
             horario.setDiaFin(rs.getString(6));
             horario.setHoraAlmuerzo(rs.getString(7));
             lHorario.add(horario);            
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
     return lHorario; 
    
    }

    @Override
    public void update(Horario t) {
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_upd_horario(?,?,?,?,?,?,?)}");
            cst.setInt(1,t.getIdHorario());
            cst.setString(2,t.getFechaIngreso());
            cst.setString(3,t.getHorarioEntrada());
            cst.setString(4,t.getHoraSalida());
            cst.setString(5,t.getDiaInicio());
            cst.setString(6,t.getDiaFin());
            cst.setString(7,t.getHoraAlmuerzo());
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
        }  }

    @Override
    public void delete(Integer v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Horario findByNameHorario(String nombre) {
    Horario horario = null;       
        return horario;
    }

    @Override
    public int findIdHorario() {
        int id=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_mostrar_idHorario()}");
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


}
