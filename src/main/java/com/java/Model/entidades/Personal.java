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
public class Personal {
    private Integer idPersonal;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String dni;
    private String telefono;
    private String correo;
    private String usuario;
    private String clave;
    private int estado;
    private Cargo cargo;


    public Personal() {
    }

    
    public Personal( String nombre, String apellidos, String direccion, String dni, String telefono, String correo, String usuario, String clave, Cargo cargo ) {
        
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.estado=1;
        this.cargo = cargo;
        
    }

    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

   

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Personal{" + "idPersonal=" + idPersonal + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", dni=" + dni + ", telefono=" + telefono + ", correo=" + correo + ", usuario=" + usuario + ", clave=" + clave + ", cargo=" + cargo + ", horario=" +  '}';
    }
    
    

}
