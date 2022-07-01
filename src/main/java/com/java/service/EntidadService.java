/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.service;

import java.util.List;

/**
 *
 * @author PCNEW
 */
public interface EntidadService<T,V> {
    public void insertar(T t);

    public T buscar(V v);
    public List<T> mostrar();

    public void actualizar(T t);
    public void eliminar(V v);
}
