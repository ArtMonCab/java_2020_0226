package com.ipartek.formacion.spring.MF0226_3.repositorios;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.MF0226_3.entidades.Resenya;

@Repository
public class ResenyaDaoJdbcTemplate implements ResenyaDao{

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Resenya> obtenerTodos() {
		return jdbc.query("SELECT * FROM resenya", new BeanPropertyRowMapper<Resenya>(Resenya.class));
	}

	@Override
	public Resenya obtenerPorId(int id) {
		return jdbc.queryForObject("SELECT * FROM resenya WHERE codigo = ?", new BeanPropertyRowMapper<Resenya>(Resenya.class));
	}

	@Override
	public Resenya insertar(Resenya resenya) {
		KeyHolder keyholder = new GeneratedKeyHolder();

		jdbc.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO resenya(descripcion, alumno_codigo, curso_codigo) VALUES (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, resenya.getDescripcion());
			ps.setInt(2, resenya.getAlumnoCodigo());
			ps.setInt(3, resenya.getCursoCodigo());
			
			return ps;
		}, keyholder);
		
		resenya.setCodigo(keyholder.getKey().intValue());
		return resenya;
	}

	@Override
	public Resenya modificar(Resenya resenya) {
		jdbc.update("UPDATE resenya SET descripcion = ?, alumno_codigo = ?, curso_codigo = ? WHERE codigo = ?", 
				resenya.getDescripcion(), resenya.getAlumnoCodigo(), resenya.getCursoCodigo(),resenya.getCodigo());
		return resenya;
	}

	@Override
	public void borrar(int id) {
		jdbc.update("DELETE FROM resenya WHERE codigo = ?", id);
		
		
	}

}
