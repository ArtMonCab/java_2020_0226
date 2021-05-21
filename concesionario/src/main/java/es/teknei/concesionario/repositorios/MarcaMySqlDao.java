package es.teknei.concesionario.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import es.teknei.concesionario.entidades.Marca;

@Repository
class MarcaMySqlDao implements Dao<Marca>{
	
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
			throw new AccesoDatosException("Error al obtener todas las marcas", e);
		}
	}
	
	@Override
	public Marca obtenerPorId(Long id) {
		try (Connection con = dataSource.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);
				) {
			
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			Marca marca = null;

			if (rs.next()) {
				marca = mapearResultSetMarca(rs);
			}
			
			return marca;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener el marca con el id " + id, e);
		}
	}
	

	private Marca mapearResultSetMarca(ResultSet rs) throws SQLException {
		Marca marca;
		marca = new Marca(rs.getLong("id"), rs.getString("nombre"));
		return marca;
	}


	

}
