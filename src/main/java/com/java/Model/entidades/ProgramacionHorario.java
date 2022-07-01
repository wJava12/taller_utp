/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.Model.entidades;



/**
 *
 * @author PCNEW
 */
public class ProgramacionHorario {
    private Integer idProgramacionHorario;
    private Horario horario;
    private Tecnico tecnico;

    public ProgramacionHorario(Horario horario, Tecnico tecnico) {
        this.horario = horario;
        this.tecnico = tecnico;
    }

    public ProgramacionHorario() {
    }

    
    public Integer getIdProgramacionHorario() {
        return idProgramacionHorario;
    }

    public void setIdProgramacionHorario(Integer idProgramacionHorario) {
        this.idProgramacionHorario = idProgramacionHorario;
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
        return "ProgramacionHorario{" + "idProgramacionHorario=" + idProgramacionHorario + ", horario=" + horario + ", tecnico=" + tecnico + '}';
    }
    
    
    
}
