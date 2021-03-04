package com.ipartek.formacion.uf1466_2.accesodatos;

import com.ipartek.formacion.uf1466_2.entidades.Libro;

public interface DaoLibro extends Dao<Libro>{
	
	default Libro obtenerPorISBN(String isbn){
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

}
