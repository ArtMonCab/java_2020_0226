package com.ipartek.formacion.mf0223_3.accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ipartek.formacion.mf0223_3.entidades.Origen;
/**
 * Implementa los métodos de Dao para Origen
 * 
 * @author Arturo Montañez
 * @version 1.0
 */

public class OrigenDaoMySql implements Dao<Origen> {
	private static final String SQL_SELECT = "select id, nombre_origen FROM origenes";

	private DataSource dataSource = null;
	
	/**
	 * Genera una instancia de la clase
	 */
	public OrigenDaoMySql() {
		try {
			InitialContext initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/mf0223_3");
		} catch (NamingException e) {
			throw new AccesoDatosException("No se ha encontrado el JNDI de mf0223_3", e);
		}
	}
	
	 /** Obtiene todos los origenes de la base de datos
	 * 
	 * @return origenes
	 */
	@Override
	public Iterable<Origen> obtenerTodos() {
		try(Connection con = dataSource.getConnection();
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

}
