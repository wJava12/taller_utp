
package com.java.Model.dao;


import com.java.Model.entidades.Horario;


public interface HorarioDao extends EntidadDao<Horario,Integer> {
    public Horario findByNameHorario(String nombre);
    int findIdHorario();
}
