package com.ipartek.formacion.uf1466_2.accesodatos;

import com.ipartek.formacion.uf1466_2.entidades.Libro;

public interface LibroDao extends Dao<Libro>{
	
	default Iterable<Libro> obtenerPorTitulo(String titulo) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	
	default Libro obtenerPorIsbn(String isbn) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	

	
}
