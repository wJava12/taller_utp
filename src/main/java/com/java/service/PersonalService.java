package com.java.service;



import com.java.Model.entidades.Personal;

import java.util.List;

public interface PersonalService extends EntidadService<Personal, Integer>{

    public Personal validar(String user, String password);
     public boolean cambiarEstado(Integer id,int estado);
     
      public List<Personal> buscarPorApellido(String apellido);
}
