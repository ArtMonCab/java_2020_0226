package com.ipartek.formacion.spring.MF0226_3.repositorios;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.MF0226_3.entidades.Curso;
import com.ipartek.formacion.spring.MF0226_3.entidades.Profesor;

@Repository
public class CursoDaoJdbcTemplate implements Dao<Curso>{

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Curso> obtenerTodos() {
		return jdbc.query("SELECT c.codigo, c.nombre, c.identificador, c.nHoras, p.codigo, p.nombre, p.apellidos \r\n"
				+ "FROM curso c \r\n"
				+ "LEFT JOIN profesor p ON p.codigo= c.profesor_codigo", (rs, rowNum) -> 
				new Curso(rs.getInt("c.codigo"), rs.getString("c.nombre"), rs.getString("c.identificador"), rs.getInt("c.nhoras")
						,new Profesor(rs.getInt("p.codigo"), rs.getString("p.nombre"), rs.getString("p.apellidos"))));
		
	}

	@Override
	public Curso obtenerPorId(int id) {
		return jdbc.queryForObject("SELECT c.codigo, c.nombre, c.identificador, c.nHoras, p.codigo, p.nombre, p.apellidos \r\n"
				+ "FROM curso c \r\n"
				+ "LEFT JOIN profesor p ON p.codigo= c.profesor_codigo\r\n"
				+ "WHERE c.codigo = ?", (rs, rowNum) -> 
				new Curso(rs.getInt("c.codigo"), rs.getString("c.nombre"), rs.getString("c.identificador"), rs.getInt("c.nhoras")
						,new Profesor(rs.getInt("p.codigo"), rs.getString("p.nombre"), rs.getString("p.apellidos"))), id);
	}



}
