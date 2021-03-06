package com.ipartek.formacion.spring.uf2177_1.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.ipartek.formacion.spring.uf2177_1.entidades.Medicamento;

public class MedicamentoDaoJdbc implements MedicamentoDao{
	private String url, usuario, password;
	
	private static final MedicamentoDaoJdbc INSTANCIA = new MedicamentoDaoJdbc();
	
	private static final String SQL_SELECT = "SELECT id, referencia, nombre, precio FROM medicamentos";

	private static final String SQL_INSERT = "INSERT INTO medicamentos (referencia, nombre, precio) VALUES (?, ?, ?)";

	private static final String SQL_DELETE_REFERENCIA = "DELETE FROM medicamentos WHERE referencia = ?";
	
	public MedicamentoDaoJdbc() {
		try {
			Properties props = new Properties();
			//En vez de hacerlo con spring puro, lo meto en un fichero de propiedades
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
	
	public static MedicamentoDaoJdbc getInstancia() {
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
	public Iterable<Medicamento> obtenerTodos() {
		try (Connection con = getConexion();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			ArrayList<Medicamento> medicamentos = new ArrayList<>();
			Medicamento medicamento;
			
			while(rs.next()) {
				medicamento = new Medicamento(rs.getLong("id"), rs.getString("referencia"), rs.getString("nombre"), rs.getBigDecimal("precio"));
				
				medicamentos.add(medicamento);
			}
			
			return medicamentos;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener todos los registros de medicamentos", e);
		}
	}

	@Override
	public Medicamento agregar(Medicamento medicamento) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
			
			pst.setString(1, medicamento.getReferencia());
			pst.setString(2, medicamento.getNombre());
			pst.setBigDecimal(3, medicamento.getPrecio());
			
			int num = pst.executeUpdate();
			
			if(num != 1) {
				throw new AccesoDatosException("Se ha insertado más o menos de un registro ¿?¿?¿?¿?");
			}
			
			ResultSet rs = pst.getGeneratedKeys();
			
			if(rs.next()) {
				medicamento.setId(rs.getLong(1));
			} else {
				throw new AccesoDatosException("No se han podido obtener las claves autogeneradas");
			}
			
			return medicamento;
			
		} catch (Exception e) {
			throw new AccesoDatosException("Error al agregar el registro a medicamentos", e);
		}
	}

	@Override
	public void borrar(String referencia) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE_REFERENCIA, Statement.RETURN_GENERATED_KEYS)) {
			
			pst.setString(1, referencia);
			
			int num = pst.executeUpdate();
			
			if(num != 1) {
				throw new AccesoDatosException("Se ha intentado borrar una referencia no existente");
			}
			
		} catch (Exception e) {
			throw new AccesoDatosException("Error al borrar el registro de medicamentos", e);
		}
	}
	
}
