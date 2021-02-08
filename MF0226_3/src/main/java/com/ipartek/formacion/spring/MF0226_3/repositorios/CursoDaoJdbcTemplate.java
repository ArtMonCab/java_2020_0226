package com.ipartek.formacion.spring.MF0226_3.repositorios;



import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.MF0226_3.entidades.Curso;

@Repository
public class CursoDaoJdbcTemplate implements DaoCurso<Curso>{

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Curso> obtenerTodos() {
		return jdbc.query("SELECT * FROM curso", new BeanPropertyRowMapper<Curso>(Curso.class));
	}

	@Override
	public Curso obtenerPorId(Long id) {
		return jdbc.queryForObject("SELECT * FROM curso WHERE codigo = ?", new BeanPropertyRowMapper<Curso>(Curso.class));
	}

	@Override
	public Curso insertar(Curso curso) {
		
		KeyHolder keyholder = new GeneratedKeyHolder();

		jdbc.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO curso(nombre, identificador, nHoras, ProfesorCodigo) VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,  curso.getNombre());
			ps.setString(2, curso.getIdentificador());
			ps.setInt(3, curso.getNHoras());
			ps.setInt(4, curso.getProfesorCodigo());
			
			return ps;
		}, keyholder);
		
		curso.setCodigo(keyholder.getKey().intValue());
		return curso;
	}

	@Override
	public Curso modificar(Curso curso) {
		jdbc.update("UPDATE curso SET nombre = ?, identificador = ?, nHoras = ?, profesor_codigo = ? WHERE id = ?", 
				curso.getNombre(), curso.getIdentificador(), curso.getNHoras(), curso.getProfesorCodigo(),curso.getCodigo());
		return curso;

	}

	@Override
	public void borrar(Long id) {
		jdbc.update("DELETE FROM curso WHERE codigo = ?", id);
		
	}

}
