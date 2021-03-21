package com.ipartek.formacion.mf0223_3.logicanegocio;


import com.ipartek.formacion.mf0223_3.accesodatos.Dao;
import com.ipartek.formacion.mf0223_3.accesodatos.DaoFabrica;
import com.ipartek.formacion.mf0223_3.entidades.Plato;

/**
 * Implementación de los métodos de la interfaz PlatoNegocio
 * 
 * @author Arturo Montañez
 * @version 1.0
 *
 */

public class PlatoNegocioImpl implements PlatoNegocio{
	private Dao<Plato> daoPlato = DaoFabrica.getDaoPlato();

	
	/**
	 * Método que saca el listado de todos los platos
	 * 
	 * @return platos 
	 */
	@Override
	public Iterable<Plato> listadoPlatos() {
		Iterable<Plato> platos = daoPlato.obtenerTodos();
		return platos;
	}
	
	
	/**
	 * Método donde inserto un nuevo plato en la base de datos
	 * 
	 * @param plato Es el nueo plato que quiero agregar
	 * @return Plato
	 */
	@Override
	public Plato agregarPlato(Plato plato) {
		return daoPlato.insertar(plato);
	}


}
