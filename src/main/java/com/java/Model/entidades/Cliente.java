/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.Model.entidades;

import java.util.List;

/**
 *
 * @author PCNEW
 */
public class Cliente {
    private Integer idCLiente;
    private String nombre;
    private String apelldos;
    private String dni;
    private String direccion;
    private String telefono;
    private String correo;
    private String usuario;
    private String clave;
    private int estado;
    private Cargo cargo;
    private List<Electrodomestico> electrodomesticos;

    public Cliente() {
    }


    public Cliente(String nombre, String apelldos, String dni, String direccion, String telefono, String correo, String usuario, String clave,Cargo cargo) {
        this.nombre = nombre;
        this.apelldos = apelldos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.estado = 1;
        this.cargo =cargo;
    }

    public Cliente(String nombre, String apelldos, String dni, String direccion, String telefono, String correo, String usuario, String clave) {
        this.nombre = nombre;
        this.apelldos = apelldos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
    }
    public Cliente(String nombre, String apelldos, String direccion, String telefono, String correo, String usuario, String clave) {
        this.nombre = nombre;
        this.apelldos = apelldos;

        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
    }
    public Integer getIdCLiente() {
        return idCLiente;
    }

    public void setIdCLiente(Integer idCLiente) {
        this.idCLiente = idCLiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelldos() {
        return apelldos;
    }

    public void setApelldos(String apelldos) {
        this.apelldos = apelldos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Electrodomestico> getElectrodomesticos() {
        return electrodomesticos;
    }

    public void setElectrodomesticos(List<Electrodomestico> electrodomesticos) {
        this.electrodomesticos = electrodomesticos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCLiente=" + idCLiente +
                ", nombre='" + nombre + '\'' +
                ", apelldos='" + apelldos + '\'' +
                ", dni='" + dni + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' +
                ", estado=" + estado +
                ", cargo='" + cargo + '\'' +
                ", electrodomesticos=" + electrodomesticos +
                '}';
    }
}
