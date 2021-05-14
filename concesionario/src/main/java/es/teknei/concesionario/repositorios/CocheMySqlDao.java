package es.teknei.concesionario.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import es.teknei.concesionario.entidades.Coche;
import es.teknei.concesionario.entidades.Marca;

public class CocheMySqlDao implements Dao<Coche>{
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Coche> obtenerTodos() {
		return jdbc.query("SELECT * \r\n"
				+ "FROM coches c\r\n"
				+ "LEFT JOIN marcas m ON c.marca_id = m.id\r\n", (rs, rowNum) -> 
				new Coche(rs.getLong("c.id"), rs.getString("c.modelo"), rs.getString("c.matricula"),
						new Marca(rs.getLong("m.id"), rs.getString("m.nombre"))));
	}
	
	
	@Override
	public Coche obtenerPorId(Long id) {
		return jdbc.queryForObject("SELECT * \r\n"
				+ "FROM coches c\r\n"
				+ "LEFT JOIN marcas m ON c.marca_id = m.id\r\n"
				+ "WHERE c.id = ?", (rs, rowNum) ->
				new Coche(rs.getLong("c.id"), rs.getString("c.modelo"), rs.getString("c.matricula"),
						new Marca(rs.getLong("m.id"), rs.getString("m.nombre"))), id);	
		
	}

}
