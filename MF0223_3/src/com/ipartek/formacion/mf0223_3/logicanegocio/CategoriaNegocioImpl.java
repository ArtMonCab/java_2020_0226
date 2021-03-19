package com.ipartek.formacion.mf0223_3.logicanegocio;

import com.ipartek.formacion.mf0223_3.accesodatos.Dao;
import com.ipartek.formacion.mf0223_3.accesodatos.DaoFabrica;
import com.ipartek.formacion.mf0223_3.entidades.Categoria;

public class CategoriaNegocioImpl implements CategoriaNegocio{
	private Dao<Categoria> daoCategoria = DaoFabrica.getDaoCategoria();

	@Override
	public Iterable<Categoria> listadoCategorias() {
		Iterable<Categoria> categorias = daoCategoria.obtenerTodos();
		return categorias;
	}

}
