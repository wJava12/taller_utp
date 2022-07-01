/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.Model.dao;


import com.java.Model.entidades.Cargo;

/**
 *
 * @author ASUS
 */
public interface CargoDao extends EntidadDao<Cargo,Integer> {
    
    public Cargo findBYNombre(String nombre);
}
