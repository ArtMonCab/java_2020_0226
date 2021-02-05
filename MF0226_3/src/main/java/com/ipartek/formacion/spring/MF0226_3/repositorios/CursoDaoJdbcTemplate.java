package com.ipartek.formacion.spring.MF0226_3.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.MF0226_3.entidades.Curso;

@Repository
public class CursoDaoJdbcTemplate implements Dao<Curso>{

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Curso> obtenerTodos() {
		return jdbc.query("SELECT * FROM curso", new BeanPropertyRowMapper<Curso>(Curso.class));
	}

	@Override
	public Curso obtenerPorId(Long id) {
		return jdbc.queryForObject("SELECT * FROM clientes WHERE id = ?", new BeanPropertyRowMapper<Curso>(Curso.class));
	}

	@Override
	public Curso insertar(Curso curso) {
		// TODO Auto-generated method stub
		return curso;
	}

	@Override
	public Curso modificar(Curso curso) {
		// TODO Auto-generated method stub
		return curso;
	}

	@Override
	public void borrar(Long id) {
		jdbc.update("DELETE FROM curso WHERE codigo = ?", id);
		
	}

}
