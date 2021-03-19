package com.ipartek.formacion.mf0223_3.accesodatos;

import com.ipartek.formacion.mf0223_3.entidades.Categoria;
import com.ipartek.formacion.mf0223_3.entidades.Origen;
import com.ipartek.formacion.mf0223_3.entidades.Plato;

/**
 * Selecciona que acceso a datos vamos a usar
 * 
 * @author Arturo Montañez
 *
 */
public class DaoFabrica {
	private DaoFabrica() {}

	private static final Dao<Plato> daoPlato = new PlatoDaoMySql();
	private static final Dao<Categoria> daoCategoria = new CategoriaDaoMySql();
	private static final Dao<Origen> daoOrigen = new OrigenDaoMySql();
	
	
	/**
	 * Metodo que devuelve el Dao del plato
	 * 
	 * @return the daoplato
	 */
	public static Dao<Plato> getDaoPlato() {
		return daoPlato;
	}
	
	
	/**
	 * Metodo que devuelve el Dao de la categoria
	 * 
	 * @return the daocategoria
	 */
	
	public static Dao<Categoria> getDaoCategoria() {
		return daoCategoria;
	}
	
	
	/**
	 * Metodo que devuelve el Dao del origen
	 * @return the daoorigen
	 */
	public static Dao<Origen> getDaoOrigen() {
		return daoOrigen;
	}
	
	

}
