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

import com.java.Model.dao.ProgramacionHorarioDao;
import com.java.Model.entidades.ProgramacionHorario;
import com.java.conexion.DBConn;
import com.java.service.HorarioService;
import com.java.service.TecnicoService;
import com.java.service.impl.HorarioServiceImpl;
import com.java.service.impl.TecnicoServiceImpl;

/**
 *
 * @author PCNEW
 */
public class ProgramacionHorarioDaoImpl implements ProgramacionHorarioDao {

    
    private Connection con;
    private ResultSet rs;
    private CallableStatement cst;
    @Override
    public void create(ProgramacionHorario t) {
     try {            
           con = DBConn.getConnection();
       con.setAutoCommit(false); 
           System.out.println(t);
       cst = con.prepareCall("{CALL sp_insertar_progHorario(?,?)}");
      
       cst.setInt(1,t.getTecnico().getIdTecnico());
       cst.setInt(2,t.getHorario().getIdHorario()); 
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
    public ProgramacionHorario find(Integer id) {
     ProgramacionHorario progHorario = null;
      TecnicoService tecnico= new TecnicoServiceImpl();
        HorarioService horario= new HorarioServiceImpl();
        try{
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_find_progHorario(?)}");
            cst.setInt(1,id);
            rs = cst.executeQuery();
            if(rs.next()){
                progHorario=new ProgramacionHorario();
                progHorario.setIdProgramacionHorario(rs.getInt(1));
             progHorario.setHorario(horario.buscar(rs.getInt(2)));
             progHorario.setTecnico(tecnico.buscar(rs.getInt(3)));
             
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
        return progHorario; }

    @Override
    public List<ProgramacionHorario> findAll() {
    List<ProgramacionHorario> lProg = new ArrayList<>();
      TecnicoService tecnico= new TecnicoServiceImpl();
        HorarioService horario= new HorarioServiceImpl();
       
     ProgramacionHorario progHorario;        
     try {
         con = DBConn.getConnection(); 
         cst = con.prepareCall("{CALL sp_mostrar_personal()}");
         rs = cst.executeQuery();              
         while(rs.next()){
             progHorario=new ProgramacionHorario();               
            progHorario.setIdProgramacionHorario(rs.getInt(1));
             progHorario.setHorario(horario.buscar(rs.getInt(2)));
             progHorario.setTecnico(tecnico.buscar(rs.getInt(3)));
             lProg.add(progHorario);            
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
     return lProg; 
    
    
    }

    @Override
    public void update(ProgramacionHorario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
