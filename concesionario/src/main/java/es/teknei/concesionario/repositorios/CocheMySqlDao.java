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



import es.teknei.concesionario.entidades.Coche;

@Repository
class CocheMySqlDao implements DaoCoche{
	
	private static final String SQL_SELECT = "SELECT c.id, c.modelo, c.matricula, c.marca_id FROM coches c";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE c.id = ?";
	private static final String SQL_SELECT_MARCA = SQL_SELECT + " WHERE c.marca_id = ?";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public Set<Coche> obtenerTodos() {

		
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
		try (Connection con = dataSource.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);
				) {
			
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			Coche coche = null;

			if (rs.next()) {
				coche = mapearResultSetCoche(rs);
			}
			
			return coche;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener el coche con el id " + id, e);
		}
	}
	
	@Override
	public Set<Coche> obtenerPorMarca(long marcaId){
		try (Connection con = dataSource.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_MARCA);
				) {
			
			Set<Coche> coches = new HashSet<>();
			
			pst.setLong(1, marcaId);
			
			ResultSet rs = pst.executeQuery();
			
			Coche coche;

			while (rs.next()) {
				coche = mapearResultSetCoche(rs);
				
				coches.add(coche);
			}
			
			return coches;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener el coche con el id " + marcaId, e);
		}
	}
	private Coche mapearResultSetCoche(ResultSet rs) throws SQLException {
		Coche coche;
		coche = new Coche(rs.getLong("id"), rs.getString("modelo"), rs.getString("matricula"),null);
		return coche;
	}

}
