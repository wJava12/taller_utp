/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.Model.entidades;


public class HorarioTecnico {
    private int idHorarioTecnico;
    private int estado;
    private Horario horario;
    private Tecnico tecnico;

    public HorarioTecnico() {
    }

    public HorarioTecnico( Horario horario, Tecnico tecnico) {
        this.estado = 1;
        this.horario = horario;
        this.tecnico = tecnico;
    }
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public int getIdHorarioTecnico() {
        return idHorarioTecnico;
    }

    public void setIdHorarioTecnico(int idHorarioTecnico) {
        this.idHorarioTecnico = idHorarioTecnico;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    @Override
    public String toString() {
        return "HorarioTecnico{" +
                "idHorarioTecnico=" + idHorarioTecnico +
                ", estado=" + estado +
                ", horario=" + horario +
                ", tecnico=" + tecnico +
                '}';
    }
}
