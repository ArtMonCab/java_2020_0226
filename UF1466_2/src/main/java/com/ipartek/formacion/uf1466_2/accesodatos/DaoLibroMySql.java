package com.ipartek.formacion.uf1466_2.accesodatos;

import java.util.Set;

import com.ipartek.formacion.uf1466_2.entidades.Libro;

public class DaoLibroMySql implements DaoLibro{

	@Override
	public Set<Libro> obtenerTodos() {
		// TODO Auto-generated method stub
		return DaoLibro.super.obtenerTodos();
	}

	@Override
	public Libro obtenerPorISBN(String isbn) {
		// TODO Auto-generated method stub
		return DaoLibro.super.obtenerPorISBN(isbn);
	}

}
