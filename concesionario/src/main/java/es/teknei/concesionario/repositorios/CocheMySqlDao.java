package es.teknei.concesionario.repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.teknei.concesionario.entidades.Coche;
import es.teknei.concesionario.entidades.Marca;

@Repository
class CocheMySqlDao implements Dao<Coche>{
	
	private static final String SQL_SELECT = "SELECT c.id, c.modelo, c.matricula FROM coches c";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE c.id = ?";
	
	@Autowired
	private DataSource dataSource;
	//private JdbcTemplate jdbc;
	
	@Override
	public Set<Coche> obtenerTodos() {
		/*return jdbc.query("SELECT * \r\n"
				+ "FROM coches c\r\n"
				+ "LEFT JOIN marcas m ON c.marca_id = m.id\r\n", (rs, rowNum) -> 
				new Coche(rs.getLong("c.id"), rs.getString("c.modelo"), rs.getString("c.matricula"),
						new Marca(rs.getLong("m.id"), rs.getString("m.nombre"))));*/
		
		try (Connection con = dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			Set<Coche> coches = new HashSet<>();
			
			Coche coche;

			while (rs.next()) {
				coche = mapearResultSetCoche(rs);
				
				coches.add(coche);
			}
			
			return coches;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener todos los coches", e);
		}
	}
	
	
	@Override
	public Coche obtenerPorId(Long id) {
		return null;
		/*return jdbc.queryForObject("SELECT * \r\n"
				+ "FROM coches c\r\n"
				+ "LEFT JOIN marcas m ON c.marca_id = m.id\r\n"
				+ "WHERE c.id = ?", (rs, rowNum) ->
				new Coche(rs.getLong("c.id"), rs.getString("c.modelo"), rs.getString("c.matricula"),
						new Marca(rs.getLong("m.id"), rs.getString("m.nombre"))), id);	*/
		
	}
	
	private Coche mapearResultSetCoche(ResultSet rs) throws SQLException {
		Coche coche;
		//Marca marca;
		//marca = new Marca(rs.getLong("m_id"), rs.getString("m_nombre"));
		coche = new Coche(rs.getLong("id"), rs.getString("modelo"), rs.getString("matricula"), null);
		return coche;
	}

}
