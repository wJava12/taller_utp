/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.Model.entidades;

import java.util.Date;

/**
 *
 * @author PCNEW
 */
public class Servicio {
    
    private Integer idServicio;
    private String fecha;
    private String hora;
    private Double monto;
    private String descripcion;
    private int estado;
    private String modalidad;
    private Electrodomestico electrodomestico;
    private Personal personal;
    private TipoServicio tipo;
    private HorarioTecnico horarioTecnico;

    public Servicio(String fecha,String hora, Double monto, String descripcion, String modalidad, Electrodomestico electro, TipoServicio tipo) {
        this.fecha=fecha;
        this.hora=hora;
        this.monto = monto;
        this.descripcion = descripcion;
        this.estado=1;
        this.modalidad = modalidad;
        this.electrodomestico = electro;
        this.tipo = tipo;
    }

    public Servicio() {
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Electrodomestico getElectrodomestico() {
        return electrodomestico;
    }

    public void setElectrodomestico(Electrodomestico electrodomestico) {
        this.electrodomestico = electrodomestico;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public TipoServicio getTipo() {
        return tipo;
    }

    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    public HorarioTecnico getHorarioTecnico() {
        return horarioTecnico;
    }

    public void setHorarioTecnico(HorarioTecnico horarioTecnico) {
        this.horarioTecnico = horarioTecnico;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "idServicio=" + idServicio +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", monto=" + monto +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", modalidad='" + modalidad + '\'' +
                ", electrodomestico=" + electrodomestico +
                ", personal=" + personal +
                ", tipo=" + tipo +
                ", horarioTecnico=" + horarioTecnico +
                '}';
    }
}
