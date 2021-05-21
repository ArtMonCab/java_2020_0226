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
class MarcaMySqlDao implements MarcaDao{
	
	private static final String SQL_SELECT = "SELECT m.id, m.nombre FROM marcas m";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE m.id = ?";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public Set<Marca> obtenerTodos(){
		try (Connection con = dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			Set<Marca> marcas = new HashSet<>();
			
			Marca marca;

			while (rs.next()) {
				marca = mapearResultSetMarca(rs);
				
				marcas.add(marca);
			}
			
			return marcas;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener todos los coches", e);
		}
	}
	
	@Override
	public Marca obtenerPorId(Long id) {
		return null;
		//return jdbc.queryForObject("SELECT * FROM marcas WHERE id = ?", new BeanPropertyRowMapper<Marca>(Marca.class), id);
	}
	
	@Override
	public Marca obtenerPorIdConCoches(Long id) {
		/*Marca marca = obtenerPorId(id);
		Collection<Coche> coches = jdbc.query(
				//"SELECT p.id, p.nombre, p.precio FROM productos p LEFT JOIN categorias c ON c.id = p.categoria_id WHERE c.id = ?",
				"SELECT c.id, c.modelo, c.matricula FROM coches c LEFT JOIN marcas m ON m.id = c.marca_id WHERE m.id = ?",
				new BeanPropertyRowMapper<Coche>(Coche.class), id);
		marca.getCoches().addAll(coches);
		
		return marca;*/
		return null;
	}
	
	private Marca mapearResultSetMarca(ResultSet rs) throws SQLException {
		Marca marca;
		marca = new Marca(rs.getLong("id"), rs.getString("nombre"));
		return marca;
	}


	

}
