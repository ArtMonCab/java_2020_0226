package com.ipartek.formacion.spring.uf2177_1.repositorios;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.uf2177_1.entidades.Medicamento;

@Repository
public class medicamentoMySqlDao implements Dao<Medicamento> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Iterable<Medicamento> obtenerTodos() {
		return jdbcTemplate.query("SELECT * FROM medicamentos", new BeanPropertyRowMapper<Medicamento>(Medicamento.class));
	}

	@Override
	public Medicamento obtenerPorId(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM medicamentos WHERE id = ?",
				new BeanPropertyRowMapper<Medicamento>(Medicamento.class), new Object[] { id });
	}

	@Override
	public Medicamento agregar(Medicamento medicamento) {
		/*
		 * 		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO clientes (nombre, apellidos, cif, fecha_nacimiento) VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellidos());
			ps.setString(3, cliente.getCif());
			ps.setObject(4, cliente.getFechaNacimiento());
			return ps;
		}, keyHolder);

		cliente.setId(keyHolder.getKey().longValue());
		
		return cliente;
		 */
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO medicamentos (referencia, nombre, precio) VALUES (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, medicamento.getReferencia());
			ps.setString(2, medicamento.getNombre());
			ps.setDouble(3, medicamento.getPrecio());
			
			return ps;
		}, keyHolder);
		
		medicamento.setId(keyHolder.getKey().longValue());
		
		return medicamento;
	}

	@Override
	public Medicamento modificar(Medicamento medicamento) {
		jdbcTemplate.update("UPDATE medicamento SET referencia = ?, nombre = ?, precio= ? WHERE id = ?",
				new Object[] { medicamento.getReferencia(), medicamento.getNombre(), medicamento.getPrecio() });
		return medicamento;
	}

	@Override
	public void borrar(Long id) {
		jdbcTemplate.update("DELETE FROM medicamentos WHERE id = ?", new Object[] { id });
		
	}

}
