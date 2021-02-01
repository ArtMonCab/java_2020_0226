package com.ipartek.formacion.uf2177_2.accesodatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.ipartek.formacion.uf2177_2.entidades.Sorteo;

public class SorteoDaoJdbc implements Dao<Sorteo> {
	
	private String url, usuario, password;
	
	private static final SorteoDaoJdbc INSTANCIA = new SorteoDaoJdbc();
	
	private static final String SQL_SELECT = "SELECT id, num1, num2 ,num3 ,num4 ,num5 ,est1, est2, fecha FROM sorteos";

	private static final String SQL_INSERT = "INSERT INTO sorteos (num1, num2 ,num3 ,num4 ,num5 ,est1, est2, fecha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	public SorteoDaoJdbc() {
		try {
			Properties props = new Properties();
			//Meto la configuración de acceso a datos en un fichero de propiedades
			props.load(getClass().getClassLoader().getResourceAsStream("jdbc.properties"));
			
			//Cargo el driver
			Class.forName((String) props.getProperty("jdbc.driver"));
			
			//Cargo variables
			url = (String) props.getProperty("jdbc.url");
			usuario = props.getProperty("jdbc.usuario");
			password = props.getProperty("jdbc.password");
			
		}catch (Exception e) {
			throw new AccesoDatosException("No se ha podido leer el fichero de configuracion jdbc.properties", e);
		}

	}
	
	public static SorteoDaoJdbc getInstancia() {
		return INSTANCIA;
	}
	
	private Connection getConexion() {
		try {
			return DriverManager.getConnection(url, usuario, password);
		} catch (Exception e) {
			throw new AccesoDatosException("Fallo de conexión", e);
		}	
	}
	@Override
	public Iterable<Sorteo> obtenerTodos() {
		try (Connection con = getConexion();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			ArrayList<Sorteo> sorteos = new ArrayList<>();
			Sorteo Sorteo;
			
			while(rs.next()) {
				Sorteo = new Sorteo(rs.getLong("id"), rs.getInt("num1"), rs.getInt("num2"), rs.getInt("num3"), rs.getInt("num4"), rs.getInt("num5"), rs.getInt("est1"),  rs.getInt("est2"), rs.getDate("fecha"));
				
				sorteos.add(Sorteo);
			}
			
			return sorteos;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener todos los registros de Sorteos", e);
		}
	}



	@Override
	public Sorteo agregar(Sorteo sorteo) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

			
			pst.setInt(1, sorteo.getNum1());
			pst.setInt(2, sorteo.getNum2());
			pst.setInt(3, sorteo.getNum3());
			pst.setInt(4, sorteo.getNum4());
			pst.setInt(5, sorteo.getNum5());
			pst.setInt(6, sorteo.getEst1());
			pst.setInt(7, sorteo.getEst2());
			pst.setDate(8, new java.sql.Date(sorteo.getFecha().getTime()));
			
			
			
			int num = pst.executeUpdate();
			
			if(num != 1) {
				throw new AccesoDatosException("Se ha insertado más o menos de un registro ¿?¿?¿?¿?");
			}
			
			ResultSet rs = pst.getGeneratedKeys();
			
			if(rs.next()) {
				sorteo.setId(rs.getLong(1));
			} else {
				throw new AccesoDatosException("No se han podido obtener las claves autogeneradas");
			}
			
			return sorteo;
			
		} catch (Exception e) {
			throw new AccesoDatosException("Error al agregar el registro a sorteos", e);
		}
	}

	@Override
	public Sorteo obtenerPorId(Long id) {
		return null;
	}

	@Override
	public Sorteo modificar(Sorteo objeto) {
		return null;
	}

	@Override
	public Sorteo borrar(Long id) {
		return null;
	}

}
