package com.backend.practica.dao.impl;

import com.backend.practica.dao.IDao;
import com.backend.practica.model.Domicilio;
import org.apache.log4j.Logger;

import java.sql.Connection;

public class DomicilioDaoH2 implements IDao<Domicilio> {
    private static final Logger LOGGER = Logger.getLogger(DomicilioDaoH2.class);


    @Override
    public Domicilio buscarTodos() {
        return null;
    }

    @Override
    public Domicilio buscarPorId(int id, Connection connection) {
        return null;
    }

    @Override
    public Domicilio insertar(Domicilio domicilio, Connection connection) {
        return null;
    }

    @Override
    public Domicilio modificar(int id, Connection connection) {
        return null;
    }

    @Override
    public Domicilio eliminar(int id, Connection connection) {
        return null;
    }

}
