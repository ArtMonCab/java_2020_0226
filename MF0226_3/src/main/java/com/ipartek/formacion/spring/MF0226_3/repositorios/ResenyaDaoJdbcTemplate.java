package com.ipartek.formacion.spring.MF0226_3.repositorios;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ipartek.formacion.spring.MF0226_3.entidades.Resenya;

public class ResenyaDaoJdbcTemplate implements DaoResenya<Resenya>{

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Resenya> obtenerTodos() {
		return jdbc.query("SELECT * FROM resenya", new BeanPropertyRowMapper<Resenya>(Resenya.class));
	}

	@Override
	public Resenya obtenerPorId(Long id) {
		return jdbc.queryForObject("SELECT * FROM resenya WHERE codigo = ?", new BeanPropertyRowMapper<Resenya>(Resenya.class));
	}

	@Override
	public Resenya insertar(Resenya resenya) {
		KeyHolder keyholder = new GeneratedKeyHolder();

		jdbc.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO resenya(descripcion, fecha, alumno_codigo, curso_codigo) VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,  resenya.getDescripcion());
			ps.setDate(2, (Date) resenya.getFecha());
			ps.setInt(3, resenya.getAlumnoCodigo());
			ps.setInt(4, resenya.getCursoCodigo());
			
			return ps;
		}, keyholder);
		
		resenya.setCodigo(keyholder.getKey().intValue());
		return resenya;
	}

	@Override
	public Resenya modificar(Resenya resenya) {
		jdbc.update("UPDATE resenya SET descripcion = ?, fecha = ?, alumnoCodigo = ?, cursoCodigo WHERE id = ?", 
				resenya.getDescripcion(), resenya.getFecha(), resenya.getAlumnoCodigo(), resenya.getCursoCodigo(),resenya.getCodigo());
		return resenya;
	}

	@Override
	public void borrar(Long id) {
		jdbc.update("DELETE FROM curso WHERE resenya = ?", id);
		
	}

}
