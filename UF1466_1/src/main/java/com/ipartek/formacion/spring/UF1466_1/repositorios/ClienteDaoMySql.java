package com.ipartek.formacion.spring.UF1466_1.repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.UF1466_1.entidades.Cliente;


@Repository
public class ClienteDaoMySql implements Dao<Cliente>{
	private static final String SQL_SELECT = "SELECT codigo, nombre, email, telefono, direccion, poblacion, codigopostal, identificador, activo  FROM cliente";
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	private static final String URL = "jdbc:mysql://localhost:3306/gestiondocente?serverTimezone=UTC";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Iterable<Cliente> obtenerTodos() {
		return jdbcTemplate.query(SQL_SELECT, new BeanPropertyRowMapper<Cliente>(Cliente.class));
	}

	@Override
	public String obtenerCampos() throws SQLException, ClassNotFoundException {
		
		String fila = "";
		
	    Class.forName(DRIVER);
	    Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery(SQL_SELECT);

	    ResultSetMetaData metadata = resultSet.getMetaData();
	    int numeroColumnas = metadata.getColumnCount();

	    ArrayList<String> columnas = new ArrayList<String>();
	    for (int i = 1; i <= numeroColumnas; i++) {
	      String nombreColumna = metadata.getColumnName(i);
	      columnas.add(nombreColumna);
	    }
	    
	    while (resultSet.next()) {
	      for (String nombreColumna : columnas) {	    	
	        String value = resultSet.getString(nombreColumna);
	        if (fila == "") {
	        	fila = fila + nombreColumna;
	        }else {
	        	fila = fila + ";" + nombreColumna;
	        }
	        
	      }
	     
	      break;
	    }
	    
		return fila;
	}




	

	
}
