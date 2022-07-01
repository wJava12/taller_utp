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

import com.java.Model.dao.ElectrodomesticoDao;
import com.java.Model.entidades.Electrodomestico;
import com.java.conexion.DBConn;
import com.java.service.ClienteService;
import com.java.service.TipoElectroService;
import com.java.service.impl.ClienteServiceImpl;
import com.java.service.impl.TipoElectroServiceImpl;

/**
 *
 * @author PCNEW
 */
public class ElectrodomesticoDaoImpl implements ElectrodomesticoDao {
private Connection con;
    private ResultSet rs;
    private CallableStatement cst;
    @Override
    public void create(Electrodomestico t) {
     try {            
           con = DBConn.getConnection();
       con.setAutoCommit(false); 
           System.out.println(t);
       cst = con.prepareCall("{CALL sp_insertar_electro(?,?,?,?,?,?,?)}");

       cst.setString(1,t.getNombre());
       cst.setString(2,t.getMarca());
       cst.setString(3,t.getModelo());
       cst.setString(4,t.getSerie());
       //cst.setString(4,t.getDni());
       cst.setString(5,t.getDescripcion());
       cst.setInt(6,t.getTipo().getIdTipoElectro());
       cst.setInt(7,t.getCliente().getIdCLiente());
 
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
    public Electrodomestico find(Integer id) {
   Electrodomestico electro = null;
     
        TipoElectroService tipoElectro= new TipoElectroServiceImpl();
        ClienteService clienteService= new ClienteServiceImpl();
        try{
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_find_electro(?)}");
            cst.setInt(1,id);
            rs = cst.executeQuery();
            if(rs.next()){
                electro=new Electrodomestico();
                electro.setIdElectr(rs.getInt(1));
                electro.setNombre(rs.getString(2));
                electro.setMarca(rs.getString(3));
                electro.setModelo(rs.getString(4));
                electro.setSerie(rs.getString(5));
                electro.setDescripcion(rs.getString(6));
                electro.setTipo(tipoElectro.buscar(rs.getInt(7)));
                electro.setCliente(clienteService.buscar(rs.getInt(8)));
            
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
        return electro; }

    @Override
    public List<Electrodomestico> findAll() {
    List<Electrodomestico> lElectro = new ArrayList<>();
     TipoElectroService tipo= new TipoElectroServiceImpl();
        ClienteService clienteService= new ClienteServiceImpl();
     Electrodomestico electro;        
     try {
         con = DBConn.getConnection(); 
         cst = con.prepareCall("{CALL sp_mostrar_electro()}");
         rs = cst.executeQuery();              
         while(rs.next()){
             electro=new Electrodomestico();
             electro.setIdElectr(rs.getInt(1));
             electro.setNombre(rs.getString(2));
             electro.setMarca(rs.getString(3));
             electro.setModelo(rs.getString(4));
             electro.setSerie(rs.getString(5));
             electro.setDescripcion(rs.getString(6));
             electro.setTipo(tipo.buscar(rs.getInt(7)));
             electro.setCliente(clienteService.buscar(rs.getInt(8)));
             lElectro.add(electro);            
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
     return lElectro;
    }

    @Override
    public void update(Electrodomestico t) {
      try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_upd_electro(?,?,?,?,?,?)}");
       cst.setInt(1,t.getIdElectr());
          cst.setString(2,t.getMarca());
       cst.setString(3,t.getMarca());
       cst.setString(4,t.getModelo());
       cst.setString(5,t.getSerie());
       cst.setString(6,t.getDescripcion());
       cst.setInt(7,t.getTipo().getIdTipoElectro());
       cst.setInt(8,t.getCliente().getIdCLiente());
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

    @Override
    public int idELectro() {
        int id=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_mostrar_idElectro()}");
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
