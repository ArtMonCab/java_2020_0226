package com.ipartek.formacion.uf1465_3.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ipartek.formacion.uf1465_3.entidades.Usuario;



public class UsuarioDaoMySql implements UsuarioDao {
	private static final String SQL_SELECT = "SELECT id, nombre, password FROM usuarios";
	private static final String SQL_SELECT_NOMBRE = SQL_SELECT + " WHERE nombre = ?";

	private DataSource dataSource = null;

	public UsuarioDaoMySql() {
		try {
			InitialContext initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/uf1465_3");
		} catch (NamingException e) {
			throw new AccesoDatosException("No se ha encontrado el JNDI de uf1465_3", e);
		}
	}

	@Override
	public Usuario obtenerPorNombre(String nombre) {
		try (Connection con = dataSource.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_NOMBRE);) {

			pst.setString(1, nombre);
			ResultSet rs = pst.executeQuery();

			Usuario usuario = null;

			if (rs.next()) {
				usuario = new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("password"));
			}

			return usuario;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el usuario cuyo nombre es: " + nombre, e);
		} catch (Exception e) {
			throw new AccesoDatosException(
					"ERROR NO ESPERADO: No se ha podido obtener el usuario cuyo email es: " + nombre, e);
		}
	}



	
	
}
