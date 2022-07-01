package com.java.service;



import com.java.Model.entidades.Cargo;

public interface CargoService extends EntidadService<Cargo, Integer>{

   public Cargo bucarPorNombre(String nombre);
}
