
package com.java.Model.entidades;

import java.util.List;

public class Tecnico {
    
    private Integer idTecnico;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String correo;
    private String experiencia;
    private String usuario;
    private String clave;
    private int estado;
    private int estadoEliminado;
    private Cargo cargo;

    private List<Especialidad> listaEspecialidades;

    public Tecnico(String nombre, String apellido, String dni,String telefono, String correo, String experiencia,String usuario,String clave,Cargo cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni=dni;
        this.telefono = telefono;
        this.correo = correo;
        this.experiencia = experiencia;
        this.usuario=usuario;
        this.clave=clave;
        this.estado=1;
        this.estadoEliminado=1;
        this.cargo=cargo;
    }

    public Tecnico() {
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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



    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstadoEliminado() {
        return estadoEliminado;
    }

    public void setEstadoEliminado(int estadoEliminado) {
        this.estadoEliminado = estadoEliminado;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
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

    public List<Especialidad> getListaEspecialidades() {
        return listaEspecialidades;
    }

    public void setListaEspecialidades(List<Especialidad> listaEspecialidades) {
        this.listaEspecialidades = listaEspecialidades;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "idTecnico=" + idTecnico +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +

                ", experiencia='" + experiencia + '\'' +
                ", usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' +
                ", estado=" + estado +
                ", estadoEliminado=" + estadoEliminado +
                ", cargo=" + cargo +
                '}';
    }

    public void addEspecialidad(Especialidad especialidad){
        listaEspecialidades.add(especialidad);
    }

}
