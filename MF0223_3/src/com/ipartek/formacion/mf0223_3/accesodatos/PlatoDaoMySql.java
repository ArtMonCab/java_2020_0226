package com.ipartek.formacion.mf0223_3.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ipartek.formacion.mf0223_3.entidades.Categoria;
import com.ipartek.formacion.mf0223_3.entidades.Origen;
import com.ipartek.formacion.mf0223_3.entidades.Plato;


/**
 * Implementa los m�todos de Dao para Plato
 * 
 * @author Arturo Montañez
 * @version 1.0
 */

public class PlatoDaoMySql implements Dao<Plato>{
	
	private static final String SQL_SELECT = "select p.id, p.nombre_plato, p.calorias, p.elaboracion, p.dificultad, c.id, c.nombre_categoria, o.id, o.nombre_origen \r\n"
			+ "from platos p \r\n"
			+ "left join categorias c on p.categorias_id = c.id\r\n"
			+ "left join origenes o on p.origenes_id = o.id";
	private static final String SQL_INSERT = "INSERT INTO platos (nombre_plato, calorias, elaboracion, dificultad) VALUES (?,?,?,?)";

	private DataSource dataSource = null;
	
	/**
	 * Obtiene todos los platos de la base de datos
	 * 
	 * @return platos 
	 */
	@Override
	public Iterable<Plato> obtenerTodos() {
		try(Connection con = Config.dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)){
			ArrayList<Plato> platos = new ArrayList<>();
			Categoria categoria;
			Origen origen;
			Plato plato;
			
			while (rs.next()) {
				origen = new Origen(rs.getLong("o.id"), rs.getString("o.nombre_origen"), null);
				
				categoria = new Categoria(rs.getLong("c.id"), rs.getString("c.nombre_categoria"), null);
				
				plato = new Plato(rs.getLong("p.id"), rs.getString("p.nombre_plato"), rs.getInt("p.calorias"), rs.getString("p.elaboracion"), rs.getString("p.dificultad"), categoria, origen);
				
				platos.add(plato);
			}
			
			return platos;
		}catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener todos los registros de platos", e);
		}catch (Exception e) {
			throw new AccesoDatosException("ERROR NO ESPERADO: No se ha podido obtener todos los registros de comidas", e);
		}
	}

	/**
	 * Inserta un nuevo plato en la base de datos
	 * @param comida
	 * @return Plato 
	 */
	@Override
	public Plato insertar(Plato plato) {
		try (Connection con = Config.dataSource.getConnection()) {
			con.setAutoCommit(false);
			
			return insertarImpl(plato, con);
		} catch (Exception e) {
			throw new AccesoDatosException("Error al insertar el plato " + plato, e);
		}
	}
	
	
	private Plato insertarImpl(Plato plato, Connection con) throws SQLException {
		try (PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)){
		
			ps.setString(1, plato.getNombre_plato());
			ps.setInt(2, plato.getCalorias());
			ps.setString(3, plato.getElaboracion());
			ps.setString(4, plato.getDificultad());

			int num = ps.executeUpdate();

			if (num != 1) {
				throw new AccesoDatosException("Ha habido una incidencia en la inserción del plato: " + num);
			}

			ResultSet rs = ps.getGeneratedKeys();

			rs.next();

			plato.setId(rs.getLong(1));

			
			con.commit();

			return plato;
		} catch (Exception e) {
			con.rollback();
			throw new AccesoDatosException("Se ha hecho rollback", e);
		}
	}
}
