package com.backend.practica.dao;

import java.sql.Connection;

public interface IDao<T>{

    T buscarTodos();
    T buscarPorId(int id, Connection connection);
    T insertar(T t, Connection connection);
    T modificar(int id, Connection connection );
    T eliminar(int id, Connection connection);


}
