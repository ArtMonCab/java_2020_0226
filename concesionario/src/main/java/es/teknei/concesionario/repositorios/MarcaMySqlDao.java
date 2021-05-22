package es.teknei.concesionario.repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import es.teknei.concesionario.entidades.Marca;

class MarcaMySqlDao implements Dao<Marca>{
	
	private static final String SQL_SELECT = "SELECT m.id, m.nombre FROM marcas m";
	
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
			throw new AccesoDatosException("Error al obtener todas las marcas", e);
		}
	}
	

	

	private Marca mapearResultSetMarca(ResultSet rs) throws SQLException {
		Marca marca;
		marca = new Marca(rs.getLong("id"), rs.getString("nombre"));
		return marca;
	}


	

}
