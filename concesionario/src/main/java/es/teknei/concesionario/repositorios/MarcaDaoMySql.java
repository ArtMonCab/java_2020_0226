package es.teknei.concesionario.repositorios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.teknei.concesionario.entidades.Marca;

@Repository
public class MarcaDaoMySql implements Dao<Marca>{
	private static final String SQL_SELECT= "SELECT m.id, m.nombre FROM marcas m";
	
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public Iterable<Marca> obtenerTodos() {
		return jdbc.query(SQL_SELECT, new BeanPropertyRowMapper<Marca>(Marca.class));
	}
	

}
