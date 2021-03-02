package com.ipartek.formacion.spring.UF1466_1.repositorios;

import java.sql.SQLException;

public interface Dao<T> {
	default Iterable<T> obtenerTodos(){
		throw new AccesoDatosException("ESTE METODO NO ESTÁ IMPLEMENTADO");
	}
	

	default String obtenerCampos() throws SQLException, ClassNotFoundException{
		throw new AccesoDatosException("ESTE METODO NO ESTÁ IMPLEMENTADO");
	}
}
