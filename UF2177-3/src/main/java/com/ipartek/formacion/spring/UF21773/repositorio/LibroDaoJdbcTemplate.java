package com.ipartek.formacion.spring.UF21773.repositorio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.UF21773.entidades.Libro;


@Repository
public class LibroDaoJdbcTemplate implements Dao<Libro>{

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Libro> obtenerTodos() {
		return jdbc.query("SELECT * FROM libros", new BeanPropertyRowMapper<Libro>(Libro.class));
	}


}
