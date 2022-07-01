package com.java.service;


import com.java.Model.entidades.Horario;

public interface HorarioService extends EntidadService<Horario, Integer>{
    Horario bucarPorNombre(String nombre);
    int mostrarIdHorario();
}
