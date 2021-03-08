package com.ipartek.formacion.uf1466_2.accesodatos;

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

import com.ipartek.formacion.uf1466_2.entidades.Autor;
import com.ipartek.formacion.uf1466_2.entidades.Libro;

public class LibroDaoMySql implements LibroDao {
	
	private static final String SQL_SELECT = "SELECT  l.id, l.titulo, l.isbn, a.id, a.nombre, a.apellidos FROM libros l JOIN autores a ON l.autores_id = a.id";
	private static final String SQL_SELECT_TITULO = SQL_SELECT + " WHERE l.titulo like ?";
	private static final String SQL_SELECT_ISBN= SQL_SELECT + " WHERE l.isbn = ?";
	

	private DataSource dataSource = null;
	
	public LibroDaoMySql() {
		try {
			InitialContext initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/uf1466_2");
		} catch (NamingException e) {
			throw new AccesoDatosException("No se ha encontrado el JNDI de uf1466_2", e);
		}
	}

	@Override
	public Iterable<Libro> obtenerTodos() {
		try (Connection con = dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			
			ArrayList<Libro> libros = new ArrayList<>();
			Libro libro;
			Autor autor;

			while (rs.next()) {
				autor = new Autor(rs.getLong("a.id"), rs.getString("a.nombre"), rs.getString("a.apellidos"));

				libro = new Libro(rs.getLong("l.id"), rs.getString("l.titulo"), rs.getString("l.isbn"), autor);

				libros.add(libro);
			}

			return libros;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los registros de libros", e);
		} catch (Exception e) {
			throw new AccesoDatosException(
					"ERROR NO ESPERADO: No se han podido obtener todos los registros de libros", e);
		}
	}
	

	@Override
	public Iterable<Libro> obtenerPorTitulo(String titulo) {
		try (Connection con = dataSource.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_TITULO);) {

			pst.setString(1, titulo);
			ResultSet rs = pst.executeQuery();

			ArrayList<Libro> libros = new ArrayList<>();
			Libro libro;
			Autor autor;

			while (rs.next()) {
				autor = new Autor(rs.getLong("a.id"), rs.getString("a.nombre"), rs.getString("a.apellidos"));

				libro = new Libro(rs.getLong("l.id"), rs.getString("l.titulo"), rs.getString("l.isbn"), autor);

				libros.add(libro);
			}

			return libros;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el libro cuyo titulo es: " + titulo, e);
		} catch (Exception e) {
			throw new AccesoDatosException(
					"ERROR NO ESPERADO: No se ha podido obtener el libro cuyo titulo es: " + titulo, e);
		}
	}

	@Override
	public Iterable<Libro> obtenerPorIsbn(String isbn) {
		try (Connection con = dataSource.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ISBN);) {

			pst.setString(1, isbn);
			ResultSet rs = pst.executeQuery();

			ArrayList<Libro> libros = new ArrayList<>();
			Libro libro;
			Autor autor;

			while (rs.next()) {
				autor = new Autor(rs.getLong("a.id"), rs.getString("a.nombre"), rs.getString("a.apellidos"));

				libro = new Libro(rs.getLong("l.id"), rs.getString("l.titulo"), rs.getString("l.isbn"), autor);

				libros.add(libro);
			}

			return libros;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el libro cuyo isbn es: " + isbn, e);
		} catch (Exception e) {
			throw new AccesoDatosException(
					"ERROR NO ESPERADO: No se ha podido obtener el libro cuyo isbn es: " + isbn, e);
		}
	}

	
}
