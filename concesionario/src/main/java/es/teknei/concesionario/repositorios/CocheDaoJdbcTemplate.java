package es.teknei.concesionario.repositorios;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import es.teknei.concesionario.entidades.Coche;

@Repository
public class CocheDaoJdbcTemplate implements DaoCoche {
	private static final String SQL_SELECT = "SELECT c.id, c.modelo, c.matricula, c.marca_id, m.id, m.nombre FROM coches c JOIN marcas m ON c.marca_id = m.id";
	private static final String SQL_SELECT_MARCA = SQL_SELECT + " WHERE m.id = ?";
	private static final String SQL_INSERT = "INSERT INTO coches (modelo, matricula, marca_id) VALUES (?, ?, ?)";
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Coche insertar(Coche coche) {


		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbc.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(
					SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, coche.getModelo());
			ps.setString(2, coche.getMatricula());
			ps.setLong(3, coche.getMarca().getId());
			return ps;
		}, keyHolder);

		coche.setId(keyHolder.getKey().longValue());

		return coche;
	}

	@Override
	public Iterable<Coche> obtenerCochePorMarca(long id) {
		return jdbc.query(SQL_SELECT_MARCA, new BeanPropertyRowMapper<Coche>(Coche.class), id);
	}

}
