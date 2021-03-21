package com.ipartek.formacion.mf0223_3.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.ipartek.formacion.mf0223_3.entidades.Origen;
/**
 * Implementa los métodos de Dao para Origen
 * 
 * @author Arturo Montañez
 * @version 1.0
 */

public class OrigenDaoMySql implements Dao<Origen> {
	private static final String SQL_SELECT = "SELECT id, nombre_origen FROM origenes";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id = ?";

	private DataSource dataSource = null;
	
	
	 /** Obtiene todos los origenes de la base de datos
	 * 
	 * @return origenes
	 */
	@Override
	public Iterable<Origen> obtenerTodos() {
		try(Connection con = Config.dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)){
			ArrayList<Origen> origenes = new ArrayList<>();
			Origen origen;
			
			while (rs.next()) {
				
				origen = new Origen(rs.getLong("id"), rs.getString("nombre_origen"),null);
				
				origenes.add(origen);
			}
			
			return origenes;
		}catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener todos los registros de origenes", e);
		}catch (Exception e) {
			throw new AccesoDatosException("ERROR NO ESPERADO: No se ha podido obtener todos los registros de origenes", e);
		}
	}
	
	
	/** Optiene un origen por su id
	 * 
	 * @param id del origen
	 * @return Origen
	 */

	public Origen obtenerPorId(long id) {
		try (Connection con = Config.dataSource.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);
				) {
			
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			Origen origen = null;

			if (rs.next()) {
				origen = new Origen(rs.getLong("id"), rs.getString("nombre_origen"), null);
			}
			
			return origen;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener el origen id " + id, e);
		}
	}
}
