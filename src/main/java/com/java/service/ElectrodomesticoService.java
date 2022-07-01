/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.service;


import com.java.Model.entidades.Electrodomestico;

/**
 *
 * @author PCNEW
 */
public interface ElectrodomesticoService extends EntidadService<Electrodomestico, Integer> {
    public int mostrarIdElectro();
}
