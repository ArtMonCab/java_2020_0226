package com.ipartek.formacion.mf0223_3.accesodatos;

import java.util.Set;

/**
 * Interfaz donde se declaran los métodos con los datos
 * 
 * @author Arturo Montañez
 * @version 1.0
 * @param <T> Es el objeto que le vamso a pasar al Dao
 */
public interface Dao<T> {
	
	default Iterable<T> obtenerTodos(){
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	default T obtenerPorId(long id){
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	default T insertar(T objeto){
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	default T modificar (T objeto){
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	default void borrar(Long id){
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

}
