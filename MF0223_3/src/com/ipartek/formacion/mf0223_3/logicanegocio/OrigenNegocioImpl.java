package com.ipartek.formacion.mf0223_3.logicanegocio;

import com.ipartek.formacion.mf0223_3.accesodatos.Dao;
import com.ipartek.formacion.mf0223_3.accesodatos.DaoFabrica;
import com.ipartek.formacion.mf0223_3.entidades.Origen;

/**
 * Clase donde implemento los métodos de la interfaz OrigenNegocio
 * 
 * @author Arturo Montañez
 * @version 1.0
 *
 */
public class OrigenNegocioImpl implements OrigenNegocio{

	private Dao<Origen> daoOrigen = DaoFabrica.getDaoOrigen();

	/**
	 * Método donde saco el listado de todos los origenes
	 * 
	 * @return origenes
	 */
	@Override
	public Iterable<Origen> listadoOrigenes() {
		Iterable<Origen> origenes = daoOrigen.obtenerTodos();
		return origenes;
	}

	/** Método donde se obtiene un origen buscandola por su Id
	 * 
	 * @param  id coge como parametro el ID del origen
	 * @return Origen
	 */
	@Override
	public Origen origenPorId(Long id) {
		Origen origen = daoOrigen.obtenerPorId(id);
		return origen;
	}

}
