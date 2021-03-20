package com.ipartek.formacion.mf0223_3.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.ipartek.formacion.mf0223_3.entidades.Categoria;


/**
 * Implementa los métodos de Dao para Categoria
 * 
 * @author Arturo Montañez
 * @version 1.0
 */
public class CategoriaDaoMySql implements Dao<Categoria> {

	private static final String SQL_SELECT = "SELECT id, nombre_categoria FROM categorias";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id = ?";

	private DataSource dataSource = null;
	
	
	 /** Obtiene todas las categorias de la base de datos
	 * 
	 * @return categorias
	 */
	@Override
	public Iterable<Categoria> obtenerTodos() {
		try(Connection con = Config.dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)){
			ArrayList<Categoria> categorias = new ArrayList<>();
			Categoria categoria;
			
			while (rs.next()) {
				
				categoria = new Categoria(rs.getLong("id"), rs.getString("nombre_categoria"),null);
				
				categorias.add(categoria);
			}
			
			return categorias;
		}catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener todos los registros de origenes", e);
		}catch (Exception e) {
			throw new AccesoDatosException("ERROR NO ESPERADO: No se ha podido obtener todos los registros de origenes", e);
		}
	}
	
	/** Optiene un origen por su id
	 * 
	 * @param id
	 * @return origen
	 */

	public Categoria obtenerPorId(long id) {
		try (Connection con = Config.dataSource.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);
				) {
			
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			Categoria categoria = null;

			if (rs.next()) {
				categoria = new Categoria(rs.getLong("id"), rs.getString("nombre_categoria"), null);
			}
			
			return categoria;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener el origen id " + id, e);
		}
	}

}
