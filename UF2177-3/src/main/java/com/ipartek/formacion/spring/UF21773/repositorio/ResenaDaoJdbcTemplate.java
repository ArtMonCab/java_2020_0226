package com.ipartek.formacion.spring.UF21773.repositorio;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import com.ipartek.formacion.spring.UF21773.entidades.Resena;

@Repository
public class ResenaDaoJdbcTemplate implements ResenaDao<Resena>{

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Resena> obtenerTodos() {
		return jdbc.query("SELECT * FROM resenas", new BeanPropertyRowMapper<Resena>(Resena.class));
	}

	@Override
	public Iterable<Resena> obtenerResenaPorLibro(int id) {
		return jdbc.query("SELECT * FROM resenas where libros_id = ?", 
				new BeanPropertyRowMapper<Resena>(Resena.class), id);
	}

	@Override
	public Resena insertar(Resena resena) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbc.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO resenas (texto, libros_id) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, resena.getTexto());
			ps.setInt(2, resena.getLibros_id());
			
			return ps;
		}, keyHolder);

		resena.setId(keyHolder.getKey().intValue());


		return resena;
	}







}
