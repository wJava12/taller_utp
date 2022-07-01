package com.java.Model.dao;


import com.java.Model.entidades.Personal;

import java.util.List;

public interface PersonalDao extends EntidadDao<Personal,Integer> {
    
    
     public Personal validarLogin(String us, String ps);
     public boolean updateState(Integer id,int estado);
     public List<Personal> buscarLikeAp(String apellido);
}
