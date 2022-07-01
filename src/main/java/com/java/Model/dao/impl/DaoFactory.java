package com.java.Model.dao.impl;

import com.java.Model.dao.*;

public class DaoFactory {

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }

    private static class DaoFactoryHolder {

        private static final DaoFactory INSTANCE = new DaoFactory();
    }

    public PersonalDao getPersonalDao() {
        return new PersonalDaoDataBase();

    }

    public CargoDao getCargoDao() {
        return new CargoDaoImpl();

    }

    public HorarioDao getHorarioDao() {
        return new HorarioDaoImpl();

    }

    public TIpoElectroDao getElectroDao() {
        return new TipoElectroDaoImpl();

    }

    public ElectrodomesticoDao getElectrodomesticoDao() {
        return new ElectrodomesticoDaoImpl();

    }

    public ClienteDao getClienteDao() {
        return new ClienteDaoImpl();

    }

    public ArticuloDao getArticuloDao() {
        return new ArticuloDaoImpl();

    }

    public TecnicoDao getTecnicoDao() {
        return new TecnicoDaoImpl();

    }

    public ProgramacionHorarioDao getProgramacionHorarioDao() {
        return new ProgramacionHorarioDaoImpl();

    }

    public HorarioTecnicoDao getHorarioTecnicoDao() {
        return new HorarioTecnicoDaoImpl();

    }
    
    public TipoServicioDao getTipoServicioDao() {
        return new TipoServicioDaoImpl();

    }
    
    public ServicioDao getServicioDao() {
        return new ServicioDaoImpl();

    }
    public EspecialidadDao getEspecialidadDao() {
        return new EspecialidadDaoImpl();

    }
    public EspecialidadTecnicoDao getEspecialidadTecnicoDao() {
        return new EspecialidadTecnicoDaoImpl();

    }
}

