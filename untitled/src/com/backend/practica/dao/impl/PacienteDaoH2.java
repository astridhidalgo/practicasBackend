package com.backend.practica.dao.impl;

import com.backend.practica.dao.H2Connection;
import com.backend.practica.dao.IDao;
import com.backend.practica.model.Domicilio;
import com.backend.practica.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;

public class PacienteDaoH2 implements IDao<Paciente> {
    private static final Logger LOGGER = Logger.getLogger(PacienteDaoH2.class);
    @Override
    public Paciente buscarTodos() {
        return null;
    }

    @Override
    public Paciente buscarPorId(int id, Connection connection) {
        return null;
    }

    @Override
    public Paciente insertar(Paciente paciente, Connection connection) {

        connection = null;
        Paciente pacientePersistido = null;

        try {

            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);


            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PACIENTES (NOMBRE, APELLIDO," +
                    " DNI, FECHAINGRESO) VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getDni());
            preparedStatement.setString(4, paciente.getFechaIngreso());
            preparedStatement.execute();

            DomicilioDaoH2 domicilio = new DomicilioDaoH2();
            Domicilio domicilioPaciente = paciente.getDomicilio();
            domicilio.insertar(domicilioPaciente, connection);

            connection.commit();

            LOGGER.info("Paciente registrado " + pacientePersistido);

        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
            if (connection != null) {
                try {
                    connection.rollback();
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage());
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception exception) {
                LOGGER.error(exception.getMessage());
            }
        }


        return pacientePersistido;
    }

    @Override
    public Paciente modificar(int id, Connection connection) {
        return null;
    }

    @Override
    public Paciente eliminar(int id, Connection connection) {
        return null;
    }
}
