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

import com.ipartek.formacion.mf0223_3.entidades.Categoria;
import com.ipartek.formacion.mf0223_3.entidades.Comida;
import com.ipartek.formacion.mf0223_3.entidades.Procedencia;

/**
 * Implementa los métodos de Dao para comida
 * 
 * @author Arturo Montañez
 * @version 1.0
 */

public class ComidaDaoMySql implements Dao<Comida>{
	
	private static final String SQL_SELECT = "select p.id, p.nombre_plato, p.calorias, p.elaboracion, p.dificultad, c.id, c.nombre_categoria, p.id, p.nombre_procedencia \r\n"
			+ "from platos p \r\n"
			+ "left join categorias c on p.categorias_id = c.id\r\n"
			+ "left join procedencias p on p.procedencias_id = p.id";

	private DataSource dataSource = null;
	
	public ComidaDaoMySql() {
		try {
			InitialContext initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/mf0223_3");
		} catch (NamingException e) {
			throw new AccesoDatosException("No se ha encontrado el JNDI de mf0223_3", e);
		}
	}

	/**
	 * Obtiene todos los platos de la base de datos
	 * 
	 * @return comidas
	 */
	@Override
	public Iterable<Comida> obtenerTodos() {
		try(Connection con = dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)){
			ArrayList<Comida> comidas = new ArrayList<>();
			Categoria categoria;
			Procedencia procedencia;
			
			while (rs.next()) {
				procedencia = new Procedencia(rs.getLong("p.id"),rs.getString("p.procedencia"), null);
				
			}
			
			return comidas;
		}catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener todos los registros de comidas", e);
		}catch (Exception e) {
			throw new AccesoDatosException("ERROR NO ESPERADO: No se ha podido obtener todos los registros de comidas", e);
		}
	}

	/**
	 * Inserta un nuevo plato en la base de datos
	 * @param comida
	 * @return Comida
	 */
	@Override
	public Comida insertar(Comida comida) {
		// TODO Auto-generated method stub
		return Dao.super.insertar(objeto);
	}
	
	

}
