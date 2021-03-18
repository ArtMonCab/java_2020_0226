package com.ipartek.formacion.ejemplofinal.accesodatos;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Configuración de la aplicacion. Indica que base de datos estamos usando.
 * 
 * @author Arturo Montañez
 * @version 1.0
 */

class Config {
	private static final String JDBC_MF0223_3 = "jdbc/mf0223_3";

	private Config() {}
	
	static final DataSource dataSource;
	
	static {
		try {
			InitialContext initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup(JDBC_MF0223_3);
		} catch (NamingException e) {
			throw new AccesoDatosException("No se ha encontrado el JNDI de MF0223_3", e);
		}
	}
}
