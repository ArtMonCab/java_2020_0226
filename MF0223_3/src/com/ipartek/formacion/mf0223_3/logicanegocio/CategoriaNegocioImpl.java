package com.ipartek.formacion.mf0223_3.logicanegocio;

import com.ipartek.formacion.mf0223_3.accesodatos.Dao;
import com.ipartek.formacion.mf0223_3.accesodatos.DaoFabrica;
import com.ipartek.formacion.mf0223_3.entidades.Categoria;

/**
 * Clase donde se implementan los m�todos de la interfaz CategoriaNegocio
 * 
 * @author Arturo Monta�ez
 * @version 1.0
 *
 */
public class CategoriaNegocioImpl implements CategoriaNegocio{
	private Dao<Categoria> daoCategoria = DaoFabrica.getDaoCategoria();

	/**
	 * M�todo donde saco el listado de todos las categorias
	 * 
	 * @return origenes
	 */
	@Override
	public Iterable<Categoria> listadoCategorias() {
		Iterable<Categoria> categorias = daoCategoria.obtenerTodos();
		return categorias;
	}
	
	/** M�todo donde se obtiene una categoria buscandola por su Id
	 * 
	 * @param  id coge como parametro el ID de la categoria
	 * @return Categoria
	 */
	@Override
	public Categoria categoriaPorId(Long id) {

		Categoria categoria = daoCategoria.obtenerPorId(id);
		return categoria;	
	}

}
