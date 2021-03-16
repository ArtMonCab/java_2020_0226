package com.ipartek.formacion.ejemplofinal.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ipartek.formacion.ejemplofinal.entidades.Cliente;

import lombok.extern.java.Log;

/**
 * Acceso a los datos de clientes, con todas las sentencias SQL que se usan
 * 
 * @author Arturo Montañez
 * @version 1.0
 */

@Log
class ClienteDaoMySql implements Dao<Cliente> {
	
	private static final String SQL_INSERT = "INSERT INTO clientes (nombre, apellidos, cif, fecha_nacimiento) VALUES (?, ?, ?, ?)";


	@Override
	/**
	 * Método en el que inserto un nuevo cliente
	 * @param cliente que hay que insertar
	 * @return el nuevo cliente
	 */
	public Cliente insertar(Cliente cliente) {
		try (Connection con = Config.dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
				) {
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellidos());
			ps.setString(3, cliente.getCif());
			ps.setObject(4, cliente.getFechaNacimiento());
			
			int num = ps.executeUpdate();
			
			if(num != 1) {
				throw new AccesoDatosException("Ha habido una incidencia en la inserción de cliente: " + num);
			}
			
			ResultSet rs = ps.getGeneratedKeys();
			
			rs.next();
			
			cliente.setId(rs.getLong(1));
			
			log.info(cliente.toString());
			
			return cliente;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al insertar el cliente " + cliente, e);
		}
	}
	
}
