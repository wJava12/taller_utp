package com.java.Model.entidades;

public class EspecialidadTecnico {

    private Integer idEspecialidadTecnico;
    private Tecnico tecnico;
    private Especialidad especialidad;

    public EspecialidadTecnico() {
    }

    public EspecialidadTecnico(Tecnico tecnico, Especialidad especialidad) {
        this.tecnico = tecnico;
        this.especialidad = especialidad;
    }

    public Integer getIdEspecialidadTecnico() {
        return idEspecialidadTecnico;
    }

    public void setIdEspecialidadTecnico(Integer idEspecialidadTecnico) {
        this.idEspecialidadTecnico = idEspecialidadTecnico;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "EspecialidadTecnico{" +
                "idEspecialidadTecnico=" + idEspecialidadTecnico +
                ", tecnico=" + tecnico +
                ", especialidad=" + especialidad +
                '}';
    }
}
